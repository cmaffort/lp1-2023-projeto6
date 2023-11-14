const form = document.getElementById('cadastro-contrato');
form.addEventListener('keypress', function(e) {
    if (e.key === "Enter") {
        if (document.activeElement.tagName.toLowerCase () !== "textarea") {
            e.preventDefault();
        }
    }
});

const inputs = document.querySelectorAll(
    'input'
)

inputs.forEach(input => {
    input.addEventListener('focusout', function(e) {

        if(e.target.classList.contains("money")) {
            if(e.target.value === "") {
                e.target.value = 0;
            }
            input.value = parseFloat(input.value).toFixed(2);
        }
        else {
            if(e.target.value === "") {
                e.target.value = 1;
            }
            input.value = parseInt(input.value);
        }

        console.log("focus lost!");

    })
})