<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<jsp:useBean id="loja" scope="request" type="br.cefetmg.lagos.model.dto.contrato.Loja"
             class="br.cefetmg.lagos.model.dto.contrato.Loja" />
<jsp:useBean id="erro" scope="request" type="java.lang.String"
             class="java.lang.String" />

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
        <c:set var="endereco" value="${loja.endereco}"/>
        <c:if test="${not empty erro}">
            <div class="error">${erro}</div>
        </c:if>
        <form class="center-block" method="post" style="width: 35rem; height: 40rem">
            <h1>Editando a Loja na rua de CEP ${endereco.cep}</h1>
            <div class="form-inputs">
                <label class="required" for="cep">CEP:</label>
                <input id="cep" type="number" pattern="[0-9]{8}" name="cep" value="${endereco.cep}" required>
                <label for="numero">Número:</label>
                <input id="numero" type="number" name="numero" value="${endereco.numero}">
            </div>
            <input type="hidden" name="lojaId" value="${loja.id}">
            <h3>Chefes:</h3>
            <jsp:include page="gerir-chefes/listar-chefes.jsp" />
            <a class="button" style="width: 100%"
               href="${pageContext.request.contextPath}/servletweb?acao=GetXMLLoja&lojaId=${loja.id}"
               download="loja${endereco.cep}.xml">
                Baixar XML loja
            </a>
            <div class="form-buttons">
                <input class="button" type="submit" style="width: 47%"
                       formaction="${pageContext.request.contextPath}/servletweb?acao=EditarLoja&lojaId=${loja.id}"
                       value="Salvar">
                <input class="button" type="submit" style="width: 47%"
                       formaction="${pageContext.request.contextPath}/servletweb?acao=ExcluirLoja&lojaId=${loja.id}"
                       value="Excluir Loja">
            </div>
            <a class="link" href="${pageContext.request.contextPath}/servletweb?acao=ListarLojas">Voltar para a listagem</a>
        </form>
    </jsp:body>
</t:base>
