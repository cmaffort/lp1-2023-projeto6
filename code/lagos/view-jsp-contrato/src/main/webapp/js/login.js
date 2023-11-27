function mostrarSenha() {
    let senhaEl = document.querySelector("#senha");

    senhaEl.type = (senhaEl.type === "password") ? "text" : "password";
}

let buttonCadastrarEl = document.querySelector("#cadastrar")

buttonCadastrarEl.addEventListener('click', () => {
    let cadastroEl = document.querySelector(".cadastro");
    let loginEl = document.querySelector(".login");

    if(cadastroEl.style.display === "flex"){
        cadastroEl.style.display = "none";
        loginEl.style.display = "block";
    }else{
        loginEl.style.display = "none";
        cadastroEl.style.display = "flex";
    }
})

let cadastrarEl = document.querySelector("#enviarCadastro");

cadastrarEl.addEventListener('click', () => {
    $.ajax({
        url: '/ServletWeb',
        type: 'GET',
        data: {
            acao: "CriarUsuario",
            nome: $('.input-cadastro[name="nome"]').val(),
            sobrenome: $('.input-cadastro[name="sobrenome"]').val(),
            dataNascimento: $('.input-cadastro[name="dataNascimento"]').val(),
            email: $('.input-cadastro[name="email"]').val(),
            telefone: $('.input-cadastro[name="telefone"]').val(),
            tipoUser: $('input[name="tipoUsuario"]:checked').val(),
            username: $('.input-cadastro[name="usuario"]').val(),
            senha: $('.input-cadastro[name="senha"]').val()},
        success: function (data) {
            console.log("Dados enviados com sucesso!");
        }
    });
})

