<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title><spring:message code="app.login.title"/>Log in with your account</title>
</head>

<body>
<sec:authorize access="isAuthenticated()">
        <% response.sendRedirect("/"); %>
</sec:authorize>
<body>
<div style="text-align: center;">
    <div if="${param.error}">
        <p text="${session.error}" unless="${session == null}"></p>
    </div>
    <div  style="float: left;">
        <img src="${pageContext.request.contextPath}/image/draw2.svg"></div>

    <form action="/login" method="post">
        <h2><spring:message code="app.login.title"/></h2>
        <div>
            <label> <spring:message code="app.login.usename"/> : <input type="text" name="username"/> </label>
        </div>
        <div>
            <label> <spring:message code="app.login.password"/> : <input type="password" name="password"/> </label>
        </div>
        <button class="btn btn-primary" type="submit"/>
        Войти</button>
        <a class="btn btn-primary" name="RegisterAsPartner" href="/register?role=User"><spring:message
                code="app.header.register"/></a>
    </form>
</div>
</body>
</html>