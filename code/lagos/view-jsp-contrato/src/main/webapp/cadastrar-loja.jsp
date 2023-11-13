<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<t:base>
    <jsp:attribute name="title">
        Editar Loja
    </jsp:attribute>

    <jsp:body>
        <c:if test="${erro != null}">
            <div class="error">${erro}</div>
        </c:if>
        <c:choose>
            <c:when test="${numeroDeLojas >= contratoAssinado.getContrato().getNumeroDeLojas()}">
                <h1>Não é possível criar mais lojas</h1>
                <p>O seu contrato permite: ${contratoAssinado.getContrato().getNumeroDeLojas()}</p>
                <p>Número de lojas cadastradas: ${numeroDeLojas}</p>
            </c:when>
            <c:otherwise>
                <h1>Cadastrar loja</h1>
                <form method="post">
                    <h3>Digite o endereço da loja física que usará essa loja</h3>
                    <label>CEP: <input class="required" type="number" name="cep"></label>
                    <label>Número: <input class="required" type="number" name="numero"></label>
                    <input type="submit" formaction="${pageContext.request.contextPath}/servletweb?acao=CadastrarLoja" value="Cadastrar Loja">
                    <input type="submit" formaction="${pageContext.request.contextPath}/servletweb?acao=ListarLojas" value="Cancelar">
                </form>
            </c:otherwise>
        </c:choose>
    </jsp:body>
</t:base>
