<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:base>
    <jsp:attribute name="title">
        Lojas
    </jsp:attribute>

    <jsp:body>
        Pagina inicial
        <a style="display: block" class="link" href="${pageContext.request.contextPath}/servletweb?acao=ListarLojas">Listar Lojas</a>
        <a style="display: block" class="link" href="${pageContext.request.contextPath}/servletweb?acao=PersonalizarInterface">Personalizar Interface</a>
    </jsp:body>
</t:base>
