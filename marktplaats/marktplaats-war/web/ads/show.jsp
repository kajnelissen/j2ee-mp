<%-- 
    Document   : summary
    Created on : Jun 20, 2014, 10:41:39 AM
    Author     : Roy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
    <jsp:body>
        
        <article>
            
      
                <h1>Advertentie</h1>
                <p>Titel: ${ad.title} </p>
                <p>Beschrijving: ${ad.description} </p
                <p>Categorie: ${ad.category} </p>
                <p>Advertentie: ${ad.price}  </p>
               
            
        </article>
        
    </jsp:body>
</t:template>
