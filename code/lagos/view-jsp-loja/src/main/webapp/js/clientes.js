let inputPesquisaCliente = document.querySelector("#input_cliente");
let cadastroClienteEL = document.querySelector("#botao_cadastro");

document.addEventListener('DOMContentLoaded', () => {
    $.ajax({
        type: 'POST',
        url: '/loja/servletweb?acao=ListarClientes',
        success: function (result) {
            let tabelaCliente = document.querySelector("#tabela_clientes");
            tabelaCliente.style.display = 'block';

            let body = ("#tabela_clientes").find("tbody");
            for (let i = 0; i < result.length; i++) {
                let cliente = result[i];
                body.append("<div><tr><td>" + cliente.nome + "</td><td>" + cliente.telefone + "</td><td>" + cliente.email + "</td></tr></div>");
            }
        }
    })
})


let tabela = document.querySelector('table');
let linhasNl = tabela.querySelectorAll('tbody tr');
let linhas = Array.from(linhasNl);
inputPesquisaCliente.addEventListener('input', () => {

    linhas.forEach(function (linha) {
        let valorDigitado = inputPesquisaCliente.value.toLowerCase();

        let nome = linha.querySelector('td:first-child').textContent.toLowerCase();

        if (nome.startsWith(valorDigitado))
            linha.style.display = '';
        else
            linha.style.display = 'none';
    })
});

let editarEl = document.querySelector("#editar_cliente");
editarEl.style.display = 'none';

cadastroClienteEL.addEventListener('click', () => {
    editarEl.style.display = '';
});

let fecharEl = document.querySelector("#fechar");
fecharEl.addEventListener('click', () => {
    editarEl.style.display = 'none';
});

let concluirCadastroEl = document.querySelector("#concluir");

concluirCadastroEl.addEventListener('click', () => {
    let inputCadastroEl = document.querySelectorAll('.input_cadastro');

    let dadosCadastro = {
        nome: inputCadastroEl[0].value,
        sobrenome: inputCadastroEl[1].value,
        telefone: inputCadastroEl[2].value,
        email: inputCadastroEl[3].value
    };

    let dadosCadastroJson = JSON.stringify(dadosCadastro);

    $.ajax({
        data: dadosCadastroJson,
        method: 'POST',
        url: '/loja/servletweb?acao=CadastrarCliente',
        contentType: 'application/json',
    })
});