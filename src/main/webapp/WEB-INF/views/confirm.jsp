<%--
  Created by IntelliJ IDEA.
  User: tosya
  Date: 05.08.2022
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Confirm page</title>
</head>
<body>
<c:forEach var="apartment" items="${listApartments}">
    <form action="/confirm" method="post">
        <input type="hidden" name="apartment" value="${apartment}">
        <div class="card" style="width: 69rem;">
            <h5 class="card-title">${apartment.name}</h5>
            <img class="card-img-bottom" src="/getImages/${apartment.image.id}" alt="${apartment.image.name}">
            <div class="card-body">
                <p class="card-text">Название: ${apartment.type.name}</p>
                <p class="card-text">Город: ${apartment.address.city.name}</p>
                <p class="card-text">Страна: ${apartment.address.country.name}</p>
                <p class="card-text">Адрес: ${apartment.address.value}</p>
                <p class="card-text">Вместимость: ${apartment.capacity}</p>
                <p class="card-text">Стоимость: ${apartment.price}</p>
                <p class="card-text">Рейтинг:${apartment.rating}</p>
                Список удобств:
                <c:forEach var="comfort" items="${apartment.apartmentComfort}">
                    ${comfort.name};
                </c:forEach>
                <button class="btn btn-primary">Подтвердить бронирование</button>
            </div>
        </div>
    </form>
</c:forEach>
</body>
</html>