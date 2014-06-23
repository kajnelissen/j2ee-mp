<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

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

            <form method="post" action="/login">
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
                        <input type="submit" value="Inloggen" class="btn" />
                    </li>
                </ul>
            </form>
        
        </article>
        
        
    </jsp:body>
</t:template>
        