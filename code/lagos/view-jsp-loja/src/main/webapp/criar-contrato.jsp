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
        <form id="form" action="${pageContext.request.contextPath}/CriarContrato" method="get">
            <div>
                <div class="form-field">
                    <input type="file" name="documento" id="documento" required><br>
                </div>
            </div>
            <div>
                <div class="form-field">
                    <input type="number" name="id" id="id" placeholder="ID" required><br>
                </div>
                <div class="form-field">
                    <input type="text" name="descricao" id="descricao" placeholder="Descrição" required>
                </div>            
                <div class="form-field">
                    <input type="number" name="preco" id="preco" step=".01" placeholder="Preço" required><br>
                </div>
                <div class="form-field">
                    <input type="number" name="periodo" id="periodo" placeholder="Período" required>
                </div>
                <div class="form-field">
                    <input type="number" name="quantidadeDiasPorPeriodo" id="quantidadeDiasPorPeriodo" placeholder="Quantidade de Dias por Período" required>
                </div>
                <div class="form-field">
                    <input type="number" name="taxaDeMulta" id="taxaDeMulta" step=".01" placeholder="Taxa de Multa" required>
                </div>
                <div class="form-field">
                    <input type="number" name="numeroDeLojas" id="numeroDeLojas" placeholder="Número de Lojas" required>
                </div>
                <div class="form-field">
                    <input type="date" name="dataDeCriacao" id="dataDeCriacao" placeholder="Data de Criação" required>
                </div>
                <input type="submit" id="botao-criar" value="CRIAR">
            </div>
        </form>
    </div>
    </body>
</html>