<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<t:base>
    <jsp:attribute name="title">
        Lojas
    </jsp:attribute>

    <jsp:body>
        <div class="list-block block">
            <c:forEach var="loja" items="${lojas}" varStatus="i">
                <div class="block">
                    <c:set var="endereco" value="${loja.getEndereco()}"/>
                    <div>
                        Loja ${i.index + 1}
                    </div>
                    <div>Numero: ${endereco.getNumero()}</div>
                    <div>Cep: ${endereco.getCep()}</div>
                    <a class="button" href="${pageContext.request.contextPath}/servletweb?acao=EditarLoja&lojaId=${loja.getId()}">Editar Loja</a>
                    <a class="button" href="${pageContext.request.contextPath}/servletweb?acao=GetXMLLoja&lojaId=${loja.getId()}"
                       download="loja${endereco.getCep()}.xml">
                        Baixar XML loja
                    </a>
                </div>
            </c:forEach>
        </div>
    </jsp:body>
</t:base>
