function mostrarSenha() {
    let senhaEl = document.querySelector("#senha");

    senhaEl.type = (senhaEl.type === "password") ? "text" : "password";
}

let buttonCadastrarEl = document.querySelector("#cadastrar")

buttonCadastrarEl.addEventListener('click', () => {
    let cadastroEl = document.querySelector(".cadastro");
    let loginEl = document.querySelector(".login");

    loginEl.style.display = "none";
    cadastroEl.style.display = "flex";
    
    let voltarEl = document.querySelector("#voltar");
    
    voltarEl.addEventListener('click', () => {
       cadastroEl.style.display = "block";
       loginEl.style.display = "none";
    });
});

let cadastrarEl = document.querySelector("#enviarCadastro");

function valida() {
    let inputs = document.querySelectorAll(".input-cadastro");
    let valid = true;

    inputs.forEach(function(input) {
        if (input.value === "") {
            valid = false;
        }
    });
    return valid;
}

cadastrarEl.addEventListener('click', () => {
    let valid = valida();

    if(valid){
        let data = $('.input-cadastro[name="dataNascimento"]').val();
        let arrayDataSplit = data.split("-");
        let dataNasicmento = arrayDataSplit[2] + "-" + arrayDataSplit[1] + "-" + arrayDataSplit[0];
        console.log(dataNasicmento);

        $.ajax({
            url: 'servletweb?acao=CriarUsuario',
            type: 'GET',
            contentType: "text/html",
            data: {
                nome: $('.input-cadastro[name="nome"]').val(),
                sobrenome: $('.input-cadastro[name="sobrenome"]').val(),
                dataNascimento: dataNasicmento,
                email: $('.input-cadastro[name="email"]').val(),
                telefone: $('.input-cadastro[name="telefone"]').val(),
                tipoUser: $('input[name="tipoUsuario"]:checked').val(),
                username: $('.input-cadastro[name="usuario"]').val(),
                senha: $('.input-cadastro[name="senha"]').val()},
            success: function (data) {
                location.reload();
            }
        });
    }else{
        let errorEl = document.querySelector("#error-message");
        errorEl.style.display = 'block';
    }
});

