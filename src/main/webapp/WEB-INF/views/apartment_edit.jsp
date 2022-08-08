<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tosya
  Date: 07.08.2022
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        background: linear-gradient(#2E70CD, #2E77CD);
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
<h3 style="text-align: center">Апартамент</h3>
<table border="1" cellpadding="10" class="table_blur" align="center">
    <tr>
        <td>
            <div class="card" style="width: 90rem;">
                <img class="card-img-bottom" src="/getImages/${apartment.image.id}" alt="${apartment.image.name}">
                <div class="card-body" style="text-align: left">
                    <form action="/apartment/edit/${apartment.id}" method="post">
                        <input type="hidden" name="apartment" value="${apartment.id}">
                        <p class="card-text">Название: <input type="text" placeholder="Name" name="name" id="name"
                                                              value="${apartment.name}" required></p>
                        <p class="card-text">Город: <select class="custom-select" id="inputGroupSelect01"
                                                            autocomplete="on" required>
                            <option selected value=${apartment.address.city.id}>${apartment.address.city.name}</option>
                            <c:forEach var="city" items="${listCity}">
                                <c:out value="${city.id}"/>
                                <option value=<c:out value="${city.id}"/>><c:out value="${city.name}"/></option>
                            </c:forEach>
                        </select>
                        </p>
                        <input type="hidden" name="selectedCityId" value="${apartment.address.city.id}">
                        <p class="card-text">Адрес: <input type="text" placeholder="Address" name="address" id="address"
                                                           value="${apartment.address.value}" required></p>
                        <p class="card-text">Вместимость: <input type="text" placeholder="Capacity" name="capacity"
                                                                 id="capacity"
                                                                 value="${apartment.capacity}" required></p>
                        <p class="card-text">Стоимость: <input type="text" placeholder="Price" name="price" id="price"
                                                               value="${apartment.price}" required></p>
                        <p class="card-text">Рейтинг: <input type="text" placeholder="Rating" name="rating" id="rating"
                                                             value="${apartment.rating}" required></p>
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
                            <button class="btn btn-primary">Редактировать</button>
                    </form>
                </div>
            </div>
        </td>
    </tr>
</table>
</body>
<script> $("#inputGroupSelect01").change(function () {
    let selectedOption = $("option:selected", this);
    let selectedVal = this.value;
    $('input[name="selectedCityId"]').val(selectedVal);
    console.log(selectedVal);
});</script>
