<%--
  Created by IntelliJ IDEA.
  User: max
  Date: 25.05.2021
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h3>Edit YachtClub</h3>
<form method="post">
    <input type="hidden" value="${yachtClub.id}" name="id" />
    <label>Name</label><br>
    <input name="name" value="${yachtClub.name}" /><br><br>
    <label>Price</label><br>
    <input name="price" value="${yachtClub.price}" type="number" min="100" /><br><br>
    <input type="submit" value="Send" />
</form>
</body>
</html>
