function deletar(i) {

    console.log("teste");
    let form = document.createElement("form");
    let idEl = document.createElement("input");

    form.method = "post";
    form.action = "/servletweb?acao=DesativarContrato"

    idEl.value = i;
    idEl.name = "id";
    idEl.hidden = true;

    if(confirm("O Contrato será apagado pra sempre.")) {

        form.appendChild(idEl);
        document.body.appendChild(form);

        form.submit();

    }

}

function criarContrato() {

    location.href= "novo-contrato.jsp";

}