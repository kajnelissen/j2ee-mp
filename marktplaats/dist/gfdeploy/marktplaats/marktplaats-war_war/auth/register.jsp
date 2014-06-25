<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
    <jsp:body>
        
        <nav id="crumbs">
            <ul>
                <li><a href="/marktplaats-war">Index</a></li>
                <li><a href="/marktplaats-war/register" class="current">Registreren</a></li>
            </ul>
        </nav>
        
        <article>
        <h1>Registreren</h1>
        
        <form method="post" action="/marktplaats-war/register">
            <ul>
                    <li>
                        <label>E-mailadres:</label>
                        <c:choose>
                            <c:when test="${empty formErrors.get('email')}">
                                 <input type="text" name="email" placeholder="E-mailadres..." />
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="error" items="${formErrors.get('email')}">
                                    <span class="error">${error}</span>
                                </c:forEach>
                                <input type="text" name="email" placeholder="E-mailadres..." class="error" />
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
                        <label>Voornaam:</label>
                        <c:choose>
                            <c:when test="${empty formErrors.get('firstName')}">
                                 <input type="text" name="firstName" placeholder="Voornaam..." />
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="error" items="${formErrors.get('firstName')}">
                                    <span class="error">${error}</span>
                                </c:forEach>
                                <input type="text" name="firstName" placeholder="Voornaam..." class="error" />
                            </c:otherwise>
                        </c:choose>
                    </li>
                    <li>
                        <label>Achternaam:</label>
                        <c:choose>
                            <c:when test="${empty formErrors.get('lastName')}">
                                 <input type="text" name="lastName" placeholder="Achternaam..." />
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="error" items="${formErrors.get('lastName')}">
                                    <span class="error">${error}</span>
                                </c:forEach>
                                <input type="text" name="lastName" placeholder="Achternaam..." class="error" />
                            </c:otherwise>
                        </c:choose>
                    </li>
                <li>
                    <input type="submit" value="Registreren" class="btn" />
                </li>
            </ul>
        </form>

    </jsp:body>
</t:template>
