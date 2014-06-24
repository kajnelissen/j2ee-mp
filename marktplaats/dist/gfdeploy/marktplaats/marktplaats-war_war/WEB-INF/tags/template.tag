<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<html>
<head>
    <title>J2EE Marktplaats</title>
    <link rel="stylesheet" href="/marktplaats-war/resources/css/normalize.css">
    <link rel="stylesheet" href="/marktplaats-war/resources/css/main.css">
</head>
<body>
    
    <header>
            <div class="page-block-container clearfix">
                <a href="/" class="logo-top"><h1>J2EE Marktplaats</h1></a>
                <nav id="top-nav">
                    <ul>
                        <li><a href="/marktplaats-war/ads">Advertenties</a></li>
                        <li><a href="/marktplaats-war/admin/users">Leden</a></li>
                    </ul>
                </nav>
            </div>
        </header>

        <div class="user-status-bar">
            <div class="page-block-container clearfix">
                <div>
                    <c:if test="${not empty sessionScope.currentUser}">
                        <span>Welkom, ${sessionScope.currentUser.email}</span>
                        <a href="/marktplaats-war/logout">Uitloggen</a> 
                    </c:if>
                    <c:if test="${empty sessionScope.currentUser}">
                        <span>Welkom, Gast</span>  
                        <a href="/marktplaats-war/register">Registreren</a>
                        <a href="/marktplaats-war/login">Inloggen</a> 
                    </c:if>
                </div>
            </div>
        </div>
    
    <div class="page-block-container main-container clearfix">
        <div class="content-container">
            <c:if test="${not empty notification}">
                <div class="ok">${notification}</div> 
            </c:if>
            <c:if test="${not empty errorMsg}">
                <div class="error">${errorMsg}</div> 
            </c:if>
            <main id="content">
                <jsp:doBody/>
            </main>
        </div>
        <nav class="sidebar">
            <h2>Menu</h2>
            <a href="#">Link</a>
            <a href="#">Link</a>
        </nav>
    </div>
            
    <footer class="page-block-container">
        &copy; Kyra Hameleers, Roy Jeurissen, Kaj Nelissen (2014)
    </footer>
    
</body>
</html>
