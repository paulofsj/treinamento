package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {
	
	@AroundInvoke
	 public Object intercepta(InvocationContext contex) throws Exception {

		    long millis = System.currentTimeMillis();

		    Object o = contex.proceed();

		    String classe = contex.getTarget().getClass().getSimpleName();
		    String metodo = contex.getMethod().getName();
		    System.out.println("Classe: " +classe+ " -> "+metodo +": " 
		         + (System.currentTimeMillis() - millis) + "ms");

		    return o;

		}


}
