<%--
  Created by IntelliJ IDEA.
  User: Angel
  Date: 16/08/2024
  Time: 09:46 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alerta de elminación</title>
    <link href="<%= request.getContextPath() %>/css/modal.css" rel="stylesheet">
</head>
<body>
<div id="deleteModal" class="modal">
    <div class="modal-content">
        <span class="close-button">&times;</span>
        <h2>¿Estás seguro?</h2>
        <p>¡No podrás revertir esta acción!</p>
        <button id="confirmButton" class="confirm-btn">Eliminar</button>
        <button id="cancelButton" class="cancel-btn">Cancelar</button>
    </div>
</div>
</body>
</html>
