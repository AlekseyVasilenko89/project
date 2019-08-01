<%@ page contentType="text/html;charset=UTF-16" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <title>Список пользователей</title>
</head>
<body>
<table border="5">
    <tr>
        <td>ID</td>
        <td>Имя</td>
        <td>Возраст</td>
        <td>Пароль</td>
    </tr>
    <c:forEach items="${users}" var = "user">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getName()}</td>
            <td>${user.getAge()}</td>
            <td>${user.getPassword()}</td>
            <td>
                <form action = "update" method = "get">
                    <input type="hidden" name="id" value="${user.getId()}">
                    <input type="submit" value="Изменить" style="float:left">
                </form>
                <form action = "delete" method = "get">
                    <input type="hidden" name="id" value="${user.getId()}">
                    <input type="submit" value="Удалить" style="float:left">
                </form></td>
        </tr>
    </c:forEach>
</table>

<form action = "add" method = "get">
    <input type="submit" value="Добавить нового пользователя">
</form>
</body>
