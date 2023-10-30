<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Gestão de Clientes</title>
    <link rel="icon" href="${pageContext.request.contextPath}/imagens/icon_lagos.ico">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css_clientes.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Acme&family=Londrina+Solid&family=Righteous&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Acme&family=Chivo:wght@300&family=Londrina+Solid&family=M+PLUS+Rounded+1c&family=Mohave:wght@600&family=Righteous&family=Tilt+Neon&display=swap"
          rel="stylesheet">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"/>
</head>
<body>
<header>
    <div id="menu">
        <button><img src="${pageContext.request.contextPath}/imagens/menu.png"></button>
    </div>
    <div id="nome-empresa">
        <h1>Lagos</h1>
    </div>
    <div id="aviso">
        <button><img src="${pageContext.request.contextPath}/imagens/notifications.png"></button>
    </div>
</header>
<article>
    <h1>Gestão de Clientes</h1>
    <div id="pesquisa_cadastro">
        <img src="${pageContext.request.contextPath}/imagens/add.png">
        <button id="botao_cadastro">Cadastrar Cliente</button>
        <input type="text" name="pesquisa" id="input_cliente" placeholder="Busque um cliente pelo nome, email, telefone ou ID">
        <button id="botao_pesquisa"><img src="${pageContext.request.contextPath}/imagens/search.png"></button>
    </div>
    <div id="listar_cliente">
        <table>
            <tr id="listar_cliente_tr">
                <td>Nome</td>
                <td>Email</td>
                <td>Telefone</td>
                <td>Editar</td>
            </tr>
        </table>
    </div>
    <div id="editar_cliente">
        <h1>Edite os dados do Cliente</h1>
        <label for="editar_nome">Nome do cliente</label>
        <input name="editar_nome" type="text">
        <label for="editar_sobrenome">Sobrenome do Cliente</label>
        <input name="editar_sobrenome" type="text">
        <label for="editar_telefone">Número de telefone do cliente</label>
        <input name="editar_telefone" type="tel">
        <label for="editar_email">E-mail do cliente</label>
        <input name="editar_email" type="email">
    </div>
</article>
<script src="${pageContext.request.contextPath}/JS/clientes.js"></script>
</body>
</html>
