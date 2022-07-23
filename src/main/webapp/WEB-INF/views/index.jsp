<%--
  Created by IntelliJ IDEA.
  User: tosya
  Date: 23.06.2022
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"/>

<div>
    <h3>${pageContext.request.userPrincipal.name}</h3>
    <sec:authorize access="!isAuthenticated()">
        <h4><a href="/login">Войти</a></h4>
        <h4><a href="/registration">Зарегистрироваться</a></h4>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <h4><a href="/logout">Выйти</a></h4>
    </sec:authorize>
    <h4><a href="/news">Новости (только пользователь)</a></h4>
    <h4><a href="/admin">Пользователи (только админ)</a></h4>
</div>

<body weight="80%">
<div name="chooseInfo" style="background: #FFCD00; padding: 5px;"style="background: #2E77CD; height: 100px; padding: 5px;" >
    <div class="input-group mb">
        <div class="input-group-prepend">
            <label class="input-group-text" for="inputGroupSelect01">Заезд - Выезд</label>
        </div>
        <input type="text" name="daterange" value="" placeholder="Заезд - Выезд"/>
        <select class="custom-select" id="inputGroupSelect01" autocomplete="on">
            <option disabled selected>Куда хотите отправиться?</option>
            <c:forEach var="city" items="${listCity}">
                <c:out value="${city.id}"/>
                <option value=<c:out value="${city.id}"/>> <c:out value="${city.name}"/> </option>
            </c:forEach>
        </select>
        <div class="input-group-prepend">
            <button class="btn btn-outline-secondary" type="button">Button</button>
        </div>
    </div>
</div>
<script>
    $(function () {
        $('input[name="daterange"]').daterangepicker({
            opens: 'left'
        }, function (start, end, label) {
            console.log("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
        });
    });
</script>
<form action="/logout" method="post">
    <input type="submit" value="Sign Out"/>
</form>
</body>
</div>
