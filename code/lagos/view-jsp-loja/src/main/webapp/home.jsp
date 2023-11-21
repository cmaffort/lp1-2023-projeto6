<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<jsp:useBean id="usuarioLoja" scope="session" type="br.cefetmg.lagos.model.dto.loja.UsuarioLoja"
             class="br.cefetmg.lagos.model.dto.loja.UsuarioLoja" />

<t:base>
    <jsp:attribute name="title">
        Home
    </jsp:attribute>

    <jsp:body>
        Home
        Loja ${usuarioLoja.loja.id}
    </jsp:body>
</t:base>