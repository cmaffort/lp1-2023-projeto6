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
                              Contrato ${contrato.getId()} <br/>
                              Assinado em ${contrato.getDataDeContratacao()} por ${contrato.getUsuario().getPessoa().getNome()}
                              "${contrato.getUsuario().getUsername()}" ${contrato.getUsuario().getPessoa().getSobrenome()}<br/>
                              valor: ${contrato.getContrato().getPreco()} <br/>
                              vigente: ${contrato.isVigente() ? "sim" : "não, ".concat
                                  (contrato.isCancelado()? "contrato cancelado." : "contrato terminado."
                                          )} <br/>
                              Periodicidade:
                                  ${contrato.getContrato().getPeriodicidade().getPeriodo()}
                                  ${contrato.getContrato().getPeriodicidade().getPeriodo()>1 ? "periodos" : "periodo"} de
                                  ${contrato.getContrato().getPeriodicidade().getQuantidadeDiasPorPeriodo()}
                                  ${contrato.getContrato().getPeriodicidade().getQuantidadeDiasPorPeriodo()>1 ? "dias" : "dia"}
                              <br/>

                              <br/>
                              ${contrato.getContrato().getDescricao()}

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
                  <div class="card swiper-slide">
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
              </c:forEach>
          </div>
      </div>
  </div>

  <!-- swiper JS -->
  <script src="js/swiper-bundle.min.js"></script>
  <!-- inicializar swiper JS -->
  <script src="js/contratos.js"></script>

</body>
</html>
