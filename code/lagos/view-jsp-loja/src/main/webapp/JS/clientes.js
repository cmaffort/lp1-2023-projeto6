let pesquisaClienteEl = document.querySelector("#botao_pesquisa");
let inputPesquisaCliente = document.querySelector("#input_cliente");
let cadastroClienteEL = document.querySelector("#botao_cadastro");



pesquisaClienteEl.addEventListener('click', () => {

    if(inputPesquisaCliente.value === ""){
        if(pesquisaClienteEl.nextElementSibling === null) {
            let textoErro = document.createElement("p");

            textoErro.textContent = "Insira algum dado para pesquisar um cliente";
            textoErro.setAttribute("style", "color: red; font-size: 15px; display:inline; margin-left:1%;")

            pesquisaClienteEl.parentNode.insertBefore(textoErro, pesquisaClienteEl.nextSibling);
        }
    }
    else{
        if(pesquisaClienteEl.nextElementSibling !== null){
            let textoErrorEL = pesquisaClienteEl.nextElementSibling;
            textoErrorEL.remove();
        }
         let dadoParaTratar = {
            dado: inputPesquisaCliente.value
        };

        let objetoParaTratar = JSON.stringify(dadoParaTratar);

        //enviar para o servlet
        fetch('/src/main/java/com/br/cefetmg/lagos/ListarClientes.java', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: objetoParaTratar
        }).then((data) => {
            let tbody = document.querySelector("tbody");

            data.formData(cliente =>{
                let row = tbody.insertRow(-1);
                row.insertCell(0).textContent = `${cliente.nome}`+`${cliente.sobrenome}`;
                row.insertCell(0).textContent = `${cliente.email}`;
                row.insertCell(0).textContent = `${cliente.telefone}`;
                row.insertCell(0).textContent = `<button id="botao_editar"><img src="${pageContext.request.contextPath}/imagens/edit.png"></button>`;
            })
        })


    }
})

cadastroClienteEL.addEventListener('click', () => {
    window.alert('Cadastro');
})






