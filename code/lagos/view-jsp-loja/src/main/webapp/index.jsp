<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="css/login.css"/>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <h1>Fazer Login</h1>
            <form action="/loja/servletweb?acao=Login" method="post">
                <div class="form-field">
                    <label for="usuario" style="background-color: #e2e3d1; color: black;">Usuario</label>
                    <input type="text" name="usuario" id="usuario" required><br>
                </div>
                <div class="form-field">
                    <label for="senha" style="background-color: #e2e3d1; color: black;">Senha</label>
                    <input type="password" name="senha" id="senha" required>
                    <img src="images/hiddenlogin.png" alt="Mostrar Senha" onclick="mostrarSenha()" class="hidden">
                </div>
                <input type="submit" value="Entrar">
            </form>
        </div>

        <script src="js/login.js"></script>
    </body>
</html>