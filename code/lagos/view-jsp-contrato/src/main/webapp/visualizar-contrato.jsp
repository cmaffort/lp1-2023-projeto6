<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset=UTF-8">
    <link rel="icon" href="images/lagos-logo-semfundo.ico">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/visualizar-contrato.css">
    <title>Visualizar Contrato</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Chivo&display=swap" rel="stylesheet">
    <jsp:include page="header.jsp"/>
    <article>

        <h1>Contratos à Venda</h1>

        <div id="container">

        </div>
    </article>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/visualizar-contrato.js"></script>
    </body>
</html>