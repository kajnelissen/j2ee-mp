<%-- 
    Document   : login
    Created on : 12-jun-2014, 16:51:07
    Author     : Kaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registreren</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
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
                    <input type="submit" value="Registreren" />
                </li>
            </ul>
        </form>
    </body>
</html>

