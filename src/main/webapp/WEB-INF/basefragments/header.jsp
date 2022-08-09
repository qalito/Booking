<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: tosya
  Date: 23.06.2022
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<div style="background: #2E77CD; height: 100px; padding: 30px;">
    <div style="float: left">
        <h1 style="color: #E0E0E0">TosyaMayBooking.com</h1>
    </div>
    <div style="float: right; padding: 10px; text-align: right;">
        <div class="dropdown">
            <button class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><spring:message
                    code="app.lang.title"/></button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="?lang=en"><spring:message code="app.lang.english"/></a>
                <a class="dropdown-item" href="?lang=ru"><spring:message code="app.lang.russian"/></a>
            </div>
            <a class="btn btn-outline-light" name="Main" href="/"><spring:message code="app.header.main"/></a>
            <sec:authorize access="!isAuthenticated()">
                <a class="btn btn-outline-light" name="RegisterAsPartner" href="/register?role=PARTNER"><spring:message
                        code="app.header.registerPartner"/></a>
                <a class="btn btn-outline-light" name="Register" href="/register?role=USER"><spring:message
                        code="app.header.register"/></a>
                <a class="btn btn-outline-light" name="SignIn" href="/login"><spring:message
                        code="app.header.sign"/></a>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
            <div class="dropdown"  style="float:right;">
                    <a class="btn btn-outline-light" class="btn btn-outline-light" id="dropdownMenu1" data-toggle="dropdown" ><spring:message code="app.header.profile"/>
                    <span class="badge badge-pill badge-success">${pageContext.request.userPrincipal.name}</span>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenu1">
                        <a class="btn btn-light" href="/account"><spring:message code="app.header.account"/></a>
                        <a class="btn btn-light" href="/users/${pageContext.request.userPrincipal.name}/booking"><spring:message code="app.header.booking"/></a>
                        <a class="btn btn-light" href="/users/${pageContext.request.userPrincipal.name}/apartment"><spring:message code="app.header.apartment"/></a>
                        <a class="btn btn-light" href="/users/${pageContext.request.userPrincipal.name}/apartment"><spring:message code="app.header.apartment"/></a>
                    </div>
                </a>
            </div>
                <a class="btn btn-outline-light" name="SignOut" href="/logout"><spring:message
                        code="app.header.signOut"/></a>
                <a class="btn btn-outline-light" name="Admin" href="/admin"><spring:message code="app.header.admin"/></a>
            </sec:authorize>
        </div>
    </div>
</div>
