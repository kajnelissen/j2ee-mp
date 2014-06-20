<%-- 
    Document   : login
    Created on : 12-jun-2014, 16:51:07
    Author     : Kaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:h="http://java.sun.com/jsf/html">
        
    <h:body>
    
        <ui:composition template="./master.jsp">
            <ui:define name="content">
        
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
                            <input type="submit" value="Inloggen" />
                        </li>
                    </ul>
                </form>
        
            </ui:define>
        </ui:composition>
    
    </h:body>
</html>
    