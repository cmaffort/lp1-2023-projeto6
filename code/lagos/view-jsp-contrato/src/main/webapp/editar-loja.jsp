<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<t:base>
    <jsp:attribute name="title">
        Editar Loja
    </jsp:attribute>

    <jsp:body>
        <c:set var="endereco" value="${loja.getEndereco()}"/>
        <h1>Editando a Loja na rua de CEP ${endereco.getCep()}</h1>
        <form method="post">
            <label><input class="required" type="number" name="cep" value="${endereco.getCep()}"></label>
            <label><input class="required" type="number" name="numero" value="${endereco.getNumero()}"></label>
            <input type="hidden" name="idLoja" value="${loja.getId()}">
            <div id="chefes">
                <c:forEach var="chefe" items="${chefes}">
                    <div>
                        ${chefe}
                    </div>
                </c:forEach>
            </div>
            <a class="button"
               href="${pageContext.request.contextPath}/servletweb?acao=GetXMLLoja&lojaId=${loja.getId()}"
               download="loja${endereco.getCep()}.xml">
                Baixar XML loja
            </a>
            <input class="button" type="submit"
                   formaction="${pageContext.request.contextPath}/servletweb?acao=EditarLoja" value="Salvar">
            <input class="button" type="submit"
                   formaction="${pageContext.request.contextPath}/servletweb?acao=ExcluirLoja" value="Excluir Loja">
        </form>
        <a class="link" href="${pageContext.request.contextPath}/servletweb?acao=ListarLojas">Voltar para a listagem</a>
    </jsp:body>
</t:base>
