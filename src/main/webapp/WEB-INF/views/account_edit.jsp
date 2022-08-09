<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<form action="/account/edit" method="post">
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
            <td>
                <div>
                    <label>
                        <b><spring:message code="app.user.name"/>:</b>
                    </label>
                    <input type="text" placeholder="<spring:message code="app.account.enter.name"/>" name="name" id="name" value="${user.name}" required>
                </div>
            </td>
        </tr>
        <tr>
            <td><spring:message code="app.account.dateofbirth"/></td>
            <td>
                <div>

                    <div class="control-group">
                        <label for="dateOfBirth">
                            <b><spring:message code="app.user.dateOfBirth"/>:</b>
                        </label>
                        <input type="date" id="dateOfBirth" name="dateOfBirth"
                               value="{${user.dateOfBirth}}" pattern="dd.MM.yyyy"
                               min="01.01.1901" max="01.01.2100">
                    </div>
                </div>
            </td>

        </tr>
        <tr>
            <td><spring:message code="app.account.email"/>
            </td>
            <td>
                <div>
                    <label for="email">
                        <b><spring:message code="app.user.email"/>:</b>
                    </label>
                    <input type="text" placeholder="<spring:message code="app.account.enter.email"/>" name="email" id="email" value="${user.email}" required>
                </div>
            </td>
        </tr>
        <tr>
            <td><spring:message code="app.account.phone"/>
            </td>
            <td>
                <div>
                    <label for="phoneNumber">
                        <b><spring:message code="app.user.phone"/>:</b>
                    </label>
                    <input type="text" placeholder="<spring:message code="app.account.enter.phone"/>" name="phoneNumber" id="phoneNumber" value="${user.phoneNumber}" required>
                </div>
            </td>

        </tr>
        <tr>
            <td><spring:message code="app.account.gender"/></td>
            <td>
                <div>
                    <label for="female">
                        <b><spring:message code="app.user.gender"/>:</b>
                    </label>
                    <input type="radio" name="gender" id="female" value="female" checked/><spring:message code="app.user.gender.f"/>
                    <input type="radio" name="gender" id="male" value="male"/><spring:message code="app.user.gender.m"/>
                </div>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="hidden"  name="username" value="${user.username}">
                <button class="btn btn-outline-secondary" type="submit"><spring:message code="app.edit"/></button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
