<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
    <title>city</title>
</head>
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
<h3 style="text-align: center"><spring:message code="app.type"/>"</h3>
<table border="1" cellpadding="10" class="table_blur" align="center">
    <tr>
        <td>
            <form action="/admin/type/add" method="post">
                <p class="card-text"><spring:message code="app.any.name"/>: <input type="text" placeholder="<spring:message code="app.any.name"/>" name="name" id="name"
                                                      value="" required></p>
                <p class="card-text"><spring:message code="app.any.description"/>: <input type="text" placeholder="<spring:message code="app.any.description"/>" name="description"
                                                      id="description"
                                                      value="" required></p>
                <button class="btn btn-primary" type="submit" name="add"><spring:message code="app.create"/></button>
            </form>
        </td>
    </tr>
    <c:forEach var="type" items="${type}">
        <tr>
            <td>
                <div class="card" style="width: 80rem;">
                    <div class="card-body">
                        <h5 class="card-title">${type.name}</h5>
                        <p class="card-text">${type.description}</p>
                    </div>
                </div>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
