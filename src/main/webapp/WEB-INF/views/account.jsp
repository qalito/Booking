<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: tosya
  Date: 03.08.2022
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

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
<h3><spring:message code="app.account.perconaldata"/></h3>
<spring:message code="app.account.updatedata"/>
<spring:message code="app.account.register"/> ${user.regDate}
<a class="btn btn-outline-light" class="btn btn-outline-light"><spring:message code="app.account.profile"/>
    <span class="badge badge-pill badge-success">${pageContext.request.userPrincipal.name}</span>
</a>
</p>
<spring:message code="app.account.type"/> ${user.roles}
<table border="1" cellpadding="10" class="table_blur" align="center" width="100%">
    <tr>
        <td><spring:message code="app.account.name"/>
        </td>
        <td>${user.name}</td>
    </tr>
    <tr>
    <tr>
        <td><spring:message code="app.account.dateofbirth"/>
        </td>
        <td>${user.dateOfBirth}</td>

    </tr>
    <tr>
        <td><spring:message code="app.account.email"/></td>
        <td>${user.email}</td>

    </tr>
    <tr>
        <td><spring:message code="app.account.phone"/>
        </td>
        <td>${user.phoneNumber}</td>

    </tr>
    <tr>
        <td><spring:message code="app.account.gender"/></td>
        <td>${user.gender}</td>
    </tr>
    <tr>
        <td></td>
        <td>
            <form action="/account/edit" method="get">
                <button class="btn btn-outline-secondary" type="submit"><spring:message code="app.edit"/></button>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
