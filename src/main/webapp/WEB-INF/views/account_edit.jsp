<%--
  Created by IntelliJ IDEA.
  User: tosya
  Date: 04.08.2022
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/account/edit" method="post">
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
            <td>
                <div>
                    <label>
                        <b>Name:</b>
                    </label>
                    <input type="text" placeholder="Enter Name" name="name" id="name" required>
                </div>
            </td>
        </tr>
        </tr>
        Укажите имя, которое будет отображаться на сайте, данное имя отображается для других пользователей,
        используется для обращения к Вам
        <tr>
        <tr>
            <td>Дата рождения
                </p>Отображается для других пользователей, используется для обращения к Вам.
            </td>
            <td>
                <div>

                    <div class="control-group">
                        <label for="dateOfBirth">
                            <b>dateOfBirth:</b>
                        </label>
                        <input type="date" id="dateOfBirth" name="dateOfBirth"
                               value="2018-07-22" pattern="dd.MM.yyyy"
                               min="01.01.1901" max="01.01.2100">
                    </div>
                </div>
            </td>

        </tr>
        <tr>
            <td>Email
                </p>Адрес для входа в аккаунт и получения подтверждений бронирований.
            </td>
            <td>
                <div>
                    <label for="email">
                        <b>Email:</b>
                    </label>
                    <input type="text" placeholder="Enter Email" name="email" id="email" required>
                </div>
            </td>
        </tr>
        <tr>
            <td>Телефон</p>
                Укажите ваш номер телефона, сюда могут звонить ваши хозяева жилья/жильцы.
            </td>
            <td>
                <div>
                    <label for="phoneNumber">
                        <b>Phone number:</b>
                    </label>
                    <input type="text" placeholder="Enter Phone number" name="phoneNumber" id="phoneNumber" required>
                </div>
            </td>

        </tr>
        <tr>
            <td>Пол</p>Укажите ваш пол.</td>
            <td>
                <div>
                    <label for="female">
                        <b>Gender:</b>
                    </label>
                    <input type="radio" name="gender" id="female" value="female" checked/>Female
                    <input type="radio" name="gender" id="male" value="male"/>Male
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <button class="btn btn-outline-secondary" type="submit">Редактировать</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
