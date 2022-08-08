<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tosya
  Date: 07.08.2022
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<style>
    .table_blur {
        margin-left: auto;
        margin-right: auto;
        background: #f5ffff;
        border-collapse: collapse;
        text-align: center;
    }

    .table_blur th {
        border-top: 1px solid #777777;
        border-bottom: 1px solid #777777;
        box-shadow: inset 0 1px 0 #999999, inset 0 -1px 0 #999999;
        background: linear-gradient(#2E70CD, #2E77CD);
        color: white;
        padding: 10px 15px;
        position: relative;
    }

    .table_blur th:after {
        content: "";
        display: block;
        position: absolute;
        left: 0;
        top: 25%;
        height: 25%;
        width: 100%;
        background: linear-gradient(rgba(255, 255, 255, 0), rgba(255, 255, 255, .08));
    }

    .table_blur tr:nth-child(odd) {
        background: #ebf3f9;
    }

    .table_blur th:first-child {
        border-left: 1px solid #777777;
        border-bottom: 1px solid #777777;
        box-shadow: inset 1px 1px 0 #999999, inset 0 -1px 0 #999999;
    }

    .table_blur th:last-child {
        border-right: 1px solid #777777;
        border-bottom: 1px solid #777777;
        box-shadow: inset -1px 1px 0 #999999, inset 0 -1px 0 #999999;
    }

    .table_blur td {
        border: 1px solid #e3eef7;
        padding: 10px 15px;
        position: relative;
        transition: all 0.5s ease;
        word-wrap: break-word;
    }

    .table_blur tbody:hover td {
        color: transparent;
        text-shadow: 0 0 3px #a09f9d;
        word-wrap: break-word;
    }

    .table_blur tbody:hover tr:hover td {
        color: #444444;
        text-shadow: none;
    }
</style>
<h3 style="text-align: center">Все активные корзины</h3>
<table border="1" cellpadding="10" class="table_blur" align="center" >
    <c:forEach var="basket" items="${basketList}">
        <td>
            <div>Пользователь ${basket.user.username}, ${basket.user.name}</div>
            <div>Телефон ${basket.user.phoneNumber}, почта ${basket.user.email}</div>
            <div>Бронь с ${basket.dateStart} по ${basket.dateTo}</div>
            <div>Корзина уничтожится после ${basket.checkoutTime}</div>
            <c:forEach var="apartment" items="${basket.basketApartment}">
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
                    </div>
                </div>
            </c:forEach>
            <form action="/create/booking/basket/${basket.id}" method="post">
                <button class="btn btn-primary">Подтвердить бронирование</button>
            </form>
            <form action="/confirm/cancel/basket/${basket.id}" method="get">
                <button class="btn btn-primary">Очистить корзину бронирований</button>
            </form>
        </td>
    </c:forEach>
</table>
</body>
