<%
    // Estas lineas lo que hacen es borrar la caché, si el usuario cierra la sesión, y quiere regresar a la página de atras no lo dejaría
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.
%>
<%@ page import="utez.edu.mx.sicci.model.Grupo" %>
<%@ page import="java.util.List" %>
<%@ page import="utez.edu.mx.sicci.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Grupos</title>
    <link rel="icon" sizes="32x32" href="<%= request.getContextPath() %>/img/sigci.png" type="image/png">
    <link href="<%= request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/css/listaGrupos.css" rel="stylesheet">
    <script src="<%= request.getContextPath() %>/js/Buscador.js"></script>
</head>
<body>
<%
    User u = (User) session.getAttribute("user");
    if (u != null) {
        String nombre = u.getNombre() + " " + u.getApellidos();
        request.setAttribute("nombre", nombre);
%>
<header>
    <div class="user">
        <svg version="1.0" xmlns="http://www.w3.org/2000/svg"
             width="40.000000pt" height="30.000000pt" viewBox="0 0 512.000000 512.000000"
             preserveAspectRatio="xMidYMid meet">
            <g transform="translate(0.000000,512.000000) scale(0.100000,-0.100000)"
               fill="#FFF" stroke="none">
                <path d="M2370 5114 c-19 -2 -78 -9 -130 -15 -791 -90 -1522 -586 -1924 -1305
           -146 -262 -252 -588 -297 -914 -18 -125 -18 -515 0 -640 105 -762 511 -1409
           1146 -1826 609 -400 1377 -517 2090 -317 929 260 1646 1043 1819 1987 156 845
           -103 1682 -705 2285 -399 398 -879 639 -1449 726 -100 15 -472 28 -550 19z
           m395 -304 c785 -72 1480 -554 1825 -1264 38 -78 83 -181 100 -231 251 -720
           129 -1508 -326 -2110 -46 -60 -105 -134 -132 -164 l-48 -54 -38 78 c-328 693
           -1082 1095 -1841 984 -574 -84 -1083 -460 -1331 -984 l-38 -78 -48 54 c-327
           364 -534 834 -578 1314 -67 727 233 1459 790 1928 464 390 1069 582 1665 527z
           m50 -3066 c315 -55 627 -230 838 -470 84 -97 189 -259 235 -367 61 -141 62
           -128 -15 -184 -278 -202 -627 -344 -983 -399 -144 -22 -491 -25 -625 -5 -254
           38 -472 104 -691 211 -123 60 -373 214 -389 240 -8 12 46 146 92 230 237 436
           659 711 1168 764 71 7 278 -4 370 -20z"/>
                <path d="M2449 4310 c-382 -47 -694 -314 -805 -687 -32 -108 -43 -293 -24
           -409 36 -224 158 -439 332 -583 89 -74 260 -162 378 -193 119 -32 346 -32 465
           0 113 31 286 119 373 192 174 146 296 360 332 584 19 116 8 301 -24 409 -81
           271 -273 495 -523 609 -143 64 -352 97 -504 78z m197 -301 c215 -30 401 -163
           494 -353 52 -106 70 -181 70 -291 0 -187 -56 -321 -190 -456 -69 -70 -101 -94
           -170 -128 -193 -94 -387 -94 -580 0 -68 34 -102 59 -171 128 -133 134 -189
           268 -189 456 0 110 18 185 69 290 104 211 320 350 568 364 12 0 56 -4 99 -10z"/>
            </g>
        </svg>
        <%= nombre %>
    </div>
    <div class="house">
        <a class="volver1" href="menuAdminppal.jsp">
            <svg version="1.0" xmlns="http://www.w3.org/2000/svg"
                 width="20.000000pt" height="20.000000pt" viewBox="0 0 512.000000 512.000000"
                 preserveAspectRatio="xMidYMid meet">

                <g transform="translate(0.000000,512.000000) scale(0.100000,-0.100000)"
                   fill="#ffffff" stroke="none">
                    <path d="M2406 4500 c-32 -12 -70 -28 -85 -38 -94 -59 -1922 -1331 -1949
-1356 -78 -73 -58 -201 39 -251 33 -18 112 -20 141 -4 21 11 271 184 1395 965
288 200 532 368 544 374 30 16 102 14 136 -4 16 -8 455 -309 975 -669 520
-360 955 -660 968 -667 28 -15 102 -15 132 0 95 50 125 165 61 241 -40 47
-1956 1368 -2027 1398 -86 35 -245 41 -330 11z"/>
                    <path d="M3755 4467 c-22 -8 -55 -21 -72 -30 -36 -19 -113 -95 -113 -112 1 -5
112 -86 247 -180 136 -93 305 -210 376 -259 l129 -88 -4 223 -3 224 -34 63
c-38 69 -80 110 -151 144 -39 19 -65 22 -190 25 -100 2 -157 -1 -185 -10z"/>
                    <path d="M2499 3908 c-14 -7 -363 -239 -775 -514 -780 -522 -816 -549 -868
-653 -57 -111 -56 -101 -56 -921 0 -831 -1 -814 61 -931 62 -115 197 -214 328
-239 30 -5 204 -10 392 -10 l339 0 0 508 c0 418 3 518 15 565 45 173 178 307
350 352 84 21 466 21 550 0 172 -45 305 -179 350 -352 12 -47 15 -147 15 -565
l0 -508 339 0 c188 0 362 5 392 10 184 35 345 196 379 379 6 33 10 346 10 800
0 811 1 801 -56 913 -52 103 -113 149 -897 672 -688 460 -751 499 -795 503
-26 2 -59 -2 -73 -9z"/>
                </g>
            </svg>
        </a>
    </div>
    <a class="logout-button" href="logout">Salir</a>
</header>
<br>
<center><h2>Gestionar Grupos</h2></center>
<div class="container mt-3">
    <div class="row">
        <div class="col-12 d-flex justify-content-start">
            <label>
                <svg version="1.0" xmlns="http://www.w3.org/2000/svg"
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
                </svg>
            </label>
            <input class="form-control" id="searchTerm" type="text" onkeyup="doSearch() " placeholder="Buscar...">
        </div>
    </div>
</div>
<br>
<center>
    <table id="descripcion">
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
            List<Grupo> lista_grupo = (List<Grupo>) request.getAttribute("lista_grupo");
            if (lista_grupo != null) {
                for (Grupo g : lista_grupo) { %>
        <tr>
            <td><%=g.getDescripcion()%>
            </td>
            <td><a href="updateGrupo?id_grupo=<%=g.getId_grupo()%>">
                <button class="styled-button">
                    <svg version="1.0" xmlns="http://www.w3.org/2000/svg"
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
                    </svg>
                </button>
            </a></td> <!-- Funcionalidad de actualizar -->
            <td><a onclick="return confirmDelete();" href="borrarGrupo?id_grupo=<%=g.getId_grupo()%>">
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
        <% }
        } %>
        </tbody>
    </table>
</center>

<%
} else {
%>
<style>
    .container-logout {
        text-align: center;
        background-color: white;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .container-logout h1 {
        color: #333;
    }

    .container-logout p {
        color: #666;
    }

    .container-logout a {
        display: inline-block;
        margin-top: 10px;
        padding: 10px 20px;
        background-color: #007bff;
        color: white;
        text-decoration: none;
        border-radius: 5px;
    }

    .container-logout a:hover {
        background-color: #0056b3;
    }

</style>
<div class="container-logout">
    <h1>Sesión Expirada</h1>
    <br>
    <svg version="1.0" xmlns="http://www.w3.org/2000/svg"
         width="200.000000pt" height="100.000000pt" viewBox="0 0 512.000000 512.000000"
         preserveAspectRatio="xMidYMid meet">

        <g transform="translate(0.000000,512.000000) scale(0.100000,-0.100000)"
           fill="#FB0D1C" stroke="none">
            <path d="M2410 5114 c-565 -50 -978 -204 -1410 -528 -110 -82 -350 -317 -436
-426 -246 -312 -420 -677 -503 -1056 -76 -344 -74 -759 5 -1108 216 -958 976
-1717 1934 -1930 192 -43 347 -59 560 -59 354 0 670 62 987 194 496 207 930
585 1213 1059 328 548 434 1223 294 1860 -229 1037 -1102 1836 -2158 1975
-119 15 -401 26 -486 19z m340 -1794 l0 -760 -190 0 -190 0 0 760 0 760 190 0
190 0 0 -760z m-570 117 l0 -204 -62 -32 c-305 -159 -499 -478 -499 -826 -1
-203 46 -363 153 -526 54 -81 156 -191 228 -244 167 -124 411 -195 619 -180
418 29 753 303 863 706 20 72 23 106 22 244 -1 143 -3 169 -27 248 -80 260
-254 473 -479 583 l-58 28 0 204 0 203 23 -6 c388 -119 722 -445 851 -835 58
-175 69 -246 69 -430 0 -184 -16 -282 -73 -445 -112 -319 -359 -595 -675 -753
-22 -11 -80 -34 -130 -52 -439 -155 -913 -72 -1282 225 -242 195 -413 487
-468 799 -20 115 -20 337 0 452 70 398 333 760 685 944 76 39 213 98 233 99 4
1 7 -91 7 -202z"/>
        </g>
    </svg>
    <br>
    <p>Tu sesión ha expirado. Por favor, vuelve a iniciar sesión.</p>
    <a href="${pageContext.request.contextPath}/login.jsp">Regresar</a>
</div>

<br>
<%
    }
%>


<script>
    function confirmDelete() {
        return confirm("¿Estás seguro de que deseas eliminar este registro?");
    }
</script>
</body>
</html>
