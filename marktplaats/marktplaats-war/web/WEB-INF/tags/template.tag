<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
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
                        <span>Welkom, Gast</span>
                        <a href="/marktplaats-war/register">Registreren</a>
                        <a href="/marktplaats-war/login">Inloggen</a>
                </div>
            </div>
        </div>
    
    <div class="page-block-container main-container clearfix">
        <div class="content-container">
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
