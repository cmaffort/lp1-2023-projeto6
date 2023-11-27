document.addEventListener("DOMContentLoaded", () => {

    let acao = "DefinirHeader";

    $.ajax({
        url: `${contextPath}/ServletWeb`,
        type: 'GET',
        data: {acao: acao},
        contentType: 'application/json',
        success: function (data) {
            if(data !== "Erro. Nenhum usuario definido"){
                if(data === "CONTRATANTE"){
                    let gerenteHeaders = document.querySelectorAll(".gerente");

                    for(let i = 0; i < gerenteHeaders.length; i++)
                        gerenteHeaders[i].style.display = 'none';

                }else{
                    let contratanteHeaders = document.querySelectorAll(".contratante");

                    for(let i = 0; i < contratanteHeaders.length; i++)
                        contratanteHeaders[i].style.display = 'none';
                }
            }
            window.location.href = '${contextPath}/ServletWeb?acao=Error';
        }
    })
});
