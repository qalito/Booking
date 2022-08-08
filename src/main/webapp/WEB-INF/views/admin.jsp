<%--
  Created by IntelliJ IDEA.
  User: tosya
  Date: 03.08.2022
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<body>
<div style="background: #2E77CD; height: 50px; border: 5px solid #2E77CD;">
    <a class="btn btn-outline-light" name="Users" href="/admin/users">Пользователи</a>
    <a class="btn btn-outline-light" name="Booking" href="/allBooking">Бронирования</a>
    <a class="btn btn-outline-light" name="Basket" href="/admin/basket">Корзины</a>
    <a class="btn btn-outline-light" name="Apartment" href="/admin/apartment">Апартаменты</a>
    <a class="btn btn-outline-light" name="Image" href="/admin/image">Изображения</a>
    <a class="btn btn-outline-light" name="Country" href="/admin/country">Страны</a>
    <a class="btn btn-outline-light" name="City" href="/admin/city">Города</a>
    <a class="btn btn-outline-light" name="Comfort" href="/admin/comfort">Комфорты апартаментов</a>
    <a class="btn btn-outline-light" name="Type" href="/admin/type">Типы апартаментов</a>
</div>
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
        background: linear-gradient(#9595b6, #263238);
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
<h3>Персональные данные</h3>
Обновите свои данные и узнайте, как мы их используем.

Зарегистрированы на сайте с ${user.regDate}
<a class="btn btn-outline-light" class="btn btn-outline-light">Профиль
    <span class="badge badge-pill badge-success">${pageContext.request.userPrincipal.name}</span>
</a>
</p>
Тип аккаунта: ${user.role.name}
<table border="1" cellpadding="10" class="table_blur" align="center" width="100%">
    <tr>
        <td>Имя, укажите имя, которое будет отображаться на сайте, данное имя отображается для других пользователей,
            используется для обращения к Вам
        </td>
        <td>${user.name}</td>
    </tr>
    <tr>
    <tr>
        <td>Дата рождения, необходимая системе информация.
        </td>
        <td>${user.dateOfBirth}</td>

    </tr>
    <tr>
        <td>Email, адрес может использоваться для информирования пользователей.
        </td>
        <td>${user.email}</td>

    </tr>
    <tr>
        <td>Телефон, укажите ваш номер телефона, сюда могут звонить ваши хозяева жилья/жильцы.
        </td>
        <td>${user.phoneNumber}</td>

    </tr>
    <tr>
        <td>Пол, укажите ваш пол.</td>
        <td>${user.gender}</td>
    </tr>
</table>
</body>

