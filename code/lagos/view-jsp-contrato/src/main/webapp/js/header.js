document.addEventListener("DOMContentLoaded", () => {

    let acao = "DefinirHeader";

    $.ajax({
        url: "/view_jsp_contrato_war_exploded/ServletWeb",
        type: 'GET',
        data: {acao: acao},
        contentType: 'application/json',
        success: function (result) {
            if(result === "CONTRATANTE"){
                let gerenteHeaders = document.querySelectorAll(".gerente");

                for(let i = 0; i < gerenteHeaders.length; i++)
                    gerenteHeaders[i].style.display = 'none';

            }else{
                let contratanteHeaders = document.querySelectorAll(".contratante");

                for(let i = 0; i < contratanteHeaders.length; i++)
                    contratanteHeaders[i].style.display = 'none';
            }
        }
    })
});
