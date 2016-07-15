package br.com.caelum.livraria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;

@ManagedBean
@ViewScoped
public class AutorBean {

	private Autor autor = new Autor();

	public Autor getAutor() {
		return autor;
	}

	public void alterarAutor(Autor autor){
		this.autor = autor;
	}
	
	public void gravar() {
		System.out.println("Gravando autor " + this.autor.getNome() +" - "+this.autor.getId()) ;

		if(this.autor.getId() == null) new DAO<Autor>(Autor.class).adiciona(this.autor);
		else new DAO<Autor>(Autor.class).atualiza(this.autor);
		
		this.autor = new Autor();
	}
	
	public List<Autor> getAutores(){
		return new DAO<Autor>(Autor.class).listaTodos();
	}
	
	public void removerAutor(Autor autor){
		new DAO<Autor>(Autor.class).remove(autor);
	}
}
