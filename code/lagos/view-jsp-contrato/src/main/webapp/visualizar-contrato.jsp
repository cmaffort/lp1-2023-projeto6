<%@taglib uri="jakarta.tags.core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Contrato</title>
    <link rel="stylesheet" type="text/css" href="css/visualizar-contrato.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
</head>
<body>
<%@include file="header.jsp" %>

    <h1>
    Contrato Assinado:
    </h1>

<div id="container">
            <p>
                Contrato ${contrato.getId()}
                <br/>
                Descrição : ${contrato.getContrato().getDescricao()}
                <br/>
                Assinado em ${contrato.getDataDeContratacao()}
                por
                ${contrato.getUsuario().getPessoa().getNome()}
                "${contrato.getUsuario().getUsername()}"
                ${contrato.getUsuario().getPessoa().getSobrenome()}
                <br/>
                Valor: ${contrato.getContrato().getPreco()}
                <br/>
                Taxa de multa : ${contrato.getContrato().getTaxaDeMulta()}
                <br/>
                Número de lojas disponiveis por contrato : ${contrato.getContrato().getNumeroDeLojas()}
                <br/>

                Periodicidade:
                    ${contrato.getContrato().getPeriodicidade().getPeriodo()}
                    ${contrato.getContrato().getPeriodicidade().getPeriodo()>1 ? "periodos" : "periodo"} de
                    ${contrato.getContrato().getPeriodicidade().getQuantidadeDiasPorPeriodo()}
                    ${contrato.getContrato().getPeriodicidade().getQuantidadeDiasPorPeriodo()>1 ? "dias" : "dia"}
                <br/>
                <br/>
                    ${contrato.getContrato().getDescricao()}
            </p>


    <div id="renovar">

        <button  onclick="mostrarRenovar()">
            Renovar Contrato
        </button>

            <div id="formularioRenovacao" style="display:none;">

                <form action="${pageContext.request.contextPath}/renovarcontrato" method="post">

                    <label for="periodoContrato">Renovar para </label>
                    <select id="periodoContrato" name="periodoContrato" required>
                        <option value="1">1 periodo</option>
                        <option value="2">2 periodos</option>
                        <option value="3">3 periodos</option>
                        <option value="6">6 periodos</option>
                        <option value="12">12 periodos</option>
                    </select>

                    <br>

                    <label for="duracaoPeriodo">com </label>
                    <select id="duracaoPeriodo" name="duracaoPeriodo" required>
                        <option value="10">10 dias</option>
                        <option value="30">30 dias</option>
                        <option value="60">60 dias</option>
                        <option value="90">90 dias</option>
                        <option value="365">365 dias</option>
                    </select>
                    <label for="duracaoPeriodo">dias por periodo</label>

                    <input type="hidden" name="usuario" value="<%= session.getAttribute("usuarioID") %>">

                    <input type="submit" value="Confirmar Renovação">

                </form>

            </div>

    </div>

    <div id="upgrade">
    <br>
        <button  onclick="mostrarUpgrade()">
            Upgrade no contrato
        </button>

        <div id="formularioUpgrade" style="display:none;">

            <form action="${pageContext.request.contextPath}/upgradecontrato" method="post">

                <label for="lojas">Adicionar número de lojas operantes</label>
                <input type="number" name="lojas" id = "lojas"  value="0" oninput="calcularValor()" required>

                <br>

                <label for="valor">Valor a ser pago a mais :</label>
                <input type="number" id="valor" name="valor" readonly>

                <input type="hidden" name="usuario" value="<%= session.getAttribute("usuarioID") %>">

                <input type="submit" value="Confirmar Upgrade">

            </form>

        </div>

    </div>

    <br>
        <form action="${pageContext.request.contextPath}/removercontrato" method="post">
            <input type="hidden" name="usuario" value="<%= session.getAttribute("usuarioID") %>">
            <input type="submit" value="Remover contrato">
</div>

<script src="js/renovar.js"></script>
</body>