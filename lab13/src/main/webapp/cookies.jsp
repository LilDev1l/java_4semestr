<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: max
  Date: 30.05.2021
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookies</title>
</head>
<body>
<ul>
    <c:forEach var="cook" items="${cookie}">
        <li>
            <p><c:out value="${cook.value.name}"/> : <c:out value="${cook.value.value}"/></p>
        </li>
    </c:forEach>
</ul>
</body>
</html>
