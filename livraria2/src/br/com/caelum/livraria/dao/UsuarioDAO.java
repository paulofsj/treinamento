package br.com.caelum.livraria.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Usuario;
;

public class UsuarioDAO {

	public boolean validarUsuario(Usuario usuario) {
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Usuario> query = em
				.createQuery("select u from Usuario u where u.email = :pEmail and u.senha = :pSenha", Usuario.class);
		query.setParameter("pEmail", usuario.getEmail());
		query.setParameter("pSenha", usuario.getSenha());
		Usuario resul;
		try {
			resul = query.getSingleResult();
		} catch (NoResultException notFoException) {
			return false;
		} finally {
			em.close();
		}
		System.out.println("xunda");
		return resul != null;
	}

}
