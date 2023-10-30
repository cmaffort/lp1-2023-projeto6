<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
     <title>Central de Avisos</title>
     <link rel="stylesheet" type="text/css" href="../css/css_tela_aviso.css" />
</head>
<body>
    <%@include file="Header.jsp" %>
    
    <h1>Avisos</h1>
    
    <div id="avisos-container">
        <!-- Avisos serão adicionados aqui -->
    </div>
    
    <img id="criar-aviso" src="../images/adicionar.svg" alt="criar aviso" class="hidden">
    

    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="../JS/js_avisos.js"></script>   

</body>
</html>
