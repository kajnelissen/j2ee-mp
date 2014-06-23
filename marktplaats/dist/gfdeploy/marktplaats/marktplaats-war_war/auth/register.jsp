<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

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
                    <input type="text" name="email" placeholder="E-mailadres" />
                </li>
                <li>
                    <label>Wachtwoord:</label>
                    <input type="password" name="password" />
                </li>
                <li>
                    <input type="submit" value="Registreren" class="btn" />
                </li>
            </ul>
        </form>

    </jsp:body>
</t:template>
