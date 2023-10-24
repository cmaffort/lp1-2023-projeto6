<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<%@taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@taglib uri="jakarta.tags.functions" prefix="fn" %>
<%@taglib uri="jakarta.tags.xml" prefix="x" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão de Clientes</title>
        <link rel="icon" href="images/icon_lagos.ico">
        <link rel="stylesheet" type="text/css" href="css/css_clientes.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Acme&family=Londrina+Solid&family=Righteous&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Acme&family=Chivo:wght@300&family=Londrina+Solid&family=M+PLUS+Rounded+1c&family=Mohave:wght@600&family=Righteous&family=Tilt+Neon&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    </head>
    <body>
        <header><div id="menu">
                <li class="listras_menu"></li>
                <li class="listras_menu"></li>
                <li class="listras_menu"></li>
                <menu>
                    <li></li>
                </menu>
            </div>
            <div id="nome-empresa">
                <h1>Lagos</h1>
            </div>
            <div id="aviso">
                <i class="material-symbols-outlined">notifications</i>
            </div>
        </header>
        <article>
            <h1>Gestão de Clientes</h1>
            <div id="cadastro">            
                <i class="material-symbols-outlined">add</i>
                <button id="botao_cadastro">Cadastrar Cliente</button>
            </div>
            <div id="pesquisa_cliente">
                <i class="material-symbols-outlined">search</i>
                <input type="text" name="pesquisa">
            </div>
            <div id="listar_cliente">
                <table>
                    <tr>
                        <td>Nome</td>
                        <td>Email</td>
                        <td>Telefone</td>
                        <td>Editar</td>
                    </tr>
                </table>
            </div>
        </article>
    </body>
</html>
