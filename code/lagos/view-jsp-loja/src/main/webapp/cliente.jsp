<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão de Clientes</title>
        <link rel="icon" href="images/icon_lagos.ico">
        <link rel="stylesheet" type="text/css" href="css/clientes.css">
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
        <%@include file="header.jsp" %>

        <h1>Gestão de Clientes</h1>
        <div id="pesquisa_cadastro">
            <img src="images/add.png">

            <button id="botao_cadastro">Cadastrar Cliente</button>

            <input type="text" name="pesquisa" id="input_cliente"
                   placeholder="Busque um cliente pelo nome">
            <button id="botao_pesquisa"><img src="images/search.png"></button>
        </div>

        <div id="listar_cliente">
            <table id="tabela_clientes">
                <thead>
                <tr> 
                    <td>Nome</td>
                    <td>Email</td>
                    <td>Telefone</td>
                    <td>Editar</td>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>

        <div id="editar_cliente">
            <button id="fechar">X</button>

            <h1>Edite os dados do Cliente</h1>

            <label for="editar-nome">Nome do cliente</label>
            <input id="editar-nome" class="input_cadastro" name="editar_nome" type="text" required>

            <label for="editar-sobrenome">Sobrenome do Cliente</label>
            <input id="editar-sobrenome" class="input_cadastro" name="editar_sobrenome" type="text" required>

            <label for="editar-telefone">Número de telefone do cliente</label>
            <input id="editar-telefone" class="input_cadastro" name="editar_telefone" type="tel"
                   pattern="(\d{2}[-\s]?)(\d{5}[-\s]?\d{4}|\d{4}[-\s]?\d{4})" required>

            <label for="editar-email">E-mail do cliente</label>
            <input id="editar-email" class="input_cadastro" name="editar_email" type="email" required>

            <button id="concluir">Concluir</button>
        </div>

        <script src="js/clientes.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    </body>
</html>
