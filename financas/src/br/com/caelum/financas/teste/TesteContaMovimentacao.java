/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author acpm
 */
public class TesteContaMovimentacao {

    public static void main(String[] args) {
        EntityManager manager = new JPAUtil().getEntityManager();

        Query query = manager.createQuery("select distinct c from Conta c join fetch c.movimentacoes where c.id = :cID");
        query.setParameter("cID", 2);

        Conta conta = (Conta) query.getSingleResult();
            
        System.out.println(conta.getMovimentacoes().size());

    }

}
