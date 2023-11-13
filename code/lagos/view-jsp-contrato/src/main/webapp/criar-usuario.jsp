<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:base>
    <jsp:attribute name="title">
        Criar usuario
    </jsp:attribute>

    <jsp:body>
        <form action="" method="post">
            <label>Nome: <input type="text" name="nome"></label>
            <label></label>
            <label>Nome de usuario: <input type="text" name="username"></label>
            <label>Senha: <input type="password" name="senha"></label>
            <input type="submit" value="Criar conta">
        </form>
        <a class="link" href="${pageContext.request.contextPath}/login.jsp">Login</a>
    </jsp:body>
</t:base>