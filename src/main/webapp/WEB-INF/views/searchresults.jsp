<%--
  Created by IntelliJ IDEA.
  User: tosya
  Date: 02.08.2022
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="card-group">
    <c:forEach var="apartment" items="${apartments}">
        <div class="card" style="width: 18rem;">
            <img src="/getImages/${apartment.image.id}" alt="${apartment.image.name}">
            <div class="card-body">
                <h5 class="card-title">${apartment.name}</h5>
                <a href="/" class="btn btn-primary">Забронировать</a>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
