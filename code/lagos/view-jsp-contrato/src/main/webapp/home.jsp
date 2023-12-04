<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<%@ page import="br.cefetmg.lagos.model.dto.enums.Permissao" %>

<jsp:useBean id="usuario" scope="session" type="br.cefetmg.lagos.model.dto.contrato.Usuario"
             class="br.cefetmg.lagos.model.dto.contrato.Usuario" />
<jsp:useBean id="contratoAssinado" scope="request" type="br.cefetmg.lagos.model.dto.contrato.ContratoAssinado"
             class="br.cefetmg.lagos.model.dto.contrato.ContratoAssinado" />
<jsp:useBean id="lojaContextPath" scope="request" type="java.lang.String"
             class="java.lang.String" />

<t:base>
    <jsp:attribute name="title">
        Lojas
    </jsp:attribute>

    <jsp:body>
        <h1>Pagina inicial</h1>
        <c:if test="${usuario.permicoes.contains(Permissao.GERIR_LOJAS)}">
            <a style:"display: block" class="link" href="${pageContext.request.contextPath}/visualizar-contrato.jsp">Visualizar Contratos</a>
            <a style:"display: block" class="link" href="${pageContext.request.contextPath}/criar-usuario.jsp">Criar Funcionario</a>
            <a style="display: block" class="link" href="${pageContext.request.contextPath}/servletweb?acao=ListarLojas">Listar Lojas</a>
            <a style="display: block" class="link" href="${pageContext.request.contextPath}/servletweb?acao=PersonalizarInterface">Personalizar Interface</a>
            <c:choose>
                <c:when test="${not empty contratoAssinado}">
                    <a class="button"
                       href="${lojaContextPath}/servletweb?acao=Login">
                        Entrar no sistema de loja
                    </a>
                </c:when>
                <c:otherwise>
                    <a class="button"
                       href="${pageContext.request.contextPath}/servletweb?acao=AssinarContrato">
                        Entrar no sistema de loja
                    </a>
                </c:otherwise>
            </c:choose>
        </c:if>
    </jsp:body>
</t:base>
