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
            <form class="center-block" method="post" style="width: 35rem; height: 40rem">
                <c:set var="endereco" value="${loja.getEndereco()}"/>
                <h1>Cadastre um novo Chefe para a Loja na rua de CEP ${endereco.getCep()}</h1>
                <div class="form-inputs">
                    <label class="required" for="nome">Nome:</label>
                    <input id="nome" type="text" name="nome" required>

                    <label for="sobrenome">Sobrenome:</label>
                    <input id="sobrenome" type="text" name="sobrenome">

                    <label class="required" for="nascimento">Data de nascimento:</label>
                    <input id="nascimento" type="date" name="nascimento" required>

                    <label class="required" for="email">Email:</label>
                    <input id="email" type="email" name="email" required>

                    <label for="telefone">Telefone de contato:</label>
                    <input id="telefone" type="tel" pattern="[0-9]{10,11}" name="telefone">

                    <label class="required" for="salario">Salário:</label>
                    <input id="salario" type="number" name="salario" required>

                    <label class="required" for="username">Nome de usuário:</label>
                    <input id="username" type="text" name="username" required>

                    <label class="required" for="senha">Senha:</label>
                    <input id="senha" type="password" name="senha" required>

                    <input type="hidden" name="lojaId" value="${loja.getId()}">
                </div>

                <div class="form-buttons">
                    <input class="button" type="submit" style="width: 47%"
                           formaction="${pageContext.request.contextPath}/servletweb?acao=CadastrarChefe"
                           value="Cadastrar Chefe">
                    <a class="button" style="width: 47%"
                           href="${pageContext.request.contextPath}/servletweb?acao=EditarLoja&lojaId=${loja.getId()}">
                        Cancelar
                    </a>
                </div>
            </form>
    </jsp:body>
</t:base>
