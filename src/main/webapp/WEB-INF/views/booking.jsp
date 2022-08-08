<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Users</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
            background: linear-gradient(#2E70CD,#2E77CD);
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
</head>
<body>

<div class="dropdown">
    <h3 align="center">Бронирования</h3>
        <table border="1" cellpadding="10" class="table_blur" align="center">
            <tr>
                <th>Номер бронирования:</th>
                <th>Дата бронирования:</th>
                <th>Бронь с:</th>
                <th>Бронь по:</th>
                <th>Пользователь:</th>
                <th>Итоговая Сумма:</th>
                <th>Расторгнуть</th>
            </tr>
            <c:forEach var="el" items="${bookings}">
                <tr>
                    <td><c:out value="${el.number}"/></td>
                    <td><c:out value="${el.dateBooking}"/></td>
                    <td><c:out value="${el.dateStart}"/></td>
                    <td><c:out value="${el.dateTo}"/></td>
                    <td><c:out value="Пользователь ${el.user.username}, ${el.user.name}  Телефон ${el.user.phoneNumber} Почта ${el.user.email}"/></td>
                    <td><c:out value="${el.total}"/></td>
                    <td><a href="/delete/booking/${el.id}" class="btn btn-primary">Расторгнуть</a></td>
                </tr>
            </tr>
            <tr>
                <td>
                <c:forEach var="apartment" items="${el.bookingApartment}">
                    <input type="hidden" name="apartment" value="${apartment}">
                    <div class="card" style="width: 40rem;">
                        <h5 class="card-title">${apartment.name}</h5>
                        <img class="card-img-bottom"  style="width: 40rem;" src="/getImages/${apartment.image.id}" alt="${apartment.image.name}">
                        <div class="card-body">
                            <p class="card-text">Название: ${apartment.type.name}</p>
                            <p class="card-text">Город: ${apartment.address.city.name}</p>
                            <p class="card-text">Страна: ${apartment.address.country.name}</p>
                            <p class="card-text">Адрес: ${apartment.address.value}</p>
                            <p class="card-text">Вместимость: ${apartment.capacity}</p>
                            <p class="card-text">Стоимость: ${apartment.price}</p>
                            <p class="card-text">Рейтинг:${apartment.rating}</p>
                            <p class="card-text">Владелец: Пользователь ${apartment.partner.user.username}, ${apartment.partner.user.name} </p>
                            <p class="card-text">Связь с владельцем: Телефон ${apartment.partner.user.phoneNumber} Почта ${apartment.partner.user.email}</p>
                            Список удобств:
                            <c:forEach var="comfort" items="${apartment.apartmentComfort}">
                                ${comfort.name};
                            </c:forEach>
                        </div>
                    </div>
                </c:forEach>
                </td>
            </tr>
            </c:forEach>
        </table>
</div>
</body>
</html>