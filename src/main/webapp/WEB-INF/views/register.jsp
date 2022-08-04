<%--
  Created by IntelliJ IDEA.
  User: tosya
  Date: 02.08.2022
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <div>
            <label for="username">
                <b>Username:</b>
            </label>
            <input type="text" placeholder="Enter Username" name="username" id="username" required>
        </div>
        <div>
            <label for="name">
                <b>Name:</b>
            </label>
            <input type="text" placeholder="Enter Name" name="name" id="name" required>
        </div>
        <div>
            <label for="female">
                <b>Gender:</b>
            </label>
            <input type="radio" name="gender" id="female" value="female" checked/>Female
            <input type="radio" name="gender" id="male" value="male"/>Male
        </div>
        <div>

            <div class="control-group">
                <label for="dateOfBirth">
                    <b>dateOfBirth:</b>
                </label>
                <input type="date" id="dateOfBirth" name="dateOfBirth"
                           value="2018-07-22" pattern="dd.MM.yyyy"
                           min="01.01.1901" max="01.01.2100">
            </div>
        </div>
        <div>
            <label for="email">
                <b>Email:</b>
            </label>
            <input type="text" placeholder="Enter Email" name="email" id="email" required>
        </div>
        <div>
            <label for="phoneNumber">
                <b>Phone number:</b>
            </label>
            <input type="text" placeholder="Enter Phone number" name="phoneNumber" id="phoneNumber" required>
        </div>
        <div>
            <label for="password"><b>Password:</b></label>
            <input type="password" placeholder="Enter Password" name="password" id="password" required>
        </div>
        <button type="submit" class="registerbtn">Register</button>
    </div>
</form>
</body>
</html>