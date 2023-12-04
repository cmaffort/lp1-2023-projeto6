<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <link rel="icon" href="images/lagos-logo-semfundo.ico">
        <link rel="stylesheet" type="text/css" href="css/visualizar-contrato.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link href="https://fonts.googleapis.com/css2?family=Acme&family=Chivo:wght@300&family=Londrina+Solid&family=M+PLUS+Rounded+1c&family=Mohave:wght@600&family=Righteous&family=Tilt+Neon&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Chivo&display=swap" rel="stylesheet">
    </head>
    <body>
        <div class="login">
          <h1>Fazer Login</h1>
          <form action="${pageContext.request.contextPath}/servletweb?acao=Login" method="get">
              
            <div class="form-field">
              <label for="usuario" style="background-color: #e2e3d1; color: black;">Usuario</label>
              <input type="text" name="usuario" id="usuario" required><br>
            </div>

            <div class="form-field">
              <label for="senha" style="background-color: #e2e3d1; color: black;">Senha</label>
              <input type="password" name="senha" id="senha" required style="margin: 0;">
              <img src="images/hiddenlogin.png" alt="Mostrar Senha" onclick="mostrarSenha()" class="hidden">
            </div>

            <div id="container-button">
              <input type="submit" value="Entrar">
              <input type="button" value="Cadastro" id="cadastrar">
            </div>

          </form>
        </div>
        <div class="cadastro">
            <p id="voltar">Voltar</p>
            <p id="error-message">Por favor, preencha todos os campos.</p>
            <label>Nome:
              <input type="text" class="input-cadastro" name="nome" required>
            </label>
            <label>Sobrenome
              <input type="text" class="input-cadastro" name="sobrenome" required>
            </label>
            <label>Data de Nascimento
              <input type="date" class="input-cadastro" name="dataNascimento" required>
            </label>
            <label>E-mail
              <input type="email" class="input-cadastro" name="email" required>
            </label>
            <label>Telefone
              <input type="tel" name="telefone" class="input-cadastro" required>
            </label>
            <label id="tipo-usuario">Tipo de usuario:
              <label for="gerenteContrato">Gerente de Contrato</label>
              <input type="radio" id="gerenteContrato" name="tipoUsuario" value="GERENTE_DE_CONTRATOS" class="input-cadastro" required>

              <label for="contratante">Contratante</label>
              <input type="radio" id="contratante" name="tipoUsuario" value="CONTRATANTE" class="input-cadastro" required>
            </label>
            <label>Usuário
              <input type="text" class="input-cadastro" name="usuario" required>
            </label>
            <label>Senha
              <input type="password" class="input-cadastro" name="senha" required>
            </label>
            <input type="button" value="Cadastrar" id="enviarCadastro">
        </div>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="js/login.js"></script>
    </body>
</html>
