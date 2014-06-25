<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
    <jsp:body>
        
        <nav id="crumbs">
            <ul>
                <li><a href="/marktplaats-war">Index</a></li>
                <li><a href="#">Admin</a></li>
                <li><a href="/marktplaats-war/admin/users" class="current">Leden</a></li>
            </ul>
        </nav>
        
        <article>
        
            <h1>Leden</h1>
            
            <c:choose>
                <c:when test="${empty members}">
                    <p>Er zijn nog geen leden.</p>
                </c:when>
                <c:otherwise>
                    <table>
                        <thead>
                            <tr class="row-header">
                                <th colspan="4">Leden</th>
                            </tr>
                            <tr class="row-sub-header">
                                <th>ID</th>
                                <th>E-mailadres</th>
                                <th>Wachtwoord</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${members}">

                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.email}</td>
                                    <td>${user.password}</td>
                                    <td><a href="/marktplaats-war/admin/users/delete?id=${user.id}">Verwijder</a></td>
                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>

            
        
        </article>
        
        
    </jsp:body>
</t:template>
        