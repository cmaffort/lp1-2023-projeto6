<%@taglib uri="jakarta.tags.core" prefix="c" %>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page contentType="text/html" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html">
  <title>Criar Contrato</title>

  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

  <!-- style -->
  <link rel="stylesheet" type="text/css" href="css/contratos.css"/>

</head>
<body>
  <%@include file="header.jsp" %>

  <div class="card preview-card">
    <div class="card-content">
      <p>
        Contrato ${contrato.getId()} <br/>
        valor: ${contrato.getPreco()} <br/>

        Periodicidade:
        ${contrato.getPeriodicidade().getPeriodo()}
        ${contrato.getPeriodicidade().getPeriodo()>1 ? "periodos" : "periodo"} de
        ${contrato.getPeriodicidade().getQuantidadeDiasPorPeriodo()}
        ${contrato.getPeriodicidade().getQuantidadeDiasPorPeriodo()>1 ? "dias" : "dia"}
        <br/>

        Numero de Lojas:
        ${contrato.getNumeroDeLojas()} <br/>

        <br/>
        ${contrato.getDescricao()}



      </p>
    </div>
  </div>

  <form method="POST" action="/criarContrato" id="cadastro-contrato">

    <label for="dataCriacao">Data de Criação</label> <br/>
    <input type="date" id="dataCriacao" name="dataCriacao"
    value="<%= LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))%>" disabled> <br/>

    <label for="descricao">Descrição do Contrato</label>  <br/>
    <textarea name="descricao" id="descricao" cols="50" rows="10"></textarea> <br/>

    <label for="preco">Preço de Contratação</label>  <br/>
    <input type="number" name="preco" id="preco" class="money" pattern="^\d*(\.\d{2}$)?" step="0.01" min="0" value="0.00">  <br/>

    <label for="multa">Multa</label>  <br/>
    <input type="number" name="multa" id="multa" class="money" pattern="^\d*(\.\d{2}$)?" step="0.01" min="0" value="0.00">  <br/>

    <label for="numeroLojas">Numero de Lojas</label>  <br/>
    <input type="number" name="numeroLojas" id="numeroLojas" value="1" min="1">  <br/>

    <label for="numeroPeriodos">Quantidade de Periodos</label>  <br/>
    <input type="number" name="numeroPeriodos" id="numeroPeriodos" value= "12" min="1">  <br/>

    <label for="tamanhoPeriodos">Duração dos Periodos</label>  <br/>
    <input type="number" name="tamanhoPeriodos" id="tamanhoPeriodos" value="30" min="1">  <br/>

    <label for="documento">Documentação</label>  <br/>
    <input type="file" name="documento" id="documento">  <br/> <br/>

    <input type="submit" value="Cadastrar">

  </form>

  <script src="js/novo-contrato.js"></script>

</body>
</html>
