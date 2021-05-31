<%--
  Created by IntelliJ IDEA.
  User: max
  Date: 31.05.2021
  Time: 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<div class="navbar-collapse">
    <ul class="nav navbar-nav">
        <li><a href="${pageContext.servletContext.contextPath}/controller?command=sign_out">Выход</a></li>
    </ul>
</div>
</nav>
<div class="container">
    <H3>Добрый день, ${username}</H3>
</div>
</body>
</html>
