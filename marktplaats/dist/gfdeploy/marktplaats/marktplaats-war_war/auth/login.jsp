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
        
            <h1>Inloggen</h1>

            <form method="post" action="/marktplaats-war/login">
                <ul>
                    <li>
                        <label>E-mailadres:</label>
                        <c:choose>
                            <c:when test="${empty formErrors.get('email')}">
                                 <input type="text" name="email" placeholder="E-mailadres" />
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="error" items="${formErrors.get('email')}">
                                    <span class="error">${error}</span>
                                </c:forEach>
                                <input type="text" name="email" placeholder="E-mailadres" class="error" />
                            </c:otherwise>
                        </c:choose>
                    </li>
                    <li>
                        <label>Wachtwoord:</label>
                        <c:choose>
                            <c:when test="${empty formErrors.get('password')}">
                                 <input type="password" name="password" />
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="error" items="${formErrors.get('password')}">
                                    <span class="error">${error}</span>
                                </c:forEach>
                                <input type="password" name="password" class="error" />
                            </c:otherwise>
                        </c:choose>
                    </li>
                    <li>
                        <input type="submit" value="Inloggen" class="btn" />
                    </li>
                </ul>
            </form>
        
        </article>
        
        
    </jsp:body>
</t:template>
        