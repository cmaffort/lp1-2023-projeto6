<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<jsp:useBean id="configuracoesDeInterface" scope="request" type="br.cefetmg.lagos.model.dto.contrato.ConfiguracoesDeInterface"/>
<jsp:useBean id="erro" scope="request" type="java.lang.String"/>

<t:base>
    <jsp:attribute name="title">
        Personalizar Interface
    </jsp:attribute>

    <jsp:body>
        <c:if test="${erro != null}">
            <div class="error">${erro}</div>
        </c:if>
        <form class="center-block" method="post" style="width: 35rem; height: 20rem" enctype="multipart/form-data">
            <h1>Configure a interface das suas lojas</h1>
            <div class="form-inputs">
                <label for="nome_da_empresa">Nome da empresa:</label>
                <input id="nome_da_empresa" name="nome_da_empresa" type="text" value="${configuracoesDeInterface.nomeDaEmpresa}">

                <label for="logo">Logo:</label>
                <input id="logo" name="logo" type="file" accept="image/png">

                <label for="cor_base">Cor base:</label>
                <input id="cor_base" name="cor_base" type="color" value="${configuracoesDeInterface.corBase}">
            </div>
            <div class="form-buttons">
                <input class="button" style="width: 47%" type="submit"
                       formaction="${pageContext.request.contextPath}/servletweb?acao=PersonalizarInterface"
                       value="Salvar">
                <a class="button" type="submit" style="width: 47%"
                   href="${pageContext.request.contextPath}/servletweb?acao=Home">
                    Cancelar
                </a>
            </div>
        </form>
    </jsp:body>
</t:base>
