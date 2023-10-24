<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
     <title>Central de Avisos</title>
     <link rel="stylesheet" type="text/css" href="../css/css_login.css" />
     <link rel="stylesheet" type="text/css" href="../css/css_tela_aviso.css" />
</head>
<body>
    <%@include file="Header.jsp" %>
    
    <div id="avisos">
    </div>
    
    <img id="criar-aviso" src="../images/adicionar.svg" alt="criar aviso" onclick="mostrarSenha()" class="hidden">
    
    <script src="../JS/javascript_avisos.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</body>
</html>
