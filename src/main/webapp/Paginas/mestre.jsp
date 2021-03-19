<%-- 
    Document   : mestre
    Created on : 13/04/2020, 13:27:53
    Author     : gustavo
--%>

<%@page import="java.lang.reflect.Array"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.io.*" %> 
<%@page import="java.io.FilenameFilter"%>
<%@page import="java.io.File"%>
<%@page import="java.util.*" %> 
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Mestre</title>
        <jsp:include page="../includes/css.jsp"/>
    </head>
    <body>        
        <header>
            <jsp:include page="../includes/menu.jsp"/>
            <jsp:include page="includes/aviso-conteudo.jsp"/>  
        </header>

        <div class="container">      
            <div class="row">
                <div class="col-md-7">
                    <h1>/Mestre</h1>
                    <h1> ${mensagemErro}
                        ${mensagemSucesso}</h1>
                        <%

                            File pdf = new File(request.getRealPath("/Paginas/Mestre/Aulas/PDF"));
                            String[] pdfs = pdf.list();
                            List<String> pdfss = new ArrayList<String>();
                            pdfss = Arrays.asList(pdfs);
                            Collections.sort(pdfss);
                            if (pdfss.isEmpty()) {
                                request.setAttribute("msgpdf", "..Ops <br>Parece não haver Arquivos aqui ´:(");
                            } else {
                                request.setAttribute("pdf", pdfss);
                            }
                        %>
                        <%
                            File video = new File(request.getRealPath("/Paginas/Mestre/Aulas/Videos"));
                            String[] videos = video.list();
                            //List<String> videoss = new ArrayList<String>();
                            pdfss = Arrays.asList(videos);
                            Collections.sort(pdfss);
                            if (pdfss.isEmpty()) {
                                request.setAttribute("msgpdf", "..Ops <br>Parece não haver Vídeos aqui ´:(");
                            } else {
                                request.setAttribute("video", pdfss);
                            }

                            //path do diretório
                            //String diretorio = getServletContext().getRealPath("/Aprendiz");
                            //request.setAttribute("diretorio", diretorio);                
%>

                    <hr>
                    <hr>

                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="videos-tab" data-toggle="tab" href="#videos" role="tab" aria-controls="videos" aria-selected="true">Videos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="pdf-tab" data-toggle="tab" href="#pdf" role="tab" aria-controls="pdf" aria-selected="false">PDF</a>
                        </li>
                    </ul>
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="videos" role="tabpanel" aria-labelledby="videos-tab">
                            <br>
                            <div class="text-center h5">
                                <p class="text-warning">${msgvideo}</p>
                            </div>
                            <div class="row">                                 
                                <c:forEach items="${video}" var="video" > 
                                    <div class="col-md-6">
                                        <div class="card align-items-center" style="width: 19rem;">
                                            <video controls style="width: 18rem;">
                                                <source src="Paginas/Mestre/Aulas/Videos/${video}" type="video/mp4">
                                                Seu navegador não suporta o elemento <code>video</code>.
                                            </video>   
                                            <div class="card-body">
                                                <h5 class="card-title">${video}</h5>                              
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="pdf" role="tabpanel" aria-labelledby="pdf-tab">  
                            <br>
                            <div class="text-center h5">
                                <p class="text-warning">${msgpdf}</p>
                            </div>
                            <div class="row">                               
                                <table class="table table-hover">                                    
                                    <c:forEach items="${pdf}" var="pdf">                                         
                                        <tr>
                                            <th>
                                                <a href="Paginas/Mestre/Aulas/PDF/${pdf} " target="_blank">${pdf}</a><br>   
                                            </th>
                                        </tr>   
                                    </c:forEach> 
                                </table>                                 
                            </div> 
                        </div>
                    </div> 
                </div>
            </div>
        </div>
        <jsp:include page="../includes/js.jsp"/>
    </body>
</html>