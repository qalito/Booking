<%--
  Created by IntelliJ IDEA.
  User: tosya
  Date: 02.08.2022
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<form action="/register" method="post">
    <div class="container">
        <h1>Register</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>

        <label for="username">
            <b>Username</b>
        </label>
        <input type="text" placeholder="Enter Username" name="username" id="username" required>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" id="password" required>

        <button type="submit" class="registerbtn">Register</button>
    </div>

</form>
</body>
</html>