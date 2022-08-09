<%--
  Created by IntelliJ IDEA.
  User: tosya
  Date: 02.08.2022
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<form action="/register" method="post">
    <div  style="float: left;">
        <img src="${pageContext.request.contextPath}/image/draw2.svg"></div>
    <div class="container">
        <h1><spring:message code="app.register.h"/></h1>
        <p><spring:message code="app.register.p"/></p>
        <hr>
        <div>
            <label for="username">
                <b><spring:message code="app.user.username"/>:</b>
            </label>
            <input type="text" placeholder="<spring:message code="app.user.username"/>" name="username" id="username" required>
        </div>
        <div>
            <label for="name">
                <b><spring:message code="app.user.name"/>:</b>
            </label>
            <input type="text" placeholder="<spring:message code="app.user.name"/>" name="name" id="name" required>
        </div>
        <div>
            <label for="female">
                <b><spring:message code="app.user.gender"/>:</b>
            </label>
            <input type="radio" name="gender" id="female" value="female" checked/><spring:message code="app.user.gender.f"/>
            <input type="radio" name="gender" id="male" value="male"/><spring:message code="app.user.gender.m"/>
        </div>
        <div>

            <div class="control-group">
                <label for="dateOfBirth">
                    <b><spring:message code="app.user.dateOfBirth"/>:</b>
                </label>
                <input type="date" id="dateOfBirth" name="dateOfBirth"
                           value="2018-07-22" pattern="dd.MM.yyyy"
                           min="01.01.1901" max="01.01.2100">
            </div>
        </div>
        <div>
            <label for="email">
                <b><spring:message code="app.user.email"/>:</b>
            </label>
            <input type="text" placeholder="<spring:message code="app.user.email"/>" name="email" id="email" required>
        </div>
        <div>
            <label for="phoneNumber">
                <b><spring:message code="app.user.phone"/>:</b>
            </label>
            <input type="text" placeholder="<spring:message code="app.user.phone"/>" name="phoneNumber" id="phoneNumber" required>
        </div>
        <div>
            <label for="password"><b><spring:message code="app.login.password"/>:</b></label>
            <input type="password" placeholder="<spring:message code="app.login.password"/>" name="password" id="password" required>
        </div>
        <%
            String role = request.getParameter ("role"); // Получить его с запросом
        %>
        <input type="hidden"  name="role" value="${param.role}">
        <button class="btn btn-primary" type="submit" class="register btn"><spring:message code="app.registbut"/></button>
    </div>
</form>
</body>
</html>