<!DOCTYPE html>
<html>
<head>
    <title>login</title>
    <style>
        body {
            background-color: #e2e3d1;
            color: #f2f2ea;

        }
        .container {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Resultado</h1>
        <% String user = (String) request.getAttribute("Usuario"); %>
        <% String senha = (String) request.getAttribute("Senha"); %>
        <p>Bem vindo ao sistema <%= user %></p>
        <p>Sua senha é <%= senha %></p>
    </div>
</body>
</html>