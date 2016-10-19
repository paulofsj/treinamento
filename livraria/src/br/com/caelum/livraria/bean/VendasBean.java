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

	private double psup;
	private double psb;
	private double pinj;
	
	final int n = 1600;
    List<Number> intervals = new ArrayList<Number>(){{
        add((int)n/4);
        add((int)n/3);
        add((int)n/2);
        add(n);
    }};
    
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
   
   public MeterGaugeChartModel getMeterGaugeModelPSUP() {
	   MeterGaugeChartModel meterGaugeModelPSUP = new MeterGaugeChartModel(psup, intervals);
	   meterGaugeModelPSUP.setIntervalOuterRadius(0);
	   meterGaugeModelPSUP.setIntervalInnerRadius(0);
	   meterGaugeModelPSUP.setLabelHeightAdjust(100);
//	   meterGaugeModelPSUP.setGaugeLabel("RPM");
//	   meterGaugeModelPSUP.setGaugeLabelPosition("bottom");
//       meterGaugeModel1.setGaugeLabel("RPM");
	   meterGaugeModelPSUP.setSeriesColors("#ffffff,#ffffff,#ffffff,#ffffff");
       return meterGaugeModelPSUP;
   }
   
   public MeterGaugeChartModel getMeterGaugeModelPSB() {
	   MeterGaugeChartModel meterGaugeModelPSUP = new MeterGaugeChartModel(psb, intervals);
	   meterGaugeModelPSUP.setIntervalOuterRadius(0);
	   meterGaugeModelPSUP.setIntervalInnerRadius(0);
	   meterGaugeModelPSUP.setLabelHeightAdjust(100);
//	   meterGaugeModelPSUP.setGaugeLabel("RPM");
//	   meterGaugeModelPSUP.setGaugeLabelPosition("bottom");
//       meterGaugeModel1.setGaugeLabel("RPM");
	   meterGaugeModelPSUP.setSeriesColors("#ffffff,#ffffff,#ffffff,#ffffff");
       return meterGaugeModelPSUP;
   }
   
   public MeterGaugeChartModel getMeterGaugeModelPINJ() {
	   MeterGaugeChartModel meterGaugeModelPSUP = new MeterGaugeChartModel(pinj, intervals);
	   meterGaugeModelPSUP.setIntervalOuterRadius(0);
	   meterGaugeModelPSUP.setIntervalInnerRadius(0);
	   meterGaugeModelPSUP.setLabelHeightAdjust(100);
//	   meterGaugeModelPSUP.setGaugeLabel("RPM");
//	   meterGaugeModelPSUP.setGaugeLabelPosition("bottom");
//       meterGaugeModel1.setGaugeLabel("RPM");
	   meterGaugeModelPSUP.setSeriesColors("#ffffff,#ffffff,#ffffff,#ffffff");
       return meterGaugeModelPSUP;
   }
   
   public void initMeterGaugeModel1(){
	   
       Random random = new Random(System.currentTimeMillis());
       psup = random.nextInt(n);
       pinj = random.nextInt(n);
       psb = random.nextInt(n);       
	  
   }

public double getPsup() {
	return psup;
}

public void setPsup(double psup) {
	this.psup = psup;
}

public double getPsb() {
	return psb;
}

public void setPsb(double psb) {
	this.psb = psb;
}

public double getPinj() {
	return pinj;
}

public void setPinj(double pinj) {
	this.pinj = pinj;
}

public List<Number> getIntervals() {
	return intervals;
}

public void setIntervals(List<Number> intervals) {
	this.intervals = intervals;
}
   
   
   
  
}				
