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

            <h1>Advertenties</h1>
            
            <c:choose>
                <c:when test="${empty ads}">
                    <p>Er zijn nog geen advertenties .</p>
                </c:when>
                <c:otherwise>
                    <table>
                        <thead>
                            <tr class="row-header">
                                <th colspan="4">Advertenties</th>
                            </tr>
                            <tr class="row-sub-header">
                                <th>ID</th>
                                <th>Titel</th>
                                <th>Beschrijving</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="ad" items="${ads}">

                                <tr>
                                    <td>${ad.id}</td>
                                    <td>${ad.title}</td>
                                    <td>${ad.description}</td>
                                    <td><a href="/marktplaats-war/ads/show?id=${ad.id}">Bekijken</a></td>
                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
<!--        <h1>Advertenties</h1>
        
        <ul>
            
        
           <form method="post" action="">
               <c:forEach var="ad" items="${ads}">
           <input type="radio" name="id" value =${ad.id}>
                <label>Advertentie: ${ad.title}  </label>                
                <input type="submit" value="Bekijk advertentie" /><br>
                </c:forEach>
           </form>
        
            
        </ul>-->
        
        </article>
        
    </jsp:body>
</t:template>
