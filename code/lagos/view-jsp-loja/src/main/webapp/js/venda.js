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