package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.interceptador.LogInterceptador;
import br.com.caelum.livraria.modelo.Livro;

@Stateless
@Interceptors(value = { LogInterceptador.class })
public class LivroDao {

	@PersistenceContext
	private EntityManager manager;

	public void salva(Livro livro) {
		manager.persist(livro);
	}

	public List<Livro> todosLivros() {
		return manager.createQuery("select l from Livro l", Livro.class).getResultList();
	}

	public List<Livro> livrosPeloNome(String titulo) {
		TypedQuery<Livro> query = this.manager
                .createQuery(
                        "select l from Livro l where l.titulo like :pTitulo",
                        Livro.class);
        query.setParameter("pTitulo", "%" + titulo + "%");
        return query.getResultList();
	}

}
