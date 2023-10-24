document.getElementById("criar-aviso").addEventListener("click", function() {
    Swal.fire({
        title: 'Digite o texto do aviso:',
        input: 'text',
        showCancelButton: true,
        confirmButtonText: 'Criar',
        cancelButtonText: 'Cancelar',
        inputValidator: (value) => {
            if (!value) {
                return 'Você precisa fornecer um texto para o aviso!';
            }
        }
    }).then((result) => {
        if (result.value) {
            var textoAviso = result.value;
            
            var aviso = document.createElement("div");
            aviso.className = "aviso";
            aviso.textContent = textoAviso;

            // Crie um botão de remoção para o aviso
            var botaoRemover = document.createElement("button");
            botaoRemover.className = "remover-aviso";

            // Defina a imagem como conteúdo do botão
            botaoRemover.innerHTML = '<img src="../images/deletar.svg" alt="Remover Aviso">';
            botaoRemover.addEventListener("click", function() {  
                Swal.fire({
                  title: 'Are you sure?',
                  text: "You won't be able to revert this!",
                  icon: 'warning',
                  showCancelButton: true,
                  confirmButtonColor: '#3085d6',
                  cancelButtonColor: '#d33',
                  confirmButtonText: 'Yes, delete it!'
                }).then((result) => {
                  if (result.isConfirmed) {
                    Swal.fire(
                      'Deleted!',
                      'Your file has been deleted.',
                      'success'         
                    )
                    var aviso = event.target.closest(".aviso");
                        aviso.remove();
                  }
                })

                });
                 aviso.appendChild(botaoRemover);
        }
    });
});

