<%-- 
    Document   : sair
    Created on : 11/04/2020, 23:21:46
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%
   try{    
    response.sendRedirect("/Loja-master/");      
    session.invalidate();
    
   }catch(Exception e){
       out.print(e);
   }
%>