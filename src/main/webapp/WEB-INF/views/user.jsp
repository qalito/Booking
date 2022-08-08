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
    <h3 align="center">Все пользователи системы</h3>
        <table border="1" cellpadding="10" class="table_blur" align="center">
            <tr>
                <th>Имя:</th>
                <th>Дата рождения:</th>
                <th>Пол:</th>
                <th>Логин:</th>
                <th>Телефон:</th>
                <th>Email</th>
                <th>Роль</th>
                <th>accountNonLocked</th>
                <th>regDate</th>
                <th>Orders</th>
                <th>Action</th>
            </tr>
            <c:forEach var="el" items="${users}">
                <tr>
                    <td><c:out value="${el.name}"/></td>
                    <td><c:out value="${el.dateOfBirth}"/></td>
                    <td><c:out value="${el.gender}"/></td>
                    <td><c:out value="${el.username}"/></td>
                    <td><c:out value="${el.phoneNumber}"/></td>
                    <td><c:out value="${el.email}"/></td>
                    <td><c:out value="${el.role.name}"/></td>
                    <td><c:out value="${el.accountNonLocked}"/></td>
                    <td><c:out value="${el.regDate}"/></td>
                    <td><a href="/users/${el.username}/booking" class="btn btn-secondary">Бронирования</a></td>
                    <td><a href="/user/${el.username}" class="btn btn-primary">Пользователь</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>