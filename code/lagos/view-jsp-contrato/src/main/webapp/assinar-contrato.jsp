<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<t:base>
    <jsp:attribute name="title">
        Assinar contrato
    </jsp:attribute>

    <jsp:body>
        <h1>Assinar novo contrato:</h1>

        <button id="chamar-funcao">Chamar Função</button>


        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="js/assinar-contrato.js"></script>

    </jsp:body>
</t:base>
