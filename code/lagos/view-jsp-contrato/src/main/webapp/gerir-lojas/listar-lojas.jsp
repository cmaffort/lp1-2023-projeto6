<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

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
                    <c:set var="endereco" value="${loja.getEndereco()}"/>
                    <div>
                        Loja ${i.index + 1}
                    </div>
                    <div>Cep: ${endereco.getCep()}</div>
                    <c:if test="${endereco.getNumero() != null}">
                        <div>Numero: ${endereco.getNumero()}</div>
                    </c:if>

                    <div class="lojas-actions">
                        <c:choose>
                            <c:when test="${contratoAssinado != null}">
                                <a class="button"
                                   href="${pageContext.request.contextPath}/servletweb?acao=LoginLoja&lojaId=${loja.getId()}">
                                    Entrar
                                </a>
                            </c:when>
                            <c:otherwise>
                                <a class="button"
                                   href="${pageContext.request.contextPath}/servletweb?acao=AssinarContrato">
                                    Entrar
                                </a>
                            </c:otherwise>
                        </c:choose>
                        <a class="button"
                           href="${pageContext.request.contextPath}/servletweb?acao=EditarLoja&lojaId=${loja.getId()}">
                            Editar Loja
                        </a>
                    </div>

                </div>
            </c:forEach>
            <c:if test="${lojas.size() < contratoAssinado.getContrato().getNumeroDeLojas()}">
                <a id="cadastrar-loja" class="list-block" href="${pageContext.request.contextPath}/servletweb?acao=CadastrarLoja">
                    +
                </a>
            </c:if>
        </div>
    </jsp:body>
</t:base>
