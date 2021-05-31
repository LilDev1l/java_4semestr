<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
</head>
</body>
<div class = "login-page">
  <div class="form">
    <p><font color="red">${errorMessage}</font></p>
    <form class="login-form" action="${pageContext.servletContext.contextPath}/controller?command=login" method="post">
      <p> Вход в систему </p>
      <p> Имя : <input name="loginName" type="text" />
      </p>
      <p> Пароль : <input name="password" type="password" />
      </p>
      <input class ="button-main-page" type="submit" value="Войти"/>
    </form>
    <div>
      <form action="${pageContext.servletContext.contextPath}/controller?command=registration_page" method="post">
        <input class ="button-main-page" type="submit" value="Регистрация"/>
      </form>
    </div>
  </div>
</div>
</body>
</html>