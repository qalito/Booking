<%--
  Created by IntelliJ IDEA.
  User: tosya
  Date: 03.08.2022
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<h3>Персональные данные</h3>
Обновите свои данные и узнайте, как мы их используем.

Зарегистрированы на сайте с ${user.regDate}
<a class="btn btn-outline-light" class="btn btn-outline-light">Профиль
    <span class="badge badge-pill badge-success">${pageContext.request.userPrincipal.name}</span>
</a>
</p>
Тип аккаунта: ${user.role.name}
<table style=" width: 80%; ">
    <tr>
        <td>Имя</p>
        </td>
        <td>${user.name}</td>
    </tr>
    </tr>
    Укажите имя, которое будет отображаться на сайте, данное имя отображается для других пользователей,
    используется для обращения к Вам
    <tr>
    <tr>
        <td>Дата рождения
            </p>Отображается для других пользователей, используется для обращения к Вам.
        </td>
        <td>${user.dateOfBirth}</td>

    </tr>
    <tr>
        <td>Email
            </p>Адрес для входа в аккаунт и получения подтверждений бронирований.
        </td>
        <td>${user.email}</td>

    </tr>
    <tr>
        <td>Телефон</p>
            Укажите ваш номер телефона, сюда могут звонить ваши хозяева жилья/жильцы.
        </td>
        <td>${user.phoneNumber}</td>

    </tr>
    <tr>
        <td>Пол</p>Укажите ваш пол.</td>
        <td>${user.gender}</td>
    </tr>
</table>
<a class="btn btn-outline-light" name="All users" href="/admin/users">Пользователи</a>
<a class="btn btn-outline-light" name="All booking" href="/admin/booking">Бронирования</a>
<a class="btn btn-outline-light" name="All booking" href="/admin/basket">Корзины</a>
<a class="btn btn-outline-light" name="All booking" href="/admin/apartment">Aпартаменты</a>
<a class="btn btn-outline-light" name="All booking" href="/admin/image">Изображения</a>
<a class="btn btn-outline-light" name="All booking" href="/admin/country">Страны</a>
<a class="btn btn-outline-light" name="All booking" href="/admin/country">Города</a>
</body>

