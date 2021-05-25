<%--
  Created by IntelliJ IDEA.
  User: max
  Date: 22.05.2021
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <jsp:include page="/header.jsp" />
    <p>${info}</p>
    <form action="registration" method="post">
        <input type="text" name="login" placeholder="login">
        <br><br>
        <input type="password" name="password" placeholder="password">
        <br><br>
        <input type="submit" value="Create account">
    </form>
    <a href="login.jsp">Sign in</a>
    <br>
    <a href="/lab10">Back</a>
    <jsp:include page="/footer.jsp" />
</body>
</html>
