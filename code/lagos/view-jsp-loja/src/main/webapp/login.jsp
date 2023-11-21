<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<jsp:useBean id="erro" scope="request" type="java.lang.String" />

<t:base>
    <jsp:attribute name="title">
        Login
    </jsp:attribute>

    <jsp:attribute name="styles">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"/>
    </jsp:attribute>

    <jsp:attribute name="scripts">
        <script src="${pageContext.request.contextPath}/js/login.js"></script>
    </jsp:attribute>

    <jsp:body>
        <c:if test="${erro != null}">
            <div class="error">${erro}</div>
        </c:if>
        <div class="container">
            <h1>Fazer Login</h1>
            <form action="${pageContext.request.contextPath}/loja/servletweb?acao=Login" method="post">
                <div class="form-field">
                    <label for="username" style="background-color: #e2e3d1; color: black;">Usuário</label>
                    <input type="text" name="username" id="username" required><br>
                </div>
                <div class="form-field">
                    <label for="senha" style="background-color: #e2e3d1; color: black;">Senha</label>
                    <input type="password" name="senha" id="senha" required>
                    <img src="${pageContext.request.contextPath}/images/hiddenlogin.png" alt="Mostrar Senha" onclick="mostrarSenha()" id="hide">
                </div>
                <input type="submit" class="button" value="Entrar">
            </form>
        </div>
    </jsp:body>
</t:base>
