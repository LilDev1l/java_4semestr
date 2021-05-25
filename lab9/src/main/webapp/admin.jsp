<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date"  %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
    <h2>Hello, ${login}</h2>
    <p>Role ${role}</p>
    <p>
        <%
            Date date = new Date();
            response.addCookie(new Cookie("date", date.toString()));
        %>
        <%= date %>
    </p>
    <a href="logout">Sign Out</a>
</body>
</html>
