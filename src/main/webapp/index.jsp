<%-- 
    Document   : index
    Created on : 11/04/2020, 01:08:51
    Author     : gustavo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <jsp:include page="includes/css.jsp"/>
    </head>
    <body class="container text-center">
        <h4> ${mensagemErro}
            ${mensagemSucesso}</h4>
        <div class="container text-center" style="width: 25rem;">
            <br>
            <br>
            <br>
            <form action="${pageContext.request.contextPath}/Inicio" method="post">
                <input type="text" name="login" class="form-control" required placeholder="login"/>
                <br>
                <input type="password" name="senha" class="form-control" required placeholder="senha"/>
                <br>
                <br>
                <input type="submit" name="logar" class="btn btn-secondary" value="Logar"/>
            </form>    
        </div>
        <jsp:include page="includes/js.jsp"/>
    </body>
</html>
