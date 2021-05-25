<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <jsp:include page="/header.jsp" />
    <p>${info}</p>
    <form action="auth" method="post">
        <input type="text" name="login" placeholder="login">
        <br><br>
        <input type="password" name="password" placeholder="password">
        <br><br>
        <input type="submit" value="Sign in">
    </form>
    <a href="registration.jsp">Sign up</a>
    <br>
    <a href="/lab10">Back</a>
    <jsp:include page="/footer.jsp" />
</body>
</html>
