<%@ page import="utez.edu.mx.sicci.model.Carrrera" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Angel
  Date: 27/07/2024
  Time: 12:27 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Descripcion</th>
        <th>Actualizar</th>
        <th>Eliminar</th>
    </tr>
    </thead>
    <tbody>
    <%
        // Obtenemos la lista de usuarios
        List<Carrrera> lista_carrera= (List <Carrrera>) request.getAttribute("lista_carrera");
        if (lista_carrera != null){
            for(Carrrera c : lista_carrera){ %>
    <tr>
        <td><%=c.getDescripcion()%> </td>
        <td><a href="updateCarrera?idcarrrera=<%=c.getIdcarrrera()%>">
            <button class="styled-button"> <svg version="1.0" xmlns="http://www.w3.org/2000/svg"
                                                width="20.000000pt" height="20.000000pt" viewBox="0 0 512.000000 512.000000"
                                                preserveAspectRatio="xMidYMid meet">

                <g transform="translate(0.000000,512.000000) scale(0.100000,-0.100000)"
                   fill="#2D882D" stroke="none">
                    <path d="M2330 5109 c-604 -57 -1174 -329 -1596 -761 -168 -171 -270 -306
       -393 -520 -371 -644 -442 -1421 -194 -2113 130 -363 322 -673 587 -943 503
       -515 1208 -797 1921 -768 655 26 1246 281 1706 736 153 152 189 201 189 257
       l0 46 -242 244 c-319 320 -317 319 -450 169 -224 -253 -467 -416 -765 -516
       -289 -96 -631 -111 -928 -39 -811 197 -1362 948 -1304 1777 65 938 881 1647
       1819 1582 241 -17 408 -60 615 -160 153 -74 271 -153 420 -282 5 -5 -91 -109
       -237 -256 -135 -136 -253 -261 -262 -279 -22 -43 -20 -109 5 -163 25 -56 53
       -86 101 -111 36 -18 70 -19 835 -19 750 0 800 2 838 19 51 23 101 79 114 128
       7 25 11 302 11 809 0 864 1 847 -67 903 -41 33 -111 61 -155 61 -63 0 -103
       -31 -333 -261 -127 -126 -234 -229 -238 -229 -4 0 -52 38 -107 84 -533 448
       -1221 669 -1890 605z"/>
                </g>
            </svg></button>

        </a></td> <!-- Funcionalidad de actualizar -->
        <td><a href="borrarCarrera?idcarrrera=<%=c.getIdcarrrera()%>">
            <button class="styled-button2">
                <svg version="1.0" xmlns="http://www.w3.org/2000/svg"
                     width="20.000000pt" height="20.000000pt" viewBox="0 0 512.000000 512.000000"
                     preserveAspectRatio="xMidYMid meet">

                    <g transform="translate(0.000000,512.000000) scale(0.100000,-0.100000)"
                       fill="#C00000" stroke="none">
                        <path d="M2563 5106 c-77 -25 -127 -64 -278 -215 l-149 -151 -96 95 c-132 129
-196 160 -330 160 -83 0 -103 -4 -160 -29 -59 -27 -96 -60 -378 -340 -173
-171 -327 -329 -342 -352 -50 -71 -73 -157 -67 -249 7 -120 37 -177 152 -295
52 -53 95 -100 95 -105 0 -6 -69 -80 -154 -165 -194 -194 -211 -224 -211 -360
0 -138 16 -165 223 -373 253 -254 237 -255 525 31 l207 206 0 -1182 c0 -1325
-3 -1266 72 -1421 57 -120 169 -232 290 -290 152 -74 122 -72 1111 -69 823 3
886 4 937 22 215 71 367 218 442 426 l23 65 3 1483 2 1482 -1182 0 -1183 0
547 548 c604 604 579 574 544 666 -25 65 -323 356 -402 393 -70 32 -176 40
-241 19z m-805 -420 c15 -8 58 -46 97 -85 l70 -71 -348 -348 -347 -347 -85 86
c-92 93 -102 118 -71 177 16 30 560 574 591 591 28 15 61 14 93 -3z m694
-1922 c14 -7 36 -29 47 -47 21 -34 21 -37 21 -979 l0 -945 -23 -34 c-63 -94
-193 -88 -252 12 -20 33 -20 55 -23 947 -2 617 1 926 8 953 27 98 128 141 222
93z m668 -3 c14 -10 35 -33 48 -51 l22 -33 0 -934 c0 -1034 4 -978 -64 -1026
-22 -16 -45 -22 -83 -22 -56 0 -90 18 -127 69 -21 27 -21 34 -21 976 0 942 0
949 21 977 11 15 40 38 65 51 50 26 97 23 139 -7z m679 -8 c64 -49 61 -1 61
-1015 0 -901 0 -923 -20 -963 -53 -110 -212 -111 -264 -1 -14 31 -16 127 -16
966 0 1006 -3 956 53 1008 51 48 126 50 186 5z"/>
                        <path d="M4200 4273 c-46 -8 -974 -283 -1012 -299 -64 -29 -117 -92 -139 -166
l-8 -28 721 0 720 0 -4 163 c-3 178 -8 196 -70 258 -52 51 -144 83 -208 72z"/>
                    </g>
                </svg>
            </button>

        </a></td> <!-- Funcionalidad de borrar -->
    </tr>
    <% }} %>
    </tbody>
</table>

</body>
</html>
