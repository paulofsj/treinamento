/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.web;

import br.com.alura.gerenciador.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {
    
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        Usuario usuarioLogado = (Usuario) ((HttpServletRequest) request).getSession().getAttribute("usuarioLogado");
        String usuario = "<deslogado>";
        if (usuarioLogado != null) {
            usuario = usuarioLogado.getEmail();
        }

        System.out.println("Usuario " + usuario + " acessando a URI "
                + ((HttpServletRequest) request).getRequestURI());

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
