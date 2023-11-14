<%@ tag description="Base Page template" pageEncoding="UTF-8" %>
<%@ attribute name="title" fragment="true" %>
<%@ attribute name="styles" fragment="true" %>
<%@ attribute name="scripts" fragment="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title><jsp:invoke fragment="title"/></title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
        <jsp:invoke fragment="styles"/>
    </head>
    <body>
        <header>
            <%@include file="header.jsp"%>
        </header>

        <main>
            <jsp:doBody/>
        </main>

        <footer>
            <%@include file="footer.jsp"%>
        </footer>

        <script src="https://code.jquery.com/jquery-3.7.1.min.js"
                integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
                crossorigin="anonymous"></script>
        <jsp:invoke fragment="scripts"/>
    </body>
</html>