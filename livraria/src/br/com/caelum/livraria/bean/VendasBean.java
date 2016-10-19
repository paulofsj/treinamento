package br.com.caelum.livraria.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.MeterGaugeChartModel;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.modelo.Venda;

@ManagedBean
@ViewScoped
public class VendasBean {

   public List<Venda> getVendas(long seed) {

       List<Livro> livros = new DAO<Livro>(Livro.class).listaTodos();
       List<Venda> vendas = new ArrayList<Venda>();

       Random random = new Random(seed);

       for (Livro livro : livros) {
           Integer quantidade = random.nextInt(1500);
           vendas.add(new Venda(livro, quantidade));
       }

       return vendas;
   }
   
   public BarChartModel getVendasModel() {

	    BarChartModel model = new BarChartModel();

	    ChartSeries vendaSerie = new ChartSeries();
	    vendaSerie.setLabel("Vendas 2016");

	    List<Venda> vendas = getVendas(System.currentTimeMillis());

	    for (Venda venda : vendas) {
	        vendaSerie.set(venda.getLivro().getTitulo(), venda.getQuantidade());
	    }

	    model.addSeries(vendaSerie);

	    ChartSeries vendaSerie2015 = new ChartSeries();
	    vendaSerie2015.setLabel("Vendas 2015");

	    vendas = getVendas(System.currentTimeMillis());

	    for (Venda venda : vendas) {
	        vendaSerie2015.set(venda.getLivro().getTitulo(), venda.getQuantidade());
	    }

	    model.addSeries(vendaSerie2015);

	    return model;
	}
   
   public MeterGaugeChartModel getMeterGaugeModel1() {
	   final int n = 1600;
       List<Number> intervals = new ArrayList<Number>(){{
           add((int)n/4);
           add((int)n/3);
           add((int)n/2);
           add(n);
       }};
       List<Venda> vendas = getVendas(System.currentTimeMillis());
       
	   MeterGaugeChartModel meterGaugeModel1 = new MeterGaugeChartModel(vendas.get(0).getQuantidade(), intervals);
	   meterGaugeModel1.setTitle(vendas.get(0).getLivro().getTitulo());
       meterGaugeModel1.setGaugeLabel("Vendas");
       meterGaugeModel1.setSeriesColors("#ffffff");
       return meterGaugeModel1;
   }
  
}				
