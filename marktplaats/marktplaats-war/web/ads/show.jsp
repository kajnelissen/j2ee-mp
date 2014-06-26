<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
    <jsp:body>
        
        <article>
      
            <section>
                <h1>${ad.title}</h1>
                <p>Beschrijving: ${ad.description}</p>
                <p>Categorie: ${ad.category}</p>
                <p>Advertentie: ${ad.price}</p>
            </section>
                
            <section>
                <h2>Biedingen</h2>
                <c:choose>
                    <c:when test="${empty ad.bids}">
                        <p>Er heeft nog niemand een bod gedaan op dit product.</p>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="bid" items="${ad.bids}">
                            <p>${bid.amount}</p>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </section>  
            
            <section>
                <h2>Doe zelf een bod</h2>
                <form action="/marktplaats-war/bids/create?adId=${ad.id}" method="post">
                    <ul>
                        <li>
                            <label>Bedrag</label>
                            <input type="text" name="amount" placeholder="Bedrag" />
                        </li>
                        <li>
                            <input type="hidden" value="1" name="doBid" />
                            <input type="submit" value="Plaatsen" class="btn" />
                        </li>
                    </ul>
                </form>
            </section>
            
        </article>
        
    </jsp:body>
</t:template>