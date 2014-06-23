<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
    <jsp:body>
        
        <nav id="crumbs">
            <ul>
                <li><a href="/marktplaats-war">Index</a></li>
                <li><a href="/marktplaats-war/login" class="current">Inloggen</a></li>
            </ul>
        </nav>
        
        <article>
        
            <h1>Leden</h1>

            <table>
                <thead>
                    <tr class="row-header">
                        <th colspan="3">Leden</th>
                    </tr>
                    <tr class="row-sub-header">
                        <th>ID</th>
                        <th>E-mailadres</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${members}">
           
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.email}</td>
                            <td><a href="/admin/users/delete?id=${user.id}">Verwijder</a></td>
                        </tr>

                    </c:forEach>
                </tbody>
            </table>
        
        </article>
        
        
    </jsp:body>
</t:template>
        