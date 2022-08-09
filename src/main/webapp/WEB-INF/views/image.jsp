<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: tosya
  Date: 08.08.2022
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<h3 style="text-align: center"><spring:message code="app.image.image"/></h3>
<table border="1" cellpadding="10" class="table_blur" align="center">
    <div class="card-group">
        <c:forEach var="image" items="${imageList}">
                <td>
                    <div class="card" style="width: 60rem;">
                        <img style="width: 25rem;" class="card-img-bottom" src="/getImages/${image.id}"
                             alt="${image.name}">
                        <div class="card-body">
                            <h5 class="card-title">${image.name}</h5>
                        </div>
                    </div>
                </td>
            <td>
                <form name="form1" method="post" action="/set/image/${image.id}">
                    <p> <spring:message code="app.image.url"/>:</p>
                    <input type="file" name="image">
                    <p>
                        <input type="text" name="name" value="${image.name}">
                        <input type = "submit" name = "Загрузить" value = "<spring:message code="app.download"/> ">
                    </p>
                </form>
            </td>
            </tr>
        </c:forEach>
    </div>
    </div>
</table>
</body>
</html>
