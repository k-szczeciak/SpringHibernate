<%--
  Created by IntelliJ IDEA.
  User: krzysztofszczeciak
  Date: 13/04/2019
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Hello Home</title>
</head>
<body>

<style>
    .errorClass {
        color: red;
        font-weight: bold;
    }
</style>

<form:form method="post" modelAttribute="book">

    <form:input path="name" /><br>
    <form:input path="description" /><br>
    <form:select path="publisher" items="${allPublishers}" itemLabel="name" itemValue="id" />

    <input type="submit" value="Save" />
</form:form>

</body>
</html>
