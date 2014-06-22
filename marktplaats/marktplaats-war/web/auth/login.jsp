<%-- 
    Document   : login
    Created on : 12-jun-2014, 16:51:07
    Author     : Kaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<?xml version='1.0' encoding='UTF-8' ?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
      xmlns:h="http://xmlns.jcp.org/jsf/html">

    <h:head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <h:outputStylesheet name="/css/main.css"/>
        <title>Facelets Template</title>
    </h:head>

    <h:body>
        
        <ui:composition template="./template.xhtml">

<!--            <div id="top">-->
<!--                <ui:insert name="top"></ui:insert>-->
<!--            </div>
            <div>
                <div id="left">-->
                    <ui:insert name="left">Left</ui:insert>
<!--                </div>
                <div id="content" class="left_content">-->
                    <ui:insert name="content">
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
                    </ui:insert>
<!--                </div>
            </div>
            <div id="bottom">-->
                <ui:insert name="bottom">Bottom</ui:insert>
<!--            </div>-->
            
        </ui:composition>

    </h:body>

</html>
