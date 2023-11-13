<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="css/criar-contrato.css">
        <title>Criação de Contrato</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        
        <div class="container">
        <h1>Criação de Contrato</h1>
        <form id="form" action="${pageContext.request.contextPath}/CriarContrato" method="post">
            <div>
                <div class="form-field">
                    <input type="file" name="documento" id="documento" required><br>
                </div>
            </div>
            <div>
                <div class="form-field">
                    <input type="text" name="titulo" id="titulo" placeholder="Título" required><br>
                </div>
                <div class="form-field" >
                    <input type="text" name="descricao" id="descricao" placeholder="Descrição" required>
                </div>            
                <div class="form-field">
                    <input type="text" name="preco" id="preco" placeholder="Preço" required><br>
                </div>
                <div class="form-field" >
                    <input type="text" name="periodicidade" id="periodicidade" placeholder="Periodicidade" required>
                </div>
                <input type="submit" id="botao-criar" value="CRIAR">
            </div>
        </form>
    </div>
    </body>
</html>