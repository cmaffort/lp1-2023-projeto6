<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <title>Login</title>
     <link rel="stylesheet" type="text/css" href="css/css_login.css" />
     <script src="JS/javascript-login.js"></script>
</head>
<body>
    <div class="container">
        <h1>Fazer Login</h1>
        <form action="servlet_login" method="post">
            <div class="form-field">
                <label for="usuario" style="background-color: #e2e3d1; color: black;" >Usuario</label>
                <input type="text" name="usuario" id="usuario" required><br>
            </div>
            <div class="form-field" >
                <label for="senha" style="background-color: #e2e3d1; color: black;">Senha</label>
                <input type="password" name="senha" id="senha" required>
                <img src="images/hiddenlogin.png" alt="Mostrar Senha" onclick="mostrarSenha()" class="hidden">
            </div>
            <input type="submit" value="Entrar">
        </form>
    </div>
</body>
</html>