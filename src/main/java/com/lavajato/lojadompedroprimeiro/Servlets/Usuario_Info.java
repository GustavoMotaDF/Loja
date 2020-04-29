/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavajato.lojadompedroprimeiro.Servlets;

import com.lavajato.lojadompedroprimeiro.BO.UsuarioBO;
import java.io.IOException;
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
@WebServlet(name = "Usuario_Info", urlPatterns = {"/Usuario-Info"})
public class Usuario_Info extends HttpServlet {

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
        } 
            
            
            if (Objects.nonNull(req.getParameter("cadastrar"))) {
                try {
                    usuariobo.cadastrarUsuário(req.getParameter("nome"),
                            req.getParameter("login"),
                            req.getParameter("senha"),
                            req.getParameter("grau"));

                    req.setAttribute("mensagemSucesso", "<div id=\"foo\" class=\"alert alert-success\" role=\"alert\"> <strong> Usuário Cadastrado com sucesso! </strong> </div>"
                            + "<script>$().ready(function() {\n"
                            + "	setTimeout(function () {\n"
                            + "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n"
                            + "	}, 10000); // O valor é representado em milisegundos.\n"
                            + "});</script>");

                } catch (Exception erro) {
                    req.setAttribute("mensagemErro", "<div id=\"foo\" class=\"alert alert-warning\" role=\"alert\"><strong>" + erro.getMessage() + "</strong></div>"
                            + "<script>$().ready(function() {\n"
                            + "	setTimeout(function () {\n"
                            + "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n"
                            + "	}, 10000); // O valor é representado em milisegundos.\n"
                            + "});</script>");
                }
            } else if (Objects.nonNull(req.getParameter("excluir"))) {
                try {
                    usuariobo.excluirUsuario(req.getParameter("idusuario"));
                    req.setAttribute("mensagemSucesso", "<div id=\"foo\"  class=\"alert alert-success\" role=\"alert\">Usuário Arquivado com Sucesso</div>"
                            + "<script>\n"
                            + "                    $().ready(function () {\n"
                            + "                        setTimeout(function () {\n"
                            + "                            $('#foo').hide();\n"
                            + "                        }, 10000);\n"
                            + "                    });\n"
                            + "                </script>\n"
                            + "");

                } catch (Exception erro) {
                    req.setAttribute("mensagemErro", "<div id=\"foo\"  class=\"alert alert-warning\" role=\"alert\">" + erro.getMessage() + "</div>"
                            + "<script>\n"
                            + "                    $().ready(function () {\n"
                            + "                        setTimeout(function () {\n"
                            + "                            $('#foo').hide();\n"
                            + "                        }, 10000);\n"
                            + "                    });\n"
                            + "                </script>\n"
                            + "");

                }
                

            } else if (Objects.nonNull(req.getParameter("editar"))) {
                try {
                    req.setAttribute("usuarioEditando", usuariobo.getUsuario(req.getParameter("idusuario")));
                } catch (Exception erro) {
                    req.setAttribute("mensagemErro", "<div id=\"foo\" class=\"alert alert-warning\" role=\"alert\"><strong>" + erro + " </strong></div>"
                            + "<script>$().ready(function() {\n"
                            + "	setTimeout(function () {\n"
                            + "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n"
                            + "	}, 10000); // O valor é representado em milisegundos.\n"
                            + "});</script>");
                }
            } else if (Objects.nonNull(req.getParameter("alterar"))) {
                try {
                    usuariobo.editarUsuario(req.getParameter("idusuario"),
                            req.getParameter("nome"),
                            req.getParameter("login"),
                            req.getParameter("senha"),
                            req.getParameter("grau"));
                    req.setAttribute("mensagemSucesso", "<div id=\"foo\" class=\"alert alert-success\" role=\"alert\"> <strong> Usuário alterado com Sucesso! </strong> </div>"
                            + "<script>$().ready(function() {\n"
                            + "	setTimeout(function () {\n"
                            + "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n"
                            + "	}, 10000); // O valor é representado em milisegundos.\n"
                            + "});</script>");

                } catch (Exception erro) {
                    req.setAttribute("mensagemErro", "<div id=\"foo\" class=\"alert alert-warning\" role=\"alert\"><strong>" + erro + "</strong></div>"
                            + "<script>$().ready(function() {\n"
                            + "	setTimeout(function () {\n"
                            + "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n"
                            + "	}, 10000); // O valor é representado em milisegundos.\n"
                            + "});</script>");
                }
                
            }
            try {
                req.setAttribute("servicos", usuariobo.getCaixa());

            } catch (Exception erro) {
                req.setAttribute("mensagemErro", "<div id=\"foo\" class=\"alert alert-warning\" role=\"alert\">" + erro.getMessage() + "</div>"
                        + "<script>\n"
                        + "                    $().ready(function () {\n"
                        + "                        setTimeout(function () {\n"
                        + "                            $('#foo').hide();\n"
                        + "                        }, 10000);\n"
                        + "                    });\n"
                        + "                </script>\n"
                        + "");
            }
        
       
         try{
                 
                req.setAttribute("login1" ,usuariobo.getPermissao4(login));
                 req.getRequestDispatcher("Paginas/usuarios.jsp").forward(req, resp);
                
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

        }

            try {
                req.setAttribute("servicos", usuariobo.getCaixa());
                

            } catch (Exception erro) {
                req.setAttribute("mensagemErro", "<div id=\"foo\" class=\"alert alert-warning\" role=\"alert\">" + erro.getMessage() + "</div>"
                        + "<script>\n"
                        + "                    $().ready(function () {\n"
                        + "                        setTimeout(function () {\n"
                        + "                            $('#foo').hide();\n"
                        + "                        }, 10000);\n"
                        + "                    });\n"
                        + "                </script>\n"
                        + "");
            }            
        
             try{
                 
                req.setAttribute("login1" ,usuariobo.getPermissao4(login));
                 req.getRequestDispatcher("Paginas/usuarios.jsp").forward(req, resp);
                
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
