document.addEventListener('DOMContentLoaded', () =>{
    $.ajax({
        url: '/servletweb?acao=ListarContratos',
        type: 'GET',
        contentType: 'application/json',
        success: function (data) {

            let divContainer = document.querySelector("#container");

            if(data === "Erro. Nenhum contrato existente."){
                let erro = document.createElement('p');
                erro.style.color = "red";
                erro.style.fontSize = "30px";
                erro.style.textAlign = "center";
                erro.style.fontFamily = "'Chivo', sans-serif";

                erro.innerHTML = "Nenhum contrato foi encontrado";
                divContainer.appendChild(erro);
            }else if(data === "Erro. Ocorreu um erro ao acessar o Banco de Dados."){
                let erro = document.createElement('p');
                erro.style.color = "red";
                erro.style.fontSize = "30px";
                erro.style.textAlign = "center";
                erro.style.fontFamily = "'Chivo', sans-serif";

                erro.innerHTML = "Ocorreu um erro ao acessar o Banco de Dados.";
                divContainer.appendChild(erro);
            }else{
                console.log(data);
                for (let i = 0; i < data.length; i++) {

                    let divContrato = document.createElement('div');
                    divContrato.classList.add('contratos');

                    divContrato.innerHTML =
                        "<h2>Descrição:</h2>" +
                        "<p class='descricao'>" + data[i].descricao + "</p >" +
                        "<h2>Preço:</h2>" +
                        "<p>" + data[i].preco + "</p>" +
                        "<h2>Taxa De Multa:</h2>" +
                        "<p>" + data[i].taxaDeMulta + "</p>" +
                        "<h2>Número máximo de lojas permitido:</h2>" +
                        "<p>" + data[i].numeroDeLojas + "</p>" +
                        "<button class='assinar' data-id=" + data[i].id + " onclick='assinarContrato(" + data[i].id + ")'>Assinar Contrato</button>";


                    divContainer.appendChild(divContrato);
                }
            }
        }});

});

function assinarContrato(idContrato) {
    $.ajax({
        url: 'servletweb?acao=IdContrato',
        type: 'GET',
        data: {idContrato: idContrato},
        contentType: 'application/json',
        success: function (result){
            window.location.href = "assinar-contrato.jsp";
        }
    });
}