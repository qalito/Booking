<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tosya
  Date: 08.08.2022
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Country</title>
</head>
<body>
<div class="card-group">
    <c:forEach var="country" items="${listCountry}">
        <div class="card" style="width: 25rem;">
            <img style="width: 25rem;" class="card-img-bottom" src="/getImages/${country.image.id}" alt="${country.image.name}">
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
</div>
</body>
</html>
