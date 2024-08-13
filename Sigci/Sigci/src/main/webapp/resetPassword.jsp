<%--
  Created by IntelliJ IDEA.
  User: jerss
  Date: 12/08/2024
  Time: 10:05 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resetear contraseña</title>
</head>
<body>
<form action="reset-password" method="post">
    <label>Correo</label>
    <input type="email" name="email">
    <br>
    <label>Nueva Contraseña</label>
    <input type="password" name="password">
    <br>
    <label>Código</label>
    <input type="text" name="cody">
    <br>
    <input type="submit" value="enviar">
</form>

</body>
</html>
