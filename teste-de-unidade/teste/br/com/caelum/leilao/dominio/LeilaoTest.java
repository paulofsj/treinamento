package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.caelum.leilao.servico.Avaliador;

public class LeilaoTest {
	
	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario(){
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(maria,100.0));
		leilao.propoe(new Lance(jose,250.0));
		leilao.propoe(new Lance(jose,400.0));
		

		// executando a acao
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		
		assertEquals(2,leilao.getLances().size());
		assertEquals(250.0, leilao.getLances().get(leilao.getLances().size()-1).getValor(), 0.00001);
	}
	
	@Test
	public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario(){
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		
		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(jose,250.0));
		leilao.propoe(new Lance(joao,300.0));
		leilao.propoe(new Lance(jose,400.0));
		leilao.propoe(new Lance(joao,500.0));
		leilao.propoe(new Lance(jose,600.0));
		leilao.propoe(new Lance(joao,700.0));
		leilao.propoe(new Lance(jose,800.0));
		leilao.propoe(new Lance(joao,900.0));
		leilao.propoe(new Lance(jose,1000.0));
		leilao.propoe(new Lance(joao,1100.0));
		leilao.propoe(new Lance(jose,1200.0));
		
		// executando a acao
		Avaliador leiloeiro = new Avaliador();
		
		leiloeiro.avalia(leilao);
		

		assertEquals(10,leilao.getLances().size());
		assertEquals(1100.0, leilao.getLances().get(leilao.getLances().size()-1).getValor(), 0.00001);
	}
	
	@Test
	public void deveDobrarOUltimoLanceDado(){
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Usuario paulo = new Usuario("Paulo");
		
		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(paulo,150.0));
		leilao.propoe(new Lance(jose,250.0));
		leilao.propoe(new Lance(joao,300.0));
		leilao.propoe(new Lance(jose,400.0));
		leilao.propoe(new Lance(joao,500.0));
		leilao.propoe(new Lance(jose,600.0));
		leilao.propoe(new Lance(joao,700.0));
		leilao.propoe(new Lance(jose,800.0));
		leilao.propoe(new Lance(joao,900.0));
		leilao.propoe(new Lance(jose,1000.0));
		leilao.propoe(new Lance(joao,1100.0));
		leilao.propoe(new Lance(jose,1200.0));
		leilao.dobraLance(maria);
		leilao.dobraLance(paulo);
		
		// executando a acao
		Avaliador leiloeiro = new Avaliador();
		
		leiloeiro.avalia(leilao);
		

		assertEquals(12,leilao.getLances().size());
		assertEquals(2200.0, leilao.getLances().get(leilao.getLances().size()-1).getValor(), 0.00001);
	}

}
