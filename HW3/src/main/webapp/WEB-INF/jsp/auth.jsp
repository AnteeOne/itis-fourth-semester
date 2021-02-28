<%--
  Created by IntelliJ IDEA.
  User: Azat
  Date: 17.02.2021
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Auth</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<%--<form method="post">--%>
<form:form method="POST" modelAttribute="user">
    <div class="container">
        <span style="float: right">
        <a href="change?locale=en_En">en</a>
        |
        <a href="change?locale=ru_Ru">ru</a>
        </span>
        <h1><spring:message code="form.registration"/></h1>
        <p><spring:message code="form.info"/></p>
        <hr>


        <label id="email"><b><spring:message code="form.email"/></b></label>
<%--        <input type="text" placeholder="<spring:message code="form.email_hint"/>" name="email" required>--%>
        <form:input path="email"/>

        <label id="password"><b><spring:message code="form.password"/></b></label>
<%--        <input type="password" placeholder="<spring:message code="form.password_hint"/>" name="password" required>--%>
        <form:input path="password"/>

        <label id="password2"><b><spring:message code="form.password2"/></b></label>
<%--        <input type="password" placeholder="<spring:message code="form.password2_hint"/>" name="password2" required>--%>
        <form:input path="password2"/>
        <hr>

        <button type="submit" class="registerbtn"><spring:message code="form.submit"/></button>
    </div>

</form:form>
<%--</form>--%>

</body>
</html>
