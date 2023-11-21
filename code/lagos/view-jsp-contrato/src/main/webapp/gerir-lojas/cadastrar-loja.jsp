<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<jsp:useBean id="contratoAssinado" scope="request" type="br.cefetmg.lagos.model.dto.contrato.ContratoAssinado"
             class="br.cefetmg.lagos.model.dto.contrato.ContratoAssinado" />
<jsp:useBean id="numeroDeLojas" scope="request" type="java.lang.Long" />
<jsp:useBean id="erro" scope="request" type="java.lang.String"
             class="java.lang.String" />

<t:base>
    <jsp:attribute name="title">
        Editar Loja
    </jsp:attribute>

    <jsp:body>
        <c:if test="${not empty erro}">
            <div class="error">${erro}</div>
        </c:if>
        <c:choose>
            <c:when test="${numeroDeLojas >= contratoAssinado.contrato.numeroDeLojas}">
                <h1>Não é possível criar mais lojas</h1>
                <p>O seu contrato permite: ${contratoAssinado.contrato.numeroDeLojas}</p>
                <p>Número de lojas cadastradas: ${numeroDeLojas}</p>
            </c:when>
            <c:otherwise>
                <form class="center-block" method="post" style="width: 35rem; height: 20rem">
                    <h1>Digite o endereço da loja física que usará essa loja</h1>
                    <div class="form-inputs">
                        <label class="required" for="cep">CEP:</label>
                        <input id="cep" type="number" pattern="[0-9]{8}" name="cep" required>
                        <label for="numero">Número:</label>
                        <input id="numero" type="number" name="numero">
                    </div>
                    <div class="form-buttons">
                        <input class="button" type="submit" style="width: 47%"
                               formaction="${pageContext.request.contextPath}/servletweb?acao=CadastrarLoja" value="Cadastrar Loja">
                        <a class="button" type="submit" style="width: 47%"
                           href="${pageContext.request.contextPath}/servletweb?acao=ListarLojas">
                            Cancelar
                        </a>
                    </div>
                </form>
            </c:otherwise>
        </c:choose>
    </jsp:body>
</t:base>
