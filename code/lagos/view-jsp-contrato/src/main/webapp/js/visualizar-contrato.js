document.addEventListener('DOMContentLoaded', () =>{

    let acao = "ListarContrato";

    $.ajax({
        url: '/view_jsp_contrato_war_exploded/ServletWeb',
        type: 'GET',
        data: {acao: acao},
        contentType: 'application/json',
        success: function (data) {

            data = [
                {
                    preco: 1000.00,
                    taxaDeMulta: 0.05,
                    descricao: "Contrato 1 - Fornecimento de Serviços",
                    numeroDeLojas: 3,
                    id: 1
                },
                {
                    preco: 1500.00,
                    taxaDeMulta: 0.08,
                    descricao: "Contrato 2 - Serviços de Consultoria",
                    numeroDeLojas: 5,
                    id: 2
                },
                {
                    preco: 800.00,
                    taxaDeMulta: 0.03,
                    descricao: "Contrato 3 - Manutenção de Equipamentos",
                    numeroDeLojas: 2,
                    id: 3
                },
                {
                    preco: 2000.00,
                    taxaDeMulta: 0.1,
                    descricao: "Contrato 4 - Desenvolvimento de Software",
                    numeroDeLojas: 7,
                    id: 4
                }
            ];

            let divContainer = document.querySelector("#container");

            for(let i = 0; i < data.length; i++){

                let divContrato = document.createElement('div');
                divContrato.classList.add('contratos');

                divContrato.innerHTML =
                    "<h2>Descrição:</h2>" +
                    "<p class='descricao'>"+ data[i].descricao +"</p >" +
                    "<h2>Preço:</h2>" +
                    "<p>"+ data[i].preco +"</p>" +
                    "<h2>Taxa De Multa:</h2>" +
                    "<p>"+ data[i].taxaDeMulta +"</p>" +
                    "<h2>Número máximo de lojas permitido:</h2>" +
                    "<p>"+ data[i].numeroDeLojas +"</p>" +
                    "<button class='assinar' data-id="+ data[i].id + " onclick='assinarContrato(" + data[i].id + ")'>Assinar Contrato</button>";


                divContainer.appendChild(divContrato);
            }
        }});

});

function assinarContrato(idContrato) {
    let acao = "ListarIdContrato";

    $.ajax({
        url: '/view_jsp_contrato_war_exploded/ServletWeb',
        type: 'GET',
        data: {acao: acao,
        idContrato: idContrato},
        contentType: 'application/json',
        success: function (result){
            window.location.href = "assinar-contrato.jsp";
        }
    });
}