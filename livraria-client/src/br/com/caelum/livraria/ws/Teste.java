package br.com.caelum.livraria.ws;

import java.rmi.RemoteException;

public class Teste {

	public static void main(String[] args) throws RemoteException {
		LivrariaWS livrariaWS = new LivrariaWSProxy();
		for (Livro livro : livrariaWS.getLivrosPeloNome("")) {
			System.out.println(livro.getTitulo() +": "+livro.getAutor().getNome());
		}
		

	}

}
