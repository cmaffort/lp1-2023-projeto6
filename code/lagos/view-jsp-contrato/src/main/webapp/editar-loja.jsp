<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<t:base>
    <jsp:attribute name="title">
        Editar Loja
    </jsp:attribute>

    <jsp:body>
        <c:set var="endereco" value="${loja.getEndereco()}"/>
        <h1>Editando a Loja na rua de CEP ${endereco.getCep()}</h1>
        <form method="get">
            <label><input type="number" name="cep" value="${endereco.getCep()}"></label>
            <label><input type="number" name="numero" value="${endereco.getNumero()}"></label>
            <input type="submit" formaction="${pageContext.request.contextPath}/?acao=SalvarLoja" value="Salvar">
            <input type="submit" formaction="${pageContext.request.contextPath}/?acao=ExcluirLoja" value="Excluir Loja">
        </form>
        <a href="${pageContext.request.contextPath}/?acao=ListarLojas">Voltar para a listagem</a>
    </jsp:body>
</t:base>
