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
            <label><input type="number" name="cep" value="${endereco.getCep()}"></label>
            <label><input type="number" name="numero" value="${endereco.getNumero()}"></label>
            <div id="chefes">
                <c:forEach var="chefe" items="${chefes}">
                    <div>
                        ${chefe}
                    </div>
                </c:forEach>
            </div>
            <input type="submit" formaction="${pageContext.request.contextPath}/?acao=EditarLoja" value="Salvar">
            <input type="submit" formaction="${pageContext.request.contextPath}/?acao=ExcluirLoja" value="Excluir Loja">
        </form>
        <a href="${pageContext.request.contextPath}/?acao=ListarLojas">Voltar para a listagem</a>
    </jsp:body>
</t:base>
