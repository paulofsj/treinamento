package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	Map<Usuario, Integer> qtdLances = new HashMap<Usuario, Integer>();
	
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) {
		int n = numeroDelancesDo(lance.getUsuario());
		if(lances.isEmpty() || usuarioDiferenteDoUltimoLance(lance.getUsuario()) && n <= 5 )
			lances.add(lance);
	}

	private int numeroDelancesDo(Usuario usuario) {
		if(!qtdLances.containsKey(usuario)){
			qtdLances.put(usuario, 1);
			return 1;
		}
		int num = qtdLances.get(usuario);
		qtdLances.put(usuario, num+1);
		return num+1;
	}
	
	public void dobraLance(Usuario usuario){
		if(qtdLances.containsKey(usuario)){
			this.propoe(new Lance(usuario, lances.get(lances.size()-1).getValor()*2 ));
		}
	}

	private boolean usuarioDiferenteDoUltimoLance(Usuario usu) {
		return !usu.equals(lances.get(lances.size()-1).getUsuario());
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	
	
}