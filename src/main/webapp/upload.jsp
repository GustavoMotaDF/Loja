<%--
    Document   : upload
    Created on : 18/04/2020, 21:42:59
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<%
HttpSession sessao = request.getSession();

        String login = (String) sessao.getAttribute("login"); 
        
        if (login == null || login.isEmpty()) {
            request.setAttribute("mensagemErro", "<div class=\"alert alert-danger\" id=\"foo\">"
                        + "<strong> Você foi deslogado, faça login novamente para ter acesso ao sistema! </strong>"
                        + "</div>"
                        + "<script>$().ready(function() {\n"
                        + "	setTimeout(function () {\n"
                        + "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n"
                        + "	}, 15000); // O valor é representado em milisegundos.\n"
                        + "});</script>");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        }else{
%>
<html>
    <head>
        <title>Upload</title>
        <jsp:include page="includes/css.jsp"/>
    </head>
    <body>
        <header>
            <jsp:include page="includes/menu.jsp"/>
        </header>
        <div class="container text-center">
            <br>
            <br>
            <br>
            <div class="row">
                <div class="col-md-6"> 
                    ${message} 
                    <!-- Modal grande -->
                    <div class="card card-body text-center">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg1">Aprendiz</button><hr>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg2">Companheiro</button><hr>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg3">Mestre</button>
                    
                    </div>
                    
                                                
                    <jsp:include page="includes/uploads/aprendiz.jsp"/>                            
                    <jsp:include page="includes/uploads/companheiro.jsp"/>                            
                    <jsp:include page="includes/uploads/mestre.jsp"/>                            
                </div>
            </div>           
        </div>
        <jsp:include page="includes/js.jsp"/>
    </body>
</html>

<%  


}
%>