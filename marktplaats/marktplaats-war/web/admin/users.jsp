<%-- 
    Document   : users
    Created on : 13-jun-2014, 13:35:29
    Author     : Kaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gebruikers</h1>
        
        <ul>
        
        <c:forEach var="user" items="${members}">
           
            <li>${user.email}</li>

        </c:forEach>
        
        </ul>
        
    </body>
</html>
