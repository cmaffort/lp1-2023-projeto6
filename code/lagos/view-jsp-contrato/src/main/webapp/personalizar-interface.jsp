<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:base>
    <jsp:attribute name="title">
        Personalizar Interface
    </jsp:attribute>

    <jsp:body>
        <form method="get">
            <label>Nome da empresa: <input name="nome_da_empresa" type="text"></label>
            <label>Logo: <input name="logo" type="file" accept="image/png"></label>
            <label>Cor base: <input name="cor_base" type="color"></label>
            <input type="submit" name="submit" value="Salvar">
        </form>
    </jsp:body>
</t:base>
