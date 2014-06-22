<%-- 
    Document   : summary
    Created on : Jun 20, 2014, 10:41:39 AM
    Author     : Roy
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
        <h1>Advertenties</h1>
        
        <ul>
        <c:forEach var="ad" items="${ads}">
           
            <li><a href="">${ad.title}</a></li>

        </c:forEach>
            
        </ul>
        
    </body>
</html>
