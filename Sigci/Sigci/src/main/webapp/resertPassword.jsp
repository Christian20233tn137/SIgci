<%--
  Created by IntelliJ IDEA.
  User: jerss
  Date: 06/08/2024
  Time: 01:52 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Restablecer Contrasena</h2>
<form action="${pageContext.request.contextPath}/reset-password" method="post">
    <label for="correo">Correo:</label>
    <input type="email" id="correo" name="correo" required>
    <label for="password">Nueva Contrasena:</label>
    <input type="password" id="password" name="password" required>
    <label for="codigo">Código:</label>
    <input type="text" id="codigo" name="codigo" maxlength="6" required>
    <button type="submit">Cambiar Contrasena</button>
</form>
</body>
</html>
