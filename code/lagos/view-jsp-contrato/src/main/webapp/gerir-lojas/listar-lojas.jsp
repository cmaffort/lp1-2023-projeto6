<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<jsp:useBean id="lojas" scope="request" type="java.util.List<br.cefetmg.lagos.model.dto.contrato.Loja>"
             class="java.util.ArrayList" />
<jsp:useBean id="contratoAssinado" scope="request" type="br.cefetmg.lagos.model.dto.contrato.ContratoAssinado"
             class="br.cefetmg.lagos.model.dto.contrato.ContratoAssinado" />

<t:base>
    <jsp:attribute name="title">
        Lojas
    </jsp:attribute>

    <jsp:attribute name="styles">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/listar-loja.css">
    </jsp:attribute>

    <jsp:body>
        <div class="list block">
            <c:forEach var="loja" items="${lojas}" varStatus="i">
                <div class="list-block">
                    <c:set var="endereco" value="${loja.endereco}"/>
                    <div>
                        Loja ${i.index + 1}
                    </div>
                    <div>Cep: ${endereco.cep}</div>
                    <c:if test="${not empty endereco.numero}">
                        <div>Numero: ${endereco.numero}</div>
                    </c:if>
                    <div class="lojas-actions">
                        <a class="button"
                           href="${pageContext.request.contextPath}/servletweb?acao=EditarLoja&lojaId=${loja.id}">
                            Editar Loja
                        </a>
                    </div>

                </div>
            </c:forEach>
            <c:if test="${lojas.size() < contratoAssinado.contrato.numeroDeLojas}">
                <a id="cadastrar-loja" class="list-block" href="${pageContext.request.contextPath}/servletweb?acao=CadastrarLoja">
                    +
                </a>
            </c:if>
        </div>
    </jsp:body>
</t:base>
