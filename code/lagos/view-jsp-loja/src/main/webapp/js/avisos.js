document.getElementById("criar-aviso").addEventListener("click", function () {
    Swal.fire({
        title: 'Criar Aviso',
        html:
            '<input type="text" id="texto-aviso" class="swal2-input" placeholder="Texto do aviso">' +
            '<p>' +
            //
            '<input type="radio" class="custom-select" id="destinatario-cliente" value="cliente">' +
            '<label for="destinatario-cliente"></label>' +
            '<label for="destinatario-cliente">Cliente</label>' +
            //
            '<input type="radio" class="custom-select" id="destinatario-estoquista" value="estoquista">' +
            '<label for="destinatario-estoquista"></label>' +
            '<label for="destinatario-estoquista">Estoquista</label>' +
            //
            '<input type="radio" class="custom-select" id="destinatario-caixa" value="caixa">' +
            '<label for="destinatario-caixa"></label>' +
            '<label for="destinatario-caixa">Caixa</label>',

        showCancelButton: true,
        confirmButtonText: 'Criar',
        cancelButtonText: 'Cancelar',
        inputValidator: (value) => {
            if (!value) {
                return 'Você precisa fornecer um texto para o aviso!';
            }
        }
    }).then((result) => {
        if (result.isConfirmed) {
            var destinatarios = [];

            var destinatarioCliente = document.getElementById('destinatario-cliente').checked;
            var destinatarioEstoquista = document.getElementById('destinatario-estoquista').checked;
            var destinatarioCaixa = document.getElementById('destinatario-caixa').checked;


            if (destinatarioCliente) {
                destinatarios.push('Cliente');
            }
            if (destinatarioEstoquista) {
                destinatarios.push('Estoquista');
            }
            if (destinatarioCaixa) {
                destinatarios.push('Caixa');
            }

            var textoAviso = document.getElementById('texto-aviso').value;
            var destinatarioCliente = document.getElementById('destinatario-cliente').checked;
            var destinatarioEstoquista = document.getElementById('destinatario-estoquista').checked;
            var destinatarioCaixa = document.getElementById('destinatario-caixa').checked;

            var aviso = document.createElement("div");
            aviso.className = "aviso";
            aviso.textContent = 'Texto do aviso: ' + textoAviso;

            var br = document.createElement("br");

            var dest = document.createElement("div");
            dest.className = "aviso";
            dest.textContent += ' Destinatários: '
            if (destinatarioCliente) {
                dest.textContent += 'Cliente ';
            }
            if (destinatarioEstoquista) {
                dest.textContent += 'Estoquista ';
            }
            if (destinatarioCaixa) {
                dest.textContent += 'Caixa ';
            }


            var botaoRemover = document.createElement('image');
            botaoRemover.className = "remover-aviso";
            botaoRemover.innerHTML = ' <img id="remover-aviso" src="images/deletar.svg" alt="criar aviso" class="hidden">';

            botaoRemover.addEventListener("click", function () {
                Swal.fire({
                    title: 'Tem certeza que deseja excluir o aviso?',
                    text: "Não é possivel reverter isso!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Sim, excluir aviso!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        aviso.remove();
                        dest.remove();
                        Swal.fire(
                            'Excluido!',
                            'Seu arquivo foi excluido.',
                            'Exito'
                        )

                    }
                })
            });

            aviso.appendChild(botaoRemover);


            document.getElementById("avisos-container").appendChild(aviso);
            document.getElementById("avisos-container").appendChild(dest);
            document.getElementById("avisos-container").appendChild(br);
        }
    });
});
