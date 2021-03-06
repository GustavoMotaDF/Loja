/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavajato.lojadompedroprimeiro.Servlets;

import com.lavajato.lojadompedroprimeiro.BO.UsuarioBO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gustavo
 */
@WebServlet(name = "Companheiro", urlPatterns = {"/Companheiro"})
public class Companheiro extends HttpServlet {
    private final UsuarioBO usuariobo = new UsuarioBO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         HttpSession sessao = req.getSession();

        String login = (String) sessao.getAttribute("login");        
        if (login == null || login.isEmpty()) {
            req.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                        + "<strong> Você foi deslogado, faça login novamente para ter acesso ao sistema! </strong>"
                        + "</div>"
                        + "<script>$().ready(function() {\n"
                        + "	setTimeout(function () {\n"
                        + "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n"
                        + "	}, 15000); // O valor é representado em milisegundos.\n"
                        + "});</script>");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            
        }else{         
            try{
                 
                req.setAttribute("login1" ,usuariobo.getPermissao2(login));
                
                req.getRequestDispatcher("Paginas/companheiro.jsp").forward(req, resp);
                
            }catch(Exception erro){
                req.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                        + "<strong>"+erro+"</strong>"
                        + "</div>"
                        + "<script>$().ready(function() {\n"
                        + "	setTimeout(function () {\n"
                        + "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n"
                        + "	}, 15000); // O valor é representado em milisegundos.\n"
                        + "});</script>");
                req.getRequestDispatcher("inicio.jsp").forward(req, resp);
            }
           
        }
         
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sessao = req.getSession();

        String login = (String) sessao.getAttribute("login");
        if (login == null || login.isEmpty()) {
            req.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                        + "<strong> Você foi deslogado, faça login novamente para ter acesso ao sistema! </strong>"
                        + "</div>"
                        + "<script>$().ready(function() {\n"
                        + "	setTimeout(function () {\n"
                        + "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n"
                        + "	}, 15000); // O valor é representado em milisegundos.\n"
                        + "});</script>");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            
        }else{         
            try{
                 
                req.setAttribute("login1" ,usuariobo.getPermissao2(login));
                req.getRequestDispatcher("Paginas/companheiro.jsp").forward(req, resp);
                
            }catch(Exception erro){
                req.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                        + "<strong>"+erro.getMessage()+"</strong>"
                        + "</div>"
                        + "<script>$().ready(function() {\n"
                        + "	setTimeout(function () {\n"
                        + "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n"
                        + "	}, 15000); // O valor é representado em milisegundos.\n"
                        + "});</script>");
                req.getRequestDispatcher("inicio.jsp").forward(req, resp);
            }
        }
    }


}