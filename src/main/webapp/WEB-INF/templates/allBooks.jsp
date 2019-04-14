<%--
  Created by IntelliJ IDEA.
  User: krzysztofszczeciak
  Date: 13/04/2019
  Time: 14:59
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

<c:forEach items="${allBooks}" var="book" >
    ${book.name} <br>
</c:forEach>

</body>
</html>
