<%--
  Created by IntelliJ IDEA.
  User: Angel
  Date: 11/07/2024
  Time: 01:30 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario de Recuperación de contraseña</title>
    <link rel="icon" sizes="32x32" href="<%= request.getContextPath() %>/img/sigci.png" type="image/png">
    <link href="bootstrap.css" rel="stylesheet">
    <link href="restablecerContra.css" rel="stylesheet">
</head>

<body>
<header>
    <div class="user"> <svg version="1.0" xmlns="http://www.w3.org/2000/svg"
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
    </svg> Administrador</div>



    <button class="logout-button">Salir</button>
</header>
<div class="medioCirculo"></div>
<div class="login-box">
    <h2>Restablecer contraseña</h2>
    <p>El usuario ***** ha olvidado su contraseña</p>
    <form id="FormLogin">
        <div class="user-box">
            <input type="password" id="newpassword" name="nuevaContraseña" required>
            <label> Nueva contraseña</label>
        </div>
        <div class="user-box">
            <input type="password" id="newpassword1" name="nuevaContraseña1" required>
            <label>Confirmar contraseña</label>
        </div>
        <button href="verX.html" id="botonInicio" name="botonInicio" class="registar">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            Restablecer contraseña
        </button>
    </form>
</div>


<script src="script.js"></script>
<script src="bootstrap.js"></script>
</body>
</html>


