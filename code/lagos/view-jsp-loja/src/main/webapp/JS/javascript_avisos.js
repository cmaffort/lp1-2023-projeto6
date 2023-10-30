document.getElementById("criar-aviso").addEventListener("click", function() {
    Swal.fire({
        title: 'Digite o texto do aviso:',
        input: 'text',
        showCancelButton: true,
        confirmButtonText: 'Criar',
        cancelButtonText: 'Cancelar'
        
        

    }).then((result) => {
        if (result.value) {
            // O usuário clicou em "Criar" e digitou um texto
            var textoAviso = result.value;
            
            // Crie um elemento de aviso
            var aviso = document.createElement("div");
            aviso.className = "aviso";
            aviso.textContent = textoAviso;

            // Adicione o aviso ao contêiner de avisos
            document.getElementById("avisos-container").appendChild(aviso);
        }
    });
});
/*document.getElementById("criar-aviso").addEventListener("click", function() {
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


            var botaoRemover = document.createElement("button");
            botaoRemover.className = "remover-aviso";


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

 */