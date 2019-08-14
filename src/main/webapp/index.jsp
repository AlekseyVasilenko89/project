<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Здравствуйте!</title>
</head>
<body>
<h1>Authorization</h1>

&#9733;Please log in&#9733;
<br>
<br>
<br>
<form action="/users" method="post">
    Login: <input type="text" name="name"/>
    Password: <input type="password" name="password"/>
    <input type="submit" value="Войти">
</form>
</body>
</html>
