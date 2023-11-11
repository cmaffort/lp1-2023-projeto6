<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<t:base>
    <jsp:attribute name="title">
        Lojas
    </jsp:attribute>

    <jsp:body>
        <div class="list block">
            <c:forEach var="loja" items="${lojas}" varStatus="i">
                <div class="list-block">
                    <c:set var="endereco" value="${loja.getEndereco()}"/>
                    <div>
                        Loja ${i.index + 1}
                    </div>
                    <div>Numero: ${endereco.getNumero()}</div>
                    <div>Cep: ${endereco.getCep()}</div>
                    <a class="button"
                       href="${pageContext.request.contextPath}/servletweb?acao=EditarLoja&lojaId=${loja.getId()}">
                        Editar Loja
                    </a>
                    <c:choose>
                        <c:when test="${contratoAssinado != null}">
                            <a class="button"
                               href="${pageContext.request.contextPath}/loja/servletweb?acao=Login&lojaId=${loja.getId()}">
                                Entrar
                            </a>
                        </c:when>
                        <c:otherwise>
                            <a class="button"
                               href="${pageContext.request.contextPath}/loja/servletweb?acao=AssinarContrato">
                                Entrar
                            </a>
                        </c:otherwise>
                    </c:choose>

                </div>
            </c:forEach>
            <div id="adicionar-loja" class="list-block">

            </div>
        </div>
    </jsp:body>
</t:base>
