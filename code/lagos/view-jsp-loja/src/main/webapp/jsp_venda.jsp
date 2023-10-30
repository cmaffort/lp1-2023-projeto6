<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css_venda.css">
        <title>Gestão de Vendas</title>
    </head>
    <body>
        <%@include file="Header.jsp" %>
        
        <h1 id="titulo">Gestão de Vendas</h1>
        
        <div class="container">
            <div class="grid-item">
                <button class="botoes" id="botao-gerenciar-precos">Gerenciar preços</button>
                <button class="botoes" id="botao-historico-vendas">Histórico de vendas</button>
                <button class="botoes" id="botao-gerenciar-vendedores">Gerenciar vendedores</button>
                <button class="botoes" id="botao-descontos">Descontos</button>
                <button class="botoes" id="botao-taxas">Taxas</button>
            </div>
            <div class="grid-item" id="quadro">
                <p class="invisivel" id="p-gerenciar-precos">
                    a
                    Lorem ipsum dolor sit amet, consectetur 
                    adipiscing elit, sed do eiusmod tempor incididunt 
                    ut labore et dolore magna aliqua. Ut enim 
                    ad minim veniam, quis nostrud exercitation 
                    ullamco laboris nisi ut aliquip ex ea commodo 
                    consequat.
                </p>
                <p class="invisivel" id="p-historico-vendas">
                    b
                    Lorem ipsum dolor sit amet, consectetur 
                    adipiscing elit, sed do eiusmod tempor incididunt 
                    ut labore et dolore magna aliqua. Ut enim 
                    ad minim veniam, quis nostrud exercitation 
                    ullamco laboris nisi ut aliquip ex ea commodo 
                    consequat.
                </p>
                <p class="invisivel" id="p-gerenciar-vendedores">
                    c
                    Lorem ipsum dolor sit amet, consectetur 
                    adipiscing elit, sed do eiusmod tempor incididunt 
                    ut labore et dolore magna aliqua. Ut enim 
                    ad minim veniam, quis nostrud exercitation 
                    ullamco laboris nisi ut aliquip ex ea commodo 
                    consequat.
                </p>
                <p class="invisivel" id="p-descontos">
                    d
                    Lorem ipsum dolor sit amet, consectetur 
                    adipiscing elit, sed do eiusmod tempor incididunt 
                    ut labore et dolore magna aliqua. Ut enim 
                    ad minim veniam, quis nostrud exercitation 
                    ullamco laboris nisi ut aliquip ex ea commodo 
                    consequat.
                </p>
                <p class="invisivel" id="p-taxas">
                    e
                    Lorem ipsum dolor sit amet, consectetur 
                    adipiscing elit, sed do eiusmod tempor incididunt 
                    ut labore et dolore magna aliqua. Ut enim 
                    ad minim veniam, quis nostrud exercitation 
                    ullamco laboris nisi ut aliquip ex ea commodo 
                    consequat.
                </p>
            </div>
        </div>
        <footer></footer>
        <script>
            let gerenciarPrecosEl = document.querySelector("#botao-gerenciar-precos");
            let historicoEl = document.querySelector("#botao-historico-vendas");
            let gerenciarVendedoresEl = document.querySelector("#botao-gerenciar-vendedores");
            let descontosEl = document.querySelector("#botao-descontos");
            let taxasEl = document.querySelector("#botao-taxas");

            let pGerenciarPrecosEl = document.querySelector("#p-gerenciar-precos");
            let pHistoricoEl = document.querySelector("#p-historico-vendas");
            let pGerenciarVendedoresEl = document.querySelector("#p-gerenciar-vendedores");
            let pDescontosEl = document.querySelector("#p-descontos");
            let pTaxasEl = document.querySelector("#p-taxas");

            gerenciarPrecosEl.addEventListener("click", () => {
                pGerenciarPrecosEl.classList.remove("invisivel");
                pHistoricoEl.classList.add("invisivel");
                pGerenciarVendedoresEl.classList.add("invisivel");
                pDescontosEl.classList.add("invisivel");
                pTaxasEl.classList.add("invisivel");
            });

            historicoEl.addEventListener("click", () => {
                pGerenciarPrecosEl.classList.add("invisivel");
                pHistoricoEl.classList.remove("invisivel");
                pGerenciarVendedoresEl.classList.add("invisivel");
                pDescontosEl.classList.add("invisivel");
                pTaxasEl.classList.add("invisivel");
            });

            gerenciarVendedoresEl.addEventListener("click", () => {
                pGerenciarPrecosEl.classList.add("invisivel");
                pHistoricoEl.classList.add("invisivel");
                pGerenciarVendedoresEl.classList.remove("invisivel");
                pDescontosEl.classList.add("invisivel");
                pTaxasEl.classList.add("invisivel");
            });

            descontosEl.addEventListener("click", () => {
                pGerenciarPrecosEl.classList.add("invisivel");
                pHistoricoEl.classList.add("invisivel");
                pGerenciarVendedoresEl.classList.add("invisivel");
                pDescontosEl.classList.remove("invisivel");
                pTaxasEl.classList.add("invisivel");
            });

            taxasEl.addEventListener("click", () => {
                pGerenciarPrecosEl.classList.add("invisivel");
                pHistoricoEl.classList.add("invisivel");
                pGerenciarVendedoresEl.classList.add("invisivel");
                pDescontosEl.classList.add("invisivel");
                pTaxasEl.classList.remove("invisivel");
            });
        </script>
    </body>
</html>
