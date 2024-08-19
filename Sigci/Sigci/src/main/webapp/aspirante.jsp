<%@ page import="utez.edu.mx.sicci.dao.UserDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="utez.edu.mx.sicci.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuarios</title>
    <link rel="icon" sizes="32x32" href="<%= request.getContextPath() %>/img/sigci.png" type="image/png">
    <link href="<%= request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/css/listaAspirante.css" rel="stylesheet">
    <script src="<%= request.getContextPath() %>/js/seekerAdmin.js"></script>

</head>
<body>
<br>
<div class="container mt-3">
    <div class="row">
        <div class="col-12 d-flex justify-content-start">
            <label ><svg version="1.0" xmlns="http://www.w3.org/2000/svg"
                         width="40.000000pt" height="30.000000pt" viewBox="0 0 512.000000 512.000000"
                         preserveAspectRatio="xMidYMid meet">

                <g transform="translate(0.000000,512.000000) scale(0.100000,-0.100000)"
                   fill="#5784E6" stroke="none">
                    <path d="M2321 5110 c-868 -84 -1644 -610 -2037 -1382 -139 -273 -221 -536
-266 -853 -20 -140 -17 -504 6 -660 39 -278 121 -541 247 -794 249 -502 647
-900 1150 -1150 815 -406 1779 -350 2539 147 297 194 579 482 771 788 74 116
184 342 234 478 51 138 110 376 131 531 23 157 26 521 6 660 -59 415 -191 769
-410 1099 -92 140 -185 254 -315 385 -399 403 -895 653 -1462 737 -122 18
-466 26 -594 14z m150 -1076 c444 -76 812 -382 963 -802 123 -344 81 -754
-110 -1058 l-55 -88 403 -403 403 -403 -135 -135 -135 -135 -405 404 -405 404
-50 -34 c-113 -79 -285 -150 -442 -181 -121 -24 -349 -23 -463 1 -257 54 -453
159 -636 341 -244 242 -364 531 -364 876 0 393 184 754 504 992 148 109 366
199 552 226 99 14 275 12 375 -5z"/>
                    <path d="M2096 3644 c-294 -65 -531 -278 -625 -560 -108 -323 -25 -656 222
-890 253 -241 628 -302 943 -155 234 109 408 323 471 577 25 103 22 305 -5
408 -80 291 -307 524 -594 607 -98 28 -313 35 -412 13z"/>
                </g>
            </svg></label>
            <input class="form-control"  id="searchTerm" type="text" onkeyup="doSearchA()" placeholder="Buscar...">
        </div>
    </div>
</div>
<center>
<table id="VistAspirante">
    <thead>
    <tr>
        <th>Nombre Completo</th>
        <th>Correo</th>
        <th>Fecha de Creación</th>
        <th>Nombre de División</th>
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
        <td style="text-align: center"><%=u.getDivisionNombre()%></td>
        <td style="text-align: center"><%= u.getEstado_usuario() == 1 ? "Aprobado" : "Desaprobado" %></td>
    </tr>
    <% }} %>
    </tbody>
</table>
</center>
</body>
</html>
