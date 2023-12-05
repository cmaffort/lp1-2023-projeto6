<%@ page import="java.io.File" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu de Links</title>
    <link rel="stylesheet" type="text/css" href="css/menu.css" />
</head>
<body>
    <%@include file="header.jsp" %>
    <div class="menuL">
        <h1>Menu de Links</h1>
        <%
        if (pasta.listFiles() != null) {
            for (File arquivo : pasta.listFiles()) {
                if (arquivo.isFile() &&
                    arquivo.getName().endsWith(".jsp") &&
                    !arquivo.getName().equals("menu.jsp") &&
                    !arquivo.getName().equals("header.jsp") &&
                    !arquivo.getName().equals("index.jsp") &&
                    !arquivo.getName().equals("404.jsp") &&
                    !arquivo.getName().equals("login.jsp") &&
                    !arquivo.getName().equals("dados-usuario.jsp")) {

                        String nomeArquivo = arquivo.getName().replace(".jsp", "");
        %>
        <a href="<%= request.getContextPath() %>/<%= nomeArquivo %>.jsp"><%= nomeArquivo %></a><br>
        <%
                }
            }
        }
        %>
    </div>
</body>
</html>