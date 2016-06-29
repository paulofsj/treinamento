/**
 * LivrariaWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.caelum.livraria.ws;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;

@WebService
@Stateless
public class LivrariaWS {

    @Inject
    LivroDao dao;

    @WebResult(name="autores")
    public List<Livro> getLivrosPeloNome(@WebParam(name="titulo") String nome) {

        System.out.println("LivrariaWS: procurando pelo nome " + nome);
        return dao.livro sPeloNome(nome);
    }

}		
