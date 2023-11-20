function mostrarSenha() {
    let senhaEl = document.querySelector("#senha");

    senhaEl.type = (senhaEl.type === "password") ? "text" : "password";
}

