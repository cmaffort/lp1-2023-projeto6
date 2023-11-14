<%@taglib uri="jakarta.tags.core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Contratos</title>

    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <!-- swiper CSS -->
    <link rel="stylesheet" type="text/css" href="css/swiper-bundle.min.css">

    <!-- style -->
    <link rel="stylesheet" type="text/css" href="css/contratos.css"/>

  </head>
<body>

  <%@include file="header.jsp" %>

  <c:if test="${listedFlag!=true}">
      <script>
          location.href="/servletweb?acao=ListarContratos";
      </script>
  </c:if>

  <script src="js/contratos.js"></script>

  <div class="wrapper">
      <div class="swiper">

          <h1>
              Contratos Assinados:
          </h1>

          <div class="swiper-wrapper">
              <c:forEach var="contrato" items="${contratosAss}">
                  <div class="card swiper-slide">
                      <div class="card-content">
                          <p>
                              Contrato assinado em ${contrato.getDataDeContratacao()} por ${contrato.getUsuario().getPessoa().getNome()}
                              "${contrato.getUsuario().getUsername()}" ${contrato.getUsuario().getPessoa().getSobrenome()}, no
                              valor de R$ ${contrato.getContrato().getPreco()} a serem pagos em

                                  ${contrato.getContrato().getPeriodicidade().getPeriodo()}
                                  ${contrato.getContrato().getPeriodicidade().getPeriodo()>1 ? "periodos" : "periodo"} de
                                  ${contrato.getContrato().getPeriodicidade().getQuantidadeDiasPorPeriodo()}
                                  ${contrato.getContrato().getPeriodicidade().getQuantidadeDiasPorPeriodo()>1 ? "dias" : "dia"}
                              <br/>
                              O contrato será vigente durante ${contrato.getContrato().getPeriodicidade().getPeriodo() *
                              contrato.getContrato().getPeriodicidade().getQuantidadeDiasPorPeriodo()} dias,
                              garantindo acesso ao sistema para ${contrato.getContrato().getNumeroDeLojas()} lojas. <br/>
                              <br/>
                              Informações adicionais:<br/>${contrato.getContrato().getDescricao()}

                          </p>
                      </div>
                  </div>
              </c:forEach>
          </div>
      </div>
      <div class="swiper">

          <h1>
              Contratos Não Assinados:
          </h1>

          <div class="swiper-wrapper">
              <c:forEach var="contrato" items="${contratos}">
                  <c:if test="${contrato.isAtivo()}">
                  <div class="card swiper-slide">
                      <div class="card-content">
                          <button onclick="deletar(${contrato.getId()})">X</button>
                          <p>
                              Contrato de uso do sistema no valor de R$ ${contrato.getPreco()} a serem pagos em
                                  ${contrato.getPeriodicidade().getPeriodo()}
                                  ${contrato.getPeriodicidade().getPeriodo()>1 ? "periodos" : "periodo"} de
                                  ${contrato.getPeriodicidade().getQuantidadeDiasPorPeriodo()}
                                  ${contrato.getPeriodicidade().getQuantidadeDiasPorPeriodo()>1 ? "dias" : "dia"}
                              <br/><br/>
                              O contrato será vigente durante ${contrato.getPeriodicidade().getPeriodo() *
                              contrato.getPeriodicidade().getQuantidadeDiasPorPeriodo()} dias,
                              garantindo acesso ao sistema para ${contrato.getNumeroDeLojas()} lojas.
                              <br/><br/>
                              Informações adicionais:<br/>${contrato.getDescricao()}
                              <br/><br/>
                              ${contrato.getTaxaDeMulta()>0.0 ? ("A quebra do Contrato determina uma multa de R$ ".concat(contrato.getTaxaDeMulta())) :
                              ("O contrato não possui multa estabelecida")}
                              <br/><br/>
                              Contrato criado em: ${contrato.getDataDeCriacao()}


                          </p>
                      </div>
                  </div>
                  </c:if>
              </c:forEach>
          </div>
      </div>
  </div>

  <div>

      <button onclick="location.href='novo-contrato.jsp'">
          Criar Contrato
      </button>

  </div>

  <!-- swiper JS -->
  <script src="js/swiper-bundle.min.js"></script>
  <!-- inicializar swiper JS -->
  <script>
      let swiper = new Swiper(".swiper", {
          effect: "cards",
          grabCursor: true,
      });
  </script>

</body>
</html>
