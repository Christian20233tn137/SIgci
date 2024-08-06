<%@ page import="utez.edu.mx.sicci.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestionar Aspirantes</title>
</head>
<body>

<h2>Gestionar Aspirantes</h2>
<center>
    <table border="1">
        <thead>
        <tr>
            <th>Nombre Completo</th>
            <th>Correo</th>
            <th>Fecha de Creación</th>
            <th>ID de División</th>
            <th>Estado Usuario</th>
            <th>Aprobar</th>
            <th>Desaprobar</th>
        </tr>
        </thead>
        <tbody>
        <%
            // Obtenemos la lista de usuarios
            ArrayList<User> lista_admin_aspirantes = (ArrayList<User>) request.getAttribute("lista_admin_aspirantes");
            if (lista_admin_aspirantes != null) {
                for (User u : lista_admin_aspirantes) { %>
        <tr>
            <td><%= u.getNombre() %> <%= u.getApellidos() %></td>
            <td><%= u.getEmail() %></td>
            <td><%= u.getFecha_creacion() %></td>
            <td><%= u.getId_division() %></td>
            <td><%= u.getEstado_usuario() == 1 ? "Aprobado" : "Desaprobado" %></td>
            <td><a href="aprobarAspirante?id_usuario=<%= u.getId_usuario() %>">Aprobar</a></td>
            <td><a href="desaprobarAspirante?id_usuario=<%= u.getId_usuario() %>">Desaprobar</a></td>
        </tr>
        <% }} %>
        </tbody>
    </table>
</center>

</body>
</html>
