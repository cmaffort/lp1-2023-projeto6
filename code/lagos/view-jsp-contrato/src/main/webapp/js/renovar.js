function mostrarRenovar() {
    var formularioR = document.getElementById("formularioRenovacao");
    formularioR.style.display = (formularioR.style.display === "block") ? "none" : "block";

}
function mostrarUpgrade() {
    var formularioU = document.getElementById("formularioUpgrade");
    formularioU.style.display = (formularioU.style.display === "block") ? "none" : "block";

}

function calcularValor() {
    var lojas = document.getElementById("lojas").value;
    var valor = document.getElementById("valor");

    if (lojas && !isNaN(lojas)) {
        valor.value = lojas * 10;
    } else {
        valor.value = "";
    }
}