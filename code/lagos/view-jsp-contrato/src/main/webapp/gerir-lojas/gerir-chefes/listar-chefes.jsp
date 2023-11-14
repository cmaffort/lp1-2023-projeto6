<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<div class="block" id="chefes" style="width: 100%; margin-bottom: .5rem; overflow: auto; height: 20%">
    <c:forEach var="chefe" items="${chefes}">
        <div style="margin-bottom: .25rem">
            <p style="display: flex; justify-content: space-between">
                    ${chefe.getNome()} ${chefe.getSobrenome()} <span class="block" style="padding: 0 .3rem">${chefe.getUsername()}</span>
                <input type="hidden" name="chefeId" value="${chefe.getId()}">
                <input style="display: inline" class="small-button botoaoExcluirChefe" type="button" value="x">
            </p>
        </div>
    </c:forEach>
    <a class="small-button"
       href="${pageContext.request.contextPath}/servletweb?acao=CadastrarChefe&lojaId=${loja.getId()}">
        +
    </a>
</div>
