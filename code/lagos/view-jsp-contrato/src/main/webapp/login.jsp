<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:base>
    <jsp:attribute name="title">
        Login
    </jsp:attribute>

    <jsp:body>
        <form action="" method="post">
            <label>Nome de usuario: <input type="text" name="username"></label>
            <label>Senha: <input type="password" name="senha"></label>
            <input type="submit" value="Entrar">
        </form>
        <a href="${pageContext.request.contextPath}/?acao=CriarUsuario">Criar conta</a>
    </jsp:body>
</t:base>
