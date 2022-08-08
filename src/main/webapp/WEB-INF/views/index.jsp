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
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"/>
<body weight="80%">
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
    <div style="background: #FFE87C;">
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
            <input type="hidden" name="filter" value="1">
            <div class="input-group-prepend">
                <button class="btn btn-outline-secondary" type="submit">Поиск</button>
            </div>
        </div>
    </div>
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
                let ord = $("#orderInput option:selected").val();
                $('input[name="order"]').val(ord);
                console.log("legacy");
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

    <h3>Популярные направления:</h3>
    <h5>Страны:</h5>
    <div class="card-group">
        <c:forEach var="country" items="${listCountry}">
            <div class="card" style="width: 18rem;">
                <img class="card-img-bottom" src="/getImages/${country.image.id}" alt="${country.image.name}">
                <div class="card-body">
                    <h5 class="card-title">${country.name}</h5>
                    <p class="card-text">${country.description}</p>
                    <select class="custom-select" id="inputGroupSelect02" autocomplete="on">
                        <option disabled selected>Города</option>
                        <c:forEach var="city" items="${country.cities}">
                            <c:out value="${city.id}"/>
                            <option value=<c:out value="${city.id}"/>><c:out value="${city.name}"/></option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </c:forEach>
    </div>
    <h5>Популярные города:</h5>
    <div class="card-group">
        <c:forEach var="city" items="${listCity}" varStatus="status">
            <c:if test="${status.count%2==0}">
            </c:if>
            <div class="card-group">
                <div class="row">
                    <div class="col-md-4">
                        <div class="card" style="width: 31rem;">
                            <img src="/getImages/${city.image.id}" alt="${city.image.name}">
                            <div class="card-body">
                                <h5 class="card-title">${city.name}</h5>
                                <p class="card-text">${city.description}</p>
                                <input type="hidden" name="selectedCityId" value=${city.id}>
                                <!--button type="submit" class="btn btn-primary">Поиск по введенным данным</button-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</form>
</body>
