<%-- 
    Document   : inicio
    Created on : 11/04/2020, 19:54:45
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>         
        <title>Inicio</title>
        <jsp:include page="includes/css.jsp"/>
    </head>
    <body >
        <header>
            <jsp:include page="includes/menu.jsp"/>
        </header>         
        <div class="container">
            <h6> ${mensagemErro}
                        ${mensagemSucesso}</h6>
        </div>
             <jsp:include page="includes/js.jsp"/>
    </body>
</html>
