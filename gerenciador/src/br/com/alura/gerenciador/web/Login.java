/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.web;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        
        PrintWriter writer = resp.getWriter();
        
        Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
        if(usuario == null){
            writer.println("<html><body>Usuário ou senha inválida</body></html>");
        }else{
            req.getSession().setAttribute("usuarioLogado", usuario);
            writer.println("<html><body>Usuário "+ usuario.getEmail() +"</body></html>");
        }
        
    }
    
    
}
