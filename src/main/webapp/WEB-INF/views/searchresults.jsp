<%--
  Created by IntelliJ IDEA.
  User: tosya
  Date: 02.08.2022
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<html>
<head>
    <title>Апартаменты</title>
</head>
<body>
<spring:message code="app.searchresults.select.city"/>${cityName}  <spring:message code="app.searchresults.st"/>:${dateStart} <spring:message code="app.searchresults.po"/> ${dateTo}. <spring:message code="app.searchresults.count"/> ${count}".
<c:forEach var="apartment" items="${listApartments}">
    <form action="/confirm" method="post">
        <input type="hidden" name="apartment" value="${apartment.id}">
        <div class="card" style="width: 69rem;">
            <h5 class="card-title">${apartment.name}</h5>
            <img class="card-img-bottom" src="/getImages/${apartment.image.id}" alt="${apartment.image.name}">
            <div class="card-body">
                <p class="card-text"><spring:message code="app.name"/>: ${apartment.type.name}</p>
                <p class="card-text"><spring:message code="app.city"/>: ${apartment.address.city.name}</p>
                <p class="card-text"><spring:message code="app.country"/>: ${apartment.address.country.name}</p>
                <p class="card-text"><spring:message code="app.address"/>: ${apartment.address.value}</p>
                <p class="card-text"><spring:message code="app.capacity"/>: ${apartment.capacity}</p>
                <p class="card-text"><spring:message code="app.price"/>: ${apartment.price}</p>
                <p class="card-text"><spring:message code="app.rating"/>:${apartment.rating}</p>
                <spring:message code="app.searchresults.list.comfort"/>:
                <c:forEach var="comfort" items="${apartment.apartmentComfort}">
                    ${comfort.name};
                </c:forEach>
                <input type="hidden" name="dateStart" value="${dateStart}">
                <input type="hidden" name="dateTo" value="${dateTo}">
                <button class="btn btn-primary"> <spring:message code="app.searchresults.book"/></button>
            </div>
        </div>
    </form>
</c:forEach>
</body>
</html>
