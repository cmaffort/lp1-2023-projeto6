<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<t:base>
    <jsp:attribute name="title">
        Editar Loja
    </jsp:attribute>

    <jsp:attribute name="scripts">
        <script>
            const contextPath = '${pageContext.request.contextPath}';
        </script>
        <script src="${pageContext.request.contextPath}/js/excluirChefe.js"></script>
    </jsp:attribute>

    <jsp:body>
        <c:set var="endereco" value="${loja.getEndereco()}"/>
        <c:if test="${erro != null}">
            <div class="error">${erro}</div>
        </c:if>
        <form class="center-block" method="post" style="width: 35rem; height: 40rem">
            <h1>Editando a Loja na rua de CEP ${endereco.getCep()}</h1>
            <div class="form-inputs">
                <label class="required" for="cep">CEP:</label>
                <input id="cep" type="number" pattern="[0-9]{8}" name="cep" value="${endereco.getCep()}" required>
                <label for="numero">Número:</label>
                <input id="numero" type="number" name="numero" value="${endereco.getNumero()}">
            </div>
            <input type="hidden" name="lojaId" value="${loja.getId()}">
            <h3>Chefes:</h3>
            <jsp:include page="gerir-chefes/listar-chefes.jsp" />
            <a class="button" style="width: 100%"
               href="${pageContext.request.contextPath}/servletweb?acao=GetXMLLoja&lojaId=${loja.getId()}"
               download="loja${endereco.getCep()}.xml">
                Baixar XML loja
            </a>
            <div class="form-buttons">
                <input class="button" type="submit" style="width: 47%"
                       formaction="${pageContext.request.contextPath}/servletweb?acao=EditarLoja&lojaId=${loja.getId()}"
                       value="Salvar">
                <input class="button" type="submit" style="width: 47%"
                       formaction="${pageContext.request.contextPath}/servletweb?acao=ExcluirLoja&lojaId=${loja.getId()}"
                       value="Excluir Loja">
            </div>
            <a class="link" href="${pageContext.request.contextPath}/servletweb?acao=ListarLojas">Voltar para a listagem</a>
        </form>
    </jsp:body>
</t:base>
