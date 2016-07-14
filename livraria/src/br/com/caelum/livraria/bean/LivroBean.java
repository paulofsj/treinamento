package br.com.caelum.livraria.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;

@ManagedBean
@ViewScoped
public class LivroBean {

	private Livro livro = new Livro();
	
	private Integer autorId;
	
	
	public Livro getLivro() {
		return livro;
	}
	
	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	
	public List<Autor> getAutores(){
		return new DAO<Autor>(Autor.class).listaTodos();
	}
	
	public void gravarAutor(){
		Autor autor = new DAO<Autor>(Autor.class).buscaPorId(this.autorId);
		this.livro.adicionaAutor(autor);
	}

	public void gravar() {
		System.out.println("Gravando livro " + this.livro.getTitulo());

		if (livro.getAutores().isEmpty()) {
			 FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("Livro deve ter pelo menos um Autor."));
		}

		if(livro.getId() != null) new DAO<Livro>(Livro.class).atualiza(this.livro);
		else new DAO<Livro>(Livro.class).adiciona(this.livro);
		
		this.livro = new Livro();
	}
	
	public void remover(Livro livro){
		System.out.println("removendo livro " + livro.getTitulo());
		new DAO<Livro>(Livro.class).remove(livro);
	}

	public List<Autor> getAutoresDoLivro() {
		return this.livro.getAutores();
	}
	
	public List<Livro> getLivros() {
		  return new DAO<Livro>(Livro.class).listaTodos();
	}
	
	public void seleciona(Livro livro){
		
		this.livro = (new DAO<Livro>(Livro.class)).carregaAutores(livro);
	}
	
	public void comecaComDigitoUm(FacesContext context, UIComponent component, Object value){
		String isbn = (String) value;
		if(!isbn.startsWith("9")){
			FacesMessage message = new FacesMessage("ISBN deve começar com 9");
			throw new ValidatorException(message);
		}
	}
	
	
}
