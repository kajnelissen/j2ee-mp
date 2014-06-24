<%-- 
    Document   : create
    Created on : Jun 13, 2014, 1:31:04 PM
    Author     : Roy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
    <jsp:body>
        
        <nav id="crumbs">
            <ul>
                <li><a href="/marktplaats-war">Index</a></li>
                <li><a href="/marktplaats-war/ads" class="current">Advertentie aanmaken.</a></li>
            </ul>
        </nav>
        
        <article>
        <h1>Advertentie aanmaken</h1>
        
        <form method="post" action="/marktplaats-war/ads/create">
            <ul>
                <li>
                        <label>Titel:</label>
                        <c:choose>
                            <c:when test="${empty formErrors.get('title')}">
                                 <input type="text" name="titel" placeholder="titel" />
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="error" items="${formErrors.get('title')}">
                                    <span class="error">${error}</span>
                                </c:forEach>
                                <input type="text" name="titel" placeholder="Titel" class="error" />
                            </c:otherwise>
                        </c:choose>
                    </li>
                    <li>
                        <label>Beschrijving:</label>
                        <c:choose>
                            <c:when test="${empty formErrors.get('description')}">
                                 <input type="text" name="beschrijving" />
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="error" items="${formErrors.get('description')}">
                                    <span class="error">${error}</span>
                                </c:forEach>
                                <input type="text" name="beschrijving" class="error" />
                            </c:otherwise>
                        </c:choose>
                    </li>
                    <li>
                        <label>Categorie:</label>
                        <c:choose>
                            <c:when test="${empty formErrors.get('category')}">
                                 <input type="text" name="categorie" />
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="error" items="${formErrors.get('category')}">
                                    <span class="error">${error}</span>
                                </c:forEach>
                                <input type="text" name="categorie" class="error" />
                            </c:otherwise>
                        </c:choose>
                    </li>
                     <li>
                        <label>prijs:</label>
                        <c:choose>
                            <c:when test="${empty formErrors.get('price')}">
                                 <input type="text" name="prijs" />
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="error" items="${formErrors.get('price')}">
                                    <span class="error">${error}</span>
                                </c:forEach>
                                <input type="text" name="prijs" class="error" />
                            </c:otherwise>
                        </c:choose>
                    </li>
                <li>
                    <input type="submit" value="Maak advertentie" class="btn" />
                </li>
            </ul>
        </form>

    </jsp:body>
</t:template>

