<%--
  Created by IntelliJ IDEA.
  User: tosya
  Date: 02.08.2022
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<html>
<head>
    <title>Апартаменты</title>
</head>
<body>
<div class="card" style="width: 69rem;">
    <p>Город, Найдено X Результатов по заданным параметрам</p>
</div>
<c:forEach var="apartment" items="${listApartments}">
    <div class="card" style="width: 69rem;">
        <h5 class="card-title">${apartment.name}</h5>
        <img class="card-img-bottom" src="/getImages/${apartment.image.id}" alt="${apartment.image.name}">
        <div class="card-body">
            <p class="card-text">${apartment.type.name}</p>
            <p class="card-text">${apartment.address.city.name}</p>
            <p class="card-text">${apartment.address.country.name}</p>
            <p class="card-text">${apartment.address.value}</p>
            <p class="card-text">${apartment.capacity}</p>
            <p class="card-text">${apartment.price}</p>
            <p class="card-text">${apartment.rating}</p>
            <a href="/" class="btn btn-primary">Забронировать</a>
        </div>
    </div>
</c:forEach>
</body>
</html>
