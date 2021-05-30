<%--
  Created by IntelliJ IDEA.
  User: max
  Date: 30.05.2021
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="myshortname" uri="http://mycompany.com" %>
<html>
<head>
    <title>Demo</title>
</head>
<body>
    <jsp:useBean id="now" class="java.util.Date"/>

    <p><c:out value="JSTL подключена"/></p>

    <fmt:setLocale value="ru-RU"/>
    <p>Вывод даты в формате ru-RU<br/>
        Сегодня: <fmt:formatDate value="${now}"/>
    </p>

    <p>
        Французская валюта :
        <fmt:setLocale value="fr-FR"/>
        <fmt:formatNumber value="100" type="currency"/><br/>
    </p>

    <p>
        Количество символов в строке "lab12" =
        ${fn:length('lab12')}
    </p>

    <div>
        <h2>Пользовательские теги</h2>
        <myshortname:auth/>
        <c:set var = "items" value = "${items}"/>
        <c:set var = "iter" value = "${items.iterator()}"/>
        <myshortname:table nameTable="Продукты" countItem="${fn:length(items)}">
            <c:out value="${iter.next()}"/>
        </myshortname:table>
    </div>
</body>
</html>
