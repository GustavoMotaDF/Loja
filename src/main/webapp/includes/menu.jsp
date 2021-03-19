<%-- 
    Document   : menu
    Created on : 11/04/2020, 21:55:48
    Author     : gustavo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.time.Instant"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.lavajato.lojadompedroprimeiro.BO.MenuBO"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>

<%               
    String login = (String) session.getAttribute("login");
    if(login == null || login.isEmpty()){
        session.invalidate();
        response.sendRedirect("/Loja-master/");                
    }else{
        MenuBO menu = new MenuBO();
        
        request.setAttribute("Menu",menu.getMenus(login));
                            SimpleDateFormat ftm = new SimpleDateFormat("dd/MM/yyyy");
                            Date data = Date.from(Instant.now());
                            String dataftm = ftm.format(data);
                            request.setAttribute("data", dataftm);  
        
%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand titulo" href="#">Loja Dom Pedro Primeiro</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
        <c:forEach var="menus" items="${Menu}">
          <li class="nav-item active">
            <a class="nav-link" href="${menus[0]}">${menus[1]}<span class="sr-only">(current)</span></a>
          </li>
        </c:forEach>          
        </ul>  
    <button class="btn btn-outline-success my-2 my-sm-0" type="">Olá, ${Menu[0][2]}, Hoje é ${data}</button> 
    <a class="btn btn-outline-info my-2 my-sm-0" href="/Loja-master/includes/sair.jsp">Encerrar Sessão</a>
    
  </div>
</nav>
<%
      }
%>