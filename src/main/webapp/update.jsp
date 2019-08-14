<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить данные пользователя</title>
</head>
<body>

Редактировать пользователя.

<form action="update" method="post">
    <input type="hidden" name="id" value="${param.id}">
    <input type="text" name="name" value="${user.name}" placeholder=${param.name}>
    <input type="text" name="age" value="${user.age}" placeholder=${param.age}>
    <input type="text" name="password" value="${user.password}" placeholder=${param.password}>
    <input type="text" name="role" value="${user.role}" placeholder=${param.role}>
    <input type="hidden" name="_method" value="update">
    <input type="submit" value="Обновить">
</form>
</body>
</html>