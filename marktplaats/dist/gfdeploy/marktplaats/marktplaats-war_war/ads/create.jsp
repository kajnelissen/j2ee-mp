<%-- 
    Document   : create
    Created on : Jun 13, 2014, 1:31:04 PM
    Author     : Roy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Advertentie toevoegen</title>
    </head>
    <body>
        <h1></h1>
        
            <form method="post" action="">
            <ul>
                <li>
                    <label>Titel: </label>
                    <input type="text" name="titel"  />
                </li>
                <li>
                    <label>Beschrijving: </label>
                    <input type="text"  name="beschrijving" />
                </li>
                <li>
                    <label>Categorie: </label>
                    <select name="categorie">
                        <option value="Apparatuur">Apparatuur</option>
                        <option value="Instrumenten">Instrumenten</option>
                        <option value="Overige">Overige Zooi</option>
                    </select>
                </li>
                <li>
                    <label>Prijs: </label>
                    <input type="number"  name="prijs" />
                </li>
                <li>
                    <input type="submit" value="Voeg toe." />
                </li>
                
            </ul>
        </form>
    </body>
</html>
