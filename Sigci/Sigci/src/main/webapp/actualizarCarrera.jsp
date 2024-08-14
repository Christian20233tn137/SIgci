
<%
    // Estas lineas lo que hacen es borrar la caché, si el usuario cierra la sesión, y quiere regresar a la página de atras no lo dejaría
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="utez.edu.mx.sicci.model.User" %>
<html>
<head>
    <title>Actualizar Carrera</title>
    <link href="<%= request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/css/actualizarCarrera.css" rel="stylesheet">
    <style>
        .form-control {
            width: 100%;
            padding: 0.5rem;
            border: 1px solid #ccc;
            border-radius: 0.25rem;
            box-sizing: border-box; /* Asegura que el padding no afecte el tamaño total del elemento */
        }
        .error-message {
            color: #d9534f; /* Rojo para mensajes de error */
            font-size: 0.875rem; /* Tamaño de fuente más pequeño */
            display: block; /* Mostrar como bloque */
            margin-top: 0.25rem; /* Espaciado superior */
        }
    </style>
</head>
<body>
<%
    User u = (User) session.getAttribute("user");
    if(u != null){
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
        <%= nombre%>
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
<div class="container d-flex justify-content-center align-items-center vh-50">
<div class="col-md-6 col-lg-4 bg-light text-black p-4 rounded shadow my-custom-style">
    <center><h2>Actualizar Carreras</h2></center>
    <form action="actualizarCarrera" method="post" onsubmit="return valCarrera()">
        <input type="hidden" name="idcarrrera" class="form-control" value="${carrrera.idcarrrera}">
        <label for="descripcion">Ingrese la nueva descripción:</label>
        <input type="text" id="descripcion" name="descripcion" class="form-control" value="${carrrera.descripcion}" required>
        <span id="descripcionError" class="error-message"></span>
        <input type="hidden" value="${carrrera.idcarrrera}" name="idcarrrera" />
        <input class="registrar" type="submit" value="Aceptar">
    </form>
<a class="registrar1" href="getListaCarrera">Volver a la lista</a>
</div>
</div>
<footer class="logo">
    <svg version="1.0" xmlns="http://www.w3.org/2000/svg"
         width="80.000000pt" height="88.000000pt" viewBox="0 0 173.000000 181.000000"
         preserveAspectRatio="xMidYMid meet">
        <g transform="translate(0.000000,181.000000) scale(0.100000,-0.100000)"
           fill="#000000" stroke="none">
            <path d="M643 1690 c-17 -10 -36 -28 -42 -38 -6 -11 -25 -22 -46 -25 -64 -10
-125 -72 -125 -125 0 -16 -9 -20 -51 -24 -89 -9 -142 -69 -140 -162 0 -42 -4
-58 -20 -72 -30 -27 -58 -87 -65 -137 -8 -57 10 -117 51 -171 28 -38 34 -53
33 -95 0 -32 7 -63 19 -83 22 -39 93 -78 140 -78 27 0 33 -4 33 -21 0 -54 82
-128 142 -129 9 0 24 -10 32 -21 37 -54 116 -74 183 -48 15 6 63 10 106 9 94
-2 117 12 117 70 0 32 4 39 26 44 19 5 33 0 55 -19 17 -14 34 -25 38 -25 16 0
98 61 138 102 42 44 93 114 93 129 0 4 -12 21 -26 38 -19 23 -24 38 -20 56 5
21 12 25 46 25 63 0 75 27 75 175 0 148 -12 175 -75 175 -34 0 -41 4 -46 26
-5 18 -1 32 13 47 33 36 35 45 17 78 -32 64 -179 199 -215 199 -7 0 -25 -11
-40 -26 -20 -19 -32 -24 -53 -18 -22 5 -26 11 -26 44 0 54 -23 70 -99 70 -50
0 -69 5 -99 25 -47 32 -122 34 -169 5z m148 -59 l29 -29 0 -221 0 -221 -30 0
c-31 0 -70 30 -70 53 0 19 -20 36 -36 30 -19 -7 -18 -53 2 -81 20 -29 66 -52
104 -52 l30 0 0 -96 0 -96 -32 6 c-35 7 -48 20 -48 51 0 36 -39 86 -83 105
-51 24 -80 25 -97 5 -19 -22 5 -45 47 -45 44 0 78 -36 87 -90 5 -31 14 -45 39
-60 17 -11 44 -20 60 -20 l27 0 0 -156 0 -156 -29 -29 c-36 -36 -86 -39 -125
-8 l-27 21 30 19 c61 37 92 149 41 149 -19 0 -30 -19 -30 -49 0 -46 -84 -90
-134 -71 -46 17 -66 49 -66 107 0 59 -7 63 -68 42 -24 -8 -38 -7 -65 6 -50 24
-70 83 -48 140 7 16 -1 31 -39 71 -80 85 -78 178 6 259 39 37 44 46 35 63 -43
80 32 169 118 143 59 -17 61 -16 61 40 0 61 11 84 52 105 58 30 148 -13 148
-70 0 -38 41 -63 53 -32 11 28 -15 91 -51 125 l-36 34 23 18 c36 29 87 25 122
-10z m129 -85 c0 -33 21 -66 41 -66 6 0 29 -9 51 -20 54 -26 66 -25 99 6 l28
27 62 -62 62 -62 -27 -28 c-32 -33 -32 -41 -2 -115 27 -66 37 -76 84 -76 l32
0 0 -85 0 -85 -32 0 c-47 0 -57 -10 -84 -76 -30 -74 -30 -82 2 -115 l26 -27
-62 -62 -61 -63 -27 27 c-34 32 -42 32 -116 2 -66 -27 -76 -37 -76 -83 0 -26
-4 -33 -20 -33 -19 0 -20 7 -20 149 l0 149 45 22 c166 81 165 318 -2 392 l-43
19 0 149 c0 143 1 150 20 150 16 0 20 -7 20 -34z m-9 -376 c26 -15 49 -62 49
-105 0 -55 -39 -115 -74 -115 -3 0 -6 52 -6 115 0 63 3 115 6 115 3 0 14 -5
25 -10z"/>
            <path d="M620 1365 c-5 -14 -21 -30 -36 -35 -16 -7 -24 -16 -22 -28 9 -50 108
4 108 59 0 38 -36 41 -50 4z"/>
            <path d="M373 1299 c-17 -17 -4 -39 22 -39 53 0 73 -80 22 -96 -54 -16 -57
-54 -5 -54 21 0 39 10 59 31 31 34 37 71 17 114 -20 44 -89 70 -115 44z"/>
            <path d="M485 1013 c-32 -9 -65 -34 -81 -64 -16 -33 -19 -85 -4 -94 16 -10 40
14 40 39 1 32 24 56 64 67 38 11 50 41 20 53 -9 3 -16 5 -17 5 -1 -1 -11 -4
-22 -6z"/>
            <path d="M560 855 c0 -52 53 -105 105 -105 31 0 36 3 33 21 -2 14 -15 25 -38
33 -27 8 -38 19 -46 46 -8 23 -19 36 -33 38 -18 3 -21 -2 -21 -33z"/>
            <path d="M473 316 c-57 -26 -57 -95 0 -116 68 -25 77 -30 77 -40 0 -16 -60
-12 -66 5 -4 9 -19 15 -35 15 -36 0 -38 -22 -4 -55 49 -50 165 -25 165 36 0
37 -20 59 -65 70 -50 13 -65 27 -44 40 19 12 25 11 43 -6 16 -16 66 -21 66 -6
0 21 -46 61 -75 66 -16 3 -44 -1 -62 -9z"/>
            <path d="M805 323 c-33 -8 -73 -53 -79 -88 -8 -38 14 -100 42 -121 9 -7 39
-14 65 -14 61 0 97 31 97 85 0 35 0 35 -45 35 -38 0 -45 -3 -45 -20 0 -14 7
-20 21 -20 18 0 19 -2 9 -15 -15 -18 -51 -20 -68 -3 -16 16 -16 80 0 96 15 15
54 16 63 2 6 -10 65 -14 65 -4 0 19 -26 48 -55 60 -44 18 -53 18 -95 -4z"/>
            <path d="M1020 312 c-64 -32 -78 -135 -25 -188 35 -35 116 -34 150 1 14 13 25
31 25 40 0 21 -56 20 -64 -1 -10 -26 -59 -14 -74 19 -11 22 -11 32 0 55 15 32
64 44 74 18 7 -18 64 -22 64 -5 0 24 -24 52 -55 65 -44 18 -53 18 -95 -4z"/>
            <path d="M630 210 l0 -110 30 0 30 0 0 110 0 110 -30 0 -30 0 0 -110z"/>
            <path d="M1200 210 l0 -110 30 0 30 0 0 110 0 110 -30 0 -30 0 0 -110z"/>
        </g>
    </svg>
</footer>
<%
}else{
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
    function valCarrera() {
        // Obtener el valor del campo de texto
        const descripcion = document.getElementById("descripcion").value.trim();
        // Obtener el span donde se mostrará el mensaje de error
        const descripcionError = document.getElementById("descripcionError");

        // Limpiar el mensaje de error previo
        descripcionError.innerText = "";

        // Verificar que el campo no esté vacío y cumpla con la longitud mínima y máxima
        if (descripcion.length < 1 || descripcion.length > 50) {
            descripcionError.innerText = "El nombre debe tener entre 1 y 40 caracteres.";
            return false; // Evitar que el formulario se envíe
        }

        // Verificar que el campo contenga solo letras
        const soloLetras = /^[a-zA-Z\s]+$/;
        if (!soloLetras.test(descripcion)) {
            descripcionError.innerText = " solo puede contener letras.";
            return false; // Evitar que el formulario se envíe
        }

        // Si todo está bien, permitir que el formulario se envíe
        return true;
    }
</script>
</body>
</html>
