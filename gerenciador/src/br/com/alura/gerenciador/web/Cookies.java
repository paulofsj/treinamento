/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

/**
 *
 * @author acpm
 */
public class Cookies {
    
    private Cookie[] cookies;

    public Cookies(Cookie[] cookies) {
        this.cookies = cookies;
    }

    public Cookie getusuarioLogado(){
        if(cookies == null) return null;
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("usuario.logado"))
                return cookie;
        }
        return null;
    }
 
}
