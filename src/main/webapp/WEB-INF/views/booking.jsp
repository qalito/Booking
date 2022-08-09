<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Users</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
</head>
<body>

<div class="dropdown">
    <h3 align="center"><spring:message code="app.header.booking"/></h3>
    <table border="1" cellpadding="10" class="table_blur" align="center">
        <tr>
            <th><spring:message code="app.apartmet"/>:</th>
            <th><spring:message code="app.booking.number"/>:</th>
            <th><spring:message code="app.booking.status"/>:</th>
            <th><spring:message code="app.booking.date"/>:</th>
            <th><spring:message code="app.header.booking"/><spring:message code="app.searchresults.st"/>:</th>
            <th><spring:message code="app.header.booking"/><spring:message code="app.searchresults.po"/>:</th>
            <th><spring:message code="app.user.name"/>:</th>
            <th><spring:message code="app.booking.total"/>:</th>
            <th><spring:message code="app.terminate"/></th>
        </tr>
        <c:forEach var="el" items="${bookings}">
            <tr>
                <td><c:forEach var="apartment" items="${el.bookingApartment}">
                    <input type="hidden" name="apartment" value="${apartment}">
                    <div class="card" style="width: 30rem;">
                        <h5 class="card-title">${apartment.name}</h5>
                        <img class="card-img-bottom" style="width: 30rem;" src="/getImages/${apartment.image.id}"
                             alt="${apartment.image.name}">
                        <div class="card-body">
                            <p class="card-text"><spring:message code="app.apartmet.name"/>: ${apartment.type.name}</p>
                            <p class="card-text"><spring:message
                                    code="app.apartmet.city"/>: ${apartment.address.city.name}</p>
                            <p class="card-text"><spring:message
                                    code="app.apartmet.country"/>: ${apartment.address.country.name}</p>
                            <p class="card-text"><spring:message
                                    code="app.apartmet.address"/>: ${apartment.address.value}</p>
                            <p class="card-text"><spring:message
                                    code="app.apartmet.capacity"/>: ${apartment.capacity}</p>
                            <p class="card-text"><spring:message code="app.apartmet.price"/>: ${apartment.price}</p>
                            <p class="card-text"><spring:message code="app.apartmet.raiting"/>:${apartment.rating}</p>
                            <p class="card-text"><spring:message
                                    code="app.apartmet.owner"/> ${apartment.partner.user.username}, ${apartment.partner.user.name} </p>
                            <p class="card-text"><spring:message
                                    code="app.apartmet.comunic"/> ${apartment.partner.user.phoneNumber} <spring:message
                                    code="app.apartmet.email"/> ${apartment.partner.user.email}</p>
                            <spring:message code="app.apartmet.listComfort"/>:
                            <c:forEach var="comfort" items="${apartment.apartmentComfort}">
                                ${comfort.name};
                            </c:forEach>
                        </div>
                    </div>
                </c:forEach></td>
                <td><c:out value="${el.number}"/></td>
                <td><c:out value="${el.status}"/></td>
                <td><c:out value="${el.dateBooking}"/></td>
                <td><c:out value="${el.dateStart}"/></td>
                <td><c:out value="${el.dateTo}"/></td>
                <td><spring:message code="app.user.name"/>: ${el.user.username}, ${el.user.name} <spring:message
                        code="app.basket.phone"/>: ${el.user.phoneNumber} <spring:message
                        code="app.basket.email"/>: ${el.user.email}</td>
                <td><c:out value="${el.total}"/></td>
                <td>
                    <sec:authorize access="hasAnyRole('ADMIN', 'ROLE_PARTNER','ROLE_USER')">
                        <a style="width: 100%" href="/change/booking/${el.id}/AN"
                           class="btn btn-primary"><spring:message code="app.terminate"/></a>
                        </p>
                    </sec:authorize>
                    <sec:authorize access="hasAnyRole('ADMIN')">
                        <a style="width: 100%" href="/change/booking/${el.id}/ST"
                           class="btn btn-primary"><spring:message code="app.inital"/></a>
                        </p>
                    </sec:authorize>
                    <sec:authorize access="hasAnyRole('ADMIN', 'ROLE_PARTNER')">
                        <a style="width: 100%" href="/change/booking/${el.id}/OK"
                           class="btn btn-primary"><spring:message code="app.confirm"/></a>
                        </p>
                    </sec:authorize>
                    <sec:authorize access="hasAnyRole('ADMIN', 'ROLE_PARTNER')">
                    <a style="width: 100%" href="/change/booking/${el.id}/CL" class="btn btn-primary">
                            <spring:message code="app.close"/>
                        </sec:authorize>
                </td>
            </tr>
            </tr>
            <tr>
                <td>


                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>