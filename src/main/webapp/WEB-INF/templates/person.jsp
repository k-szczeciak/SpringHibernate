<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofszczeciak
  Date: 13/04/2019
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Home</title>
</head>
<body>
<form:form method="post" modelAttribute="person">

    <form:input path="firstName" /><br>
    <form:input path="lastName" /><br>
    <input type="submit" value="Save" />
</form:form>

</body>
</html>
