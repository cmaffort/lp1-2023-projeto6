document.addEventListener("DOMContentLoaded", () => {
    $.ajax({
        url: 'servletweb?acao=DefinirHeader',
        type: 'GET',
        contentType: 'application/json',
        success: function (data) {
            if(data !== "Erro. Nenhum usuario definido"){
                if (data !== "GERENTE_DE_CONTRATOS") {
                    let gerenteHeaders = document.querySelectorAll(".gerente");

                    for (let i = 0; i < gerenteHeaders.length; i++)
                        gerenteHeaders[i].style.display = 'none';
                } else {
                    let contratanteHeaders = document.querySelectorAll(".contratante");

                    for (let i = 0; i < contratanteHeaders.length; i++)
                        contratanteHeaders[i].style.display = 'none';

                }
            }
        }
    })
});

function desconectar() {
    $.ajax({
        url: 'servletweb?acao=Logout',
        type: 'GET',
        contentType: 'text/html'
    })
}
