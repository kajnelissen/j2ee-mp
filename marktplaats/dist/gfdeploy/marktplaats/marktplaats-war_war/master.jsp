<%-- 
    Document   : master
    Created on : 12-jun-2014, 17:02:01
    Author     : Kaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:h="http://java.sun.com/jsf/html">-->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
          "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets">
    
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8" />
<!--        <h:outputStylesheet library="css" name="default.css"/>
        <h:outputStylesheet library="css" name="cssLayout.css"/>-->
        <title><ui:insert name="title">Standaard titel</ui:insert></title>
    </head>
    
    <body>
        
        <header>
            header
        </header>
        
        <main id="content">
             <ui:insert name="content">Main Content</ui:insert>
        </main>
        
        <footer>
            footer
        </footer>
        
    </body>
    
</html>
