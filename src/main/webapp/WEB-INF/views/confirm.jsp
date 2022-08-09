<%--
  Created by IntelliJ IDEA.
  User: tosya
  Date: 05.08.2022
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Confirm page</title>
</head>
<body>

<c:forEach var="apartment" items="${basket.basketApartment}">
    <input type="hidden" name="apartment" value="${apartment}">
    <div class="card" style="width: 69rem;">
        <h5 class="card-title">${apartment.name}</h5>
        <img class="card-img-bottom" src="/getImages/${apartment.image.id}" alt="${apartment.image.name}">
        <div class="card-body">
            <p class="card-text"><spring:message code="app.apartmet.name"/>: ${apartment.type.name}</p>
            <p class="card-text"><spring:message code="app.apartmet.city"/>: ${apartment.address.city.name}</p>
            <p class="card-text"><spring:message code="app.apartmet.country"/>: ${apartment.address.country.name}</p>
            <p class="card-text"><spring:message code="app.apartmet.address"/>: ${apartment.address.value}</p>
            <p class="card-text"><spring:message code="app.apartmet.capacity"/>: ${apartment.capacity}</p>
            <p class="card-text"><spring:message code="app.apartmet.price"/>: ${apartment.price}</p>
            <p class="card-text"><spring:message code="app.apartmet.raiting"/>:${apartment.rating}</p>
            <spring:message code="app.apartmet.listComfort"/>:
            <c:forEach var="comfort" items="${apartment.apartmentComfort}">
                ${comfort.name};
            </c:forEach>
        </div>
    </div>
</c:forEach>
<form action="/create/booking/basket/${basket.id}" method="post">
    <button class="btn btn-primary"><spring:message code="app.basket.confirm"/></button>
</form>
<form action="/confirm/cancel/basket/${basket.id}" method="get">
    <button class="btn btn-primary"><spring:message code="app.basket.clear"/></button>
</form>
</body>
</html>
