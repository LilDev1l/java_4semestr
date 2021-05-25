<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <jsp:include page="/header.jsp" />
    <h2>Hello, ${login}</h2>
    <p>Role ${role}</p>
    <p>
        <%
            Date date = new Date();
            response.addCookie(new Cookie("date", date.toString()));
        %>
        <%= date %>
    </p>
    <div>
        <h2>Yacht Clubs List</h2>
        <p><a href='<c:url value="/insert" />'>Create new</a></p>
        <table border="1">
            <tr><th>Name</th><th>Price</th><th></th></tr>
            <c:forEach var="yachtClub" items="${yachtClubs}">
                <tr><td>${yachtClub.name}</td>
                    <td>${yachtClub.price}</td>
                    <td>
                        <a href='<c:url value="/edit?id=${yachtClub.id}" />'>Edit</a> |
                        <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                            <input type="hidden" name="id" value="${yachtClub.id}">
                            <input type="submit" value="Delete">
                        </form>
                    </td></tr>
            </c:forEach>
        </table>
    </div>
    <a href="logout">Sign Out</a>
    <jsp:include page="/footer.jsp" />
</body>
</html>
