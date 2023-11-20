<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="css/index.css">
  <link rel="icon" href="images/lagos-logo-semfundo.ico">
  <link rel="stylesheet" type="text/css" href="css/visualizar-contrato.css">
  <title>Login</title>
</head>
<body>
<div class="login">
  <h1>Fazer Login</h1>
  <form action="${pageContext.request.contextPath}/ServletWeb?acao=Login" method="post">
    <div class="form-field">
      <label for="usuario" style="background-color: #e2e3d1; color: black;">Usuario</label>
      <input type="text" name="usuario" id="usuario" required><br>
    </div>
    <div class="form-field">
      <label for="senha" style="background-color: #e2e3d1; color: black;">Senha</label>
      <input type="password" name="senha" id="senha" required style="margin: 0;">
      <img src="images/hiddenlogin.png" alt="Mostrar Senha" onclick="mostrarSenha()" class="hidden">
    </div>
    <input type="submit" value="Entrar">
  </form>
</div>
<div class="cadastro">
  <label>Nome</label>
  <label>Sobrenome</label>
  <label>Data de Nascimento</label>
  <label>E-mail</label>
  <label>Telefone</label>
  <label>Tipo de usuario</label>
  <label>Usuário</label>
  <label>Senha</label>
</div>

<script src="js/login.js"></script>
</body>
</html>
