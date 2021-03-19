package com.lavajato.lojadompedroprimeiro.Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.lavajato.lojadompedroprimeiro.BO.UsuarioBO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
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
@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {
private final UsuarioBO usuariobo = new UsuarioBO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          HttpSession session = req.getSession();
        if (Objects.nonNull(req.getParameter("logar"))) {
            try {

                req.setAttribute("Bemvindo", "<div id=\"myModal\" class=\"modal\">                            \n"
                        + "            <div class=\"modal-content\"> \n"
                        + "                <div class=\"input-group mb-3\">\n"
                        + "                    <div class=\"input-group-prepend\">\n"
                        + "                        <span class=\"input-group-text close \" onclick=\"fechar()\">&times;</span>\n"
                        + "                    </div>\n"
                        + "                </div> \n"
                        + "                <div class=\"mensagem\">\n"
                        + "                    <p class=\"p\">Bem vindo, "+req.getParameter("login")+"!<br> Verifique suas notificações</p>\n"
                        + "                </div>\n"
                        + "                <br>\n"
                        + "                <div>\n"
                        + "                    <button class=\"btn btn-light\" onclick=\"fechar()\">OK</button>\n"
                        + "                    \n"
                        + "                </div>                                \n"
                        + "            </div>\n"
                        + "        </div> "
                        + "<link rel=\"stylesheet\" href=\"jsp/css/modal.css\">"
                        + "<script type=\"text/javascript\" src=\"jsp/js/modal.js\"></script>  ");
                req.setAttribute("Login", usuariobo.getLogin(req.getParameter("login"), req.getParameter("senha")));
                
                session.isNew();
                session.setAttribute("login", req.getParameter("login"));
                
                req.getRequestDispatcher("inicio.jsp").forward(req, resp);
            }catch(Exception erro){
                req.setAttribute("mensagemErro", "<div id=\"foo\" class=\"alert alert-warning\" role=\"alert\">" + erro.getMessage() + "</div>"
                        + "<script>\n"
                        + "                    $().ready(function () {\n"
                        + "                        setTimeout(function () {\n"
                        + "                            $('#foo').hide();\n"
                        + "                        }, 10000);\n"
                        + "                    });\n"
                        + "                </script>\n"
                        + "");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
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
            req.getRequestDispatcher("inicio.jsp").forward(req, resp);
        }
    }
 
}
