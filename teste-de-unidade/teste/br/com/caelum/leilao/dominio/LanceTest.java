package br.com.caelum.leilao.dominio;

import org.junit.Test;

public class LanceTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveAceitarLanceComValorMenorQueZero(){
		new Lance(new Usuario("Paulo"),-1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void naoDeveAceitarLanceComValorIgualAZero(){
		new Lance(new Usuario("Paulo"),0);
	}
}
