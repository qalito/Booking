<%--
  Created by IntelliJ IDEA.
  User: tosya
  Date: 03.08.2022
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"/>

<body>
<div name="chooseInfo">
    <div class="input-group mb">
        <div class="input-group-prepend">
            <label class="input-group-text">Заезд - Выезд</label>
        </div>
        <input type="text" name="daterange" value="" placeholder="Заезд - Выезд"/>
    </div>
</div>
</div>
<select class="custom-select" id="inputGroupSelect01" autocomplete="on">
    <option disabled selected>Куда хотите отправиться?</option>
    <c:forEach var="city" items="${listCity}">
        <c:out value="${city.id}"/>
        <option value=<c:out value="${city.id}"/>><c:out value="${city.name}"/></option>
    </c:forEach>
</select>
<div>
    <div class="input-group-prepend">
        <form action="/searchresults" method="get">
            <button class="btn btn-outline-secondary" type="submit">Поиск</button>
        </form>
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
<form method="post" action="#">
    <p><b>Фильтры для поиска</b></p>
    <p><b>Тип</b></p>
    <p><c:forEach var="filter" items="${listFilter}">
        <input type="checkbox" name="${filter.id}" value="${filter.id}">${filter.name}<Br>
    </c:forEach>
    <p><input type="submit" value="Применить"></p>
</form>
<form method="post" action="#">
    <p><b>Комфорт</b></p>
    <p><c:forEach var="comfort" items="${listComfort}">
        <input type="checkbox" name="${comfort.id}" value="${comfort.id}">${comfort.name}<Br>
    </c:forEach>
    <p><input type="submit" value="Применить"></p>
</form>
</body>
