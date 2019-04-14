<%--
  Created by IntelliJ IDEA.
  User: krzysztofszczeciak
  Date: 14/04/2019
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>testOfBookValidator</title>
</head>
<body>


<c:forEach items="${violationsList}" var="violationsList" >
    ${violationsList} <br>
</c:forEach>
</body>
</html>
