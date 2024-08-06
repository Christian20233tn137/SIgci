<%@ page import="utez.edu.mx.sicci.dao.UserDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="utez.edu.mx.sicci.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuarios</title>
    <link href="<%= request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/css/listaAspirante.css" rel="stylesheet">

</head>
<body>
<center>
<table>
    <thead>
    <tr>
        <th>Nombre Completo</th>
        <th>Correo</th>
        <th>Fecha de Creación</th>
        <th>ID de División</th>
        <th>Estado Usuario</th>
    </tr>
    </thead>
    <tbody>
    <%
        // Obtenemos la lista de usuarios
        ArrayList<User> lista_aspirantes = (ArrayList<User>) request.getAttribute("lista_aspirantes");
        if (lista_aspirantes != null) {
            for(User u : lista_aspirantes) { %>
    <tr>
        <td><%=u.getNombre()%> <%=u.getApellidos()%></td>
        <td><%=u.getEmail()%></td>
        <td><%=u.getFecha_creacion()%></td>
        <td style="text-align: center"><%=u.getId_division()%></td>
        <td style="text-align: center"><%= u.getEstado_usuario() == 1 ? "Aprobado" : "Desaprobado" %></td>
    </tr>
    <% }} %>
    </tbody>
</table>
</center>
</body>
</html>
