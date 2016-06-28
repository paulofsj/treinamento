/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.web;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        String filtro = req.getParameter("filtro");
        Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
        req.setAttribute("empresas", empresas);
        
        req.getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp").forward(req, resp);
    }

}
