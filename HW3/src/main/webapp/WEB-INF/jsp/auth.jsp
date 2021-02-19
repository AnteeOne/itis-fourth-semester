<%--
  Created by IntelliJ IDEA.
  User: Azat
  Date: 17.02.2021
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auth</title>
</head>
<body>

<form method="post">
    <div class="container">
        <h1>Register</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>

        <label id="email"><b>Email</b></label>
        <input type="text" placeholder="Enter Email" name="email" required>

        <label id="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>

        <label id="psw-repeat"><b>Repeat Password</b></label>
        <input type="password" placeholder="Repeat Password" name="password2" required>
        <hr>

        <button type="submit" class="registerbtn">Register</button>
    </div>

</form>

</body>
</html>
