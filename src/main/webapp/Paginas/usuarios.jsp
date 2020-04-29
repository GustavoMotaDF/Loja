<%-- 
    Document   : index
    Created on : 11/04/2020, 01:08:51
    Author     : gustavo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>         
        <title>Usuários</title>
        <jsp:include page="../includes/css.jsp"/>
    </head>
    <body>
        <header>
            <jsp:include page="../includes/menu.jsp"/>
        </header>

        <div class="container">    
            <div class="col-md-6">
                <h2> ${mensagemErro}
                    ${mensagemSucesso}</h2>
                <form action="${pageContext.request.contextPath}/Usuario-Info" method="post">

                    <h4>/Usuários</h4>    
                    <c:if test="${ empty usuarioEditando}">  

                        <label>Nome:</label>
                        <input type="text" name="nome" placeholder="Nome" class="form-control"/>
                        <label>Login:</label>
                        <input type="text" name="login" placeholder="login" class="form-control"/>
                        <label>Senha:</label>
                        <div class="input-group">
                            <input type="password" name="senha" id="senha" placeholder="senha" class="form-control"/>
                            <span class="input-group-btn">
                               <input type="button" id="showPassword" value="Mostrar" class="btn btn-light" />
                            </span>
                        </div>                         
                        <label>Grau de acesso:</label>
                        <input type="text" name="grau" placeholder="grau"class="form-control"/><br>
                        <div class="form-group text-right">
                            <input type="submit" name="cadastrar" value="Cadastrar" class="btn btn-success "/>                       
                            <input type="reset" name="cancelar" value="Cancelar" class="btn btn-warning"/><br>  
                        </div>

                    </c:if>  
                    <c:if test="${ not empty usuarioEditando}">
                        <input type="hidden" name="idusuario" value="${usuarioEditando.idusuario}"/> 

                        <label>Nome:</label>
                        <input type="text" name="nome" placeholder="Nome" value="${usuarioEditando.nome}" class="form-control"/>
                        <label>Login:</label>
                        <input type="text" name="login" placeholder="login" value="${usuarioEditando.login}" class="form-control"/>
                        <label>Senha:</label>
                        <div class="input-group">
                            <input type="password" name="senha" placeholder="senha" id="senha" value="${usuarioEditando.senha}" class="form-control"/>
                            <span class="input-group-btn">                              
                               <input type="button" id="showPassword" value="Mostrar" class="btn btn-light" />
                            </span>
                        </div>                            
                        <label>Grau de acesso:</label>
                        <input type="text" name="grau" placeholder="grau" value="${usuarioEditando.grau}" class="form-control"/><br>
                        <div class="form-group text-right">
                            <input type="submit" name="alterar" value="Alterar" class="btn btn-success "/>                       
                            <a href="${pageContext.request.contextPath}/Usuario-Info" class="btn btn-warning">Cancelar</a><br>  
                        </div>
                    </c:if>   

                </form>                  
                <div class="container">
                    <form action="${pageContext.request.contextPath}/Usuario-Info" method="post">
                        <table class="table table-hover table-sm">
                            <tr>
                                <th>Nome</th>
                                <th>Login</th>
                                <th>Senha</th>
                                <th>Grau</th>                         
                            </tr>
                            <c:forEach var="user" items="${servicos}">
                                <tr>

                                    <td>${user.nome}</td>
                                    <td>${user.login}</td>
                                    <td>${user.senha}</td>
                                    <td>${user.grau}</td>
                                    <td><input type="radio" name="idusuario" value="${user.idusuario}"/></td>                            
                                </tr>
                            </c:forEach>
                        </table>
                        <input class="btn btn-info " type="submit" name="editar" value="editar"/>
                        <input class="btn btn-warning " type="submit" name="excluir" value="excluir"/>
                    </form>                
                </div>                          
            </div>  
        </div>
        <jsp:include page="../includes/js.jsp"/>

    </body>
</html>
