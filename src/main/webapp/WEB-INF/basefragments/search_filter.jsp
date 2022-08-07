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
<div name="chooseInfo" style="width: 100%; background: #FFE87C;">
    <div class="input-group mb">
        <div class="input-group-prepend">
            <label class="input-group-text">Заезд - Выезд</label>
        </div>
        <input type="text" name="daterange" value="" placeholder="Заезд - Выезд"/>
        <div class="cart-item-info much">
            <button class="jsminus">-</button>
            <input style="width: 30px" type="text" value="1" id="input1" name="input1" maxlength="2" disabled>
            <button class="jsplus">+</button>
        </div>
    </div>
</div>
<form id="searchForm" method="get" action="/searchresults" content="">
    <div style="background: #FFCD00;">
    <select class="custom-select" id="inputGroupSelect01" autocomplete="on" required>
        <option disabled selected hidden value="">Куда хотите отправиться?</option>
        <c:forEach var="city" items="${listCity}">
            <c:out value="${city.id}"/>
            <option value=<c:out value="${city.id}"/>><c:out value="${city.name}"/></option>
        </c:forEach>
    </select>
    <div>
        <input type="hidden" name="dateStart">
        <input type="hidden" name="dateTo">
        <input type="hidden" name="selectedCityId">
        <input type="hidden" name="count">
        <input type="hidden" name="order">
        <div class="input-group-prepend">
            <button class="btn btn-outline-secondary" type="submit">Поиск</button>
        </div>
    </div>
    </div>
    <div>Сортировка:</div>
    <select class="custom-select" id="orderInput" autocomplete="on" required>
        <option value="rating asc">Сортировать по рейтингу</option>
        <option value="price asc">Сортировать по стоимости (увеличение)</option>
        <option value="price desc">Сортировать по стоимости (уменьшение)</option>
    </select>
    <script>
        $(function () {
            $('input[name="daterange"]').daterangepicker({
                opens: 'left'
            }, function (start, end, label) {
                $('input[name="dateStart"]').val(start.format('YYYY-MM-DD'));
                $('input[name="dateTo"]').val(end.format('YYYY-MM-DD'));
                console.log("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
            });
        });
        $("#inputGroupSelect01").change(function () {
            let selectedOption = $("option:selected", this);
            let selectedVal = this.value;
            $('input[name="selectedCityId"]').val(selectedVal);
            console.log(selectedVal);
        });
        $("#orderInput").change(function () {
            let selectedOption = $("option:selected", this);
            let selectedVal = this.value;
            $('input[name="order"]').val(selectedVal);
            console.log(selectedVal);
        });
        $("#searchForm").submit(function (event) {
            let ord = $( "#orderInput option:selected" ).val();
                $('input[name="order"]').val(ord);
                console.log("legacy");+
                $('input[name="count"]').val($("input#input1").val());
                $('input[name="dateStart"]').val($('input[name="daterange"]').data('daterangepicker').startDate.format('YYYY-MM-DD'));
                $('input[name="dateTo"]').val($('input[name="daterange"]').data('daterangepicker').endDate.format('YYYY-MM-DD'));
                event.preventDeafult();
            }
        );
        $(".jsminus").click(function () {
            let much = +$(this).closest(".much").find("input1").val();
            let result = much - 1;
            if (result >= 1) {
                $(this).closest(".much").find("input1").val(result)
                $('input[name="count"]').val(result);
            }
            return true;
        });
        $(".jsplus").click(function () {
            let much = +$(this).closest(".much").find("input1").val();
            let result = much + 1;
            if (result >= 1) {
                $(this).closest(".much").find("input1").val(result)
                $('input[name="count"]').val(result);
            }
            return true;
        });
    </script>
    <p><b>Фильтры для поиска</b></p>
    <p><b>Тип</b></p>
    <c:forEach var="filter" items="${listFilter}">
        <input type="radio" name="filter" value="${filter.id}" checked>${filter.name}<Br>
    </c:forEach>
    <p><b>Комфорт</b></p>
    <p>
        <c:forEach var="comfort" items="${listComfort}">
        <input type="checkbox" name="${comfort.id}" value="${comfort.id}">${comfort.name}<Br>
        </c:forEach>
</form>
</body>
