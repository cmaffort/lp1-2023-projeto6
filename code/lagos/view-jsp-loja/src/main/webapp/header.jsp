<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.io.File" %>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <link rel="stylesheet" type="text/css" href="css/headerWAPP.css"/>
        <title></title>
    </head>
    <body>
        <header>

            <div class="logo"><img src="images/lagos-semfundo.svg" alt="logo lagos" id="logo"></div>

            <div class="menu-button" onclick="toggleMenu()">
                <div class="menu-icon"></div>
                <div class="menu-icon"></div>
                <div class="menu-icon"></div>
            </div>

        </header>

        <div class="linha"></div>

        <div class="menu" id="menu">
            <%
                String caminho = getServletContext().getRealPath("/");
                File pasta = new File(caminho);
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
            <div class="menu-item"> <a href="<%= request.getContextPath() %>/<%= nomeArquivo %>.jsp"><%= nomeArquivo %></a> </div> <br>
            <%
                        }
                    }
                }
            %>
        </div>

        <script>

            const menu = document.getElementById("menu");
            menu.style.display = 'none';

            function toggleMenu() {

                menu.style.display = 'flex';
                menu.classList.add("inactive");

                if (menu.classList.contains('active')) {
                    menu.classList.remove("active");
                    menu.classList.add("inactive");

                } else {
                    menu.classList.remove("inactive");
                    menu.classList.add("active");
                }
            }
        </script>
    </body>
</html>