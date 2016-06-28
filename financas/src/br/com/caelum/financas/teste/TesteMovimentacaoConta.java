/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author acpm
 */
public class TesteMovimentacaoConta {
    
    public static void main(String[] args) {
        
        EntityManager manager = new JPAUtil().getEntityManager();

        Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes");

        List<Conta> contas = query.getResultList();
        
        for (Conta conta : contas) {
            System.out.println(conta.getMovimentacoes().size());
        }
    }
}
