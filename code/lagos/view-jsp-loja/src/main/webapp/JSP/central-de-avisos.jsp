<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
     <title>Central de Avisos</title>
     <link rel="stylesheet" type="text/css" href="../css/css_tela_aviso.css" />
</head>
<body>
    <%@include file="Header.jsp" %>
    
    <h1>Avisos</h1>
    
    <div id="avisos-container">
        <!-- Avisos serão adicionados aqui -->
    </div>
    
    <img id="criar-aviso" src="../images/adicionar.svg" alt="criar aviso" class="hidden">
    

    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script>  
        document.getElementById("criar-aviso").addEventListener("click", function() {
        Swal.fire({
            title: 'Criar Aviso',
            html:
            '<input type="text" id="texto-aviso" class="swal2-input" placeholder="Texto do aviso">' +
            '<p>'+
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
                aviso.textContent = 'Texto do aviso: '+ textoAviso ;
                console.log('/n \n');


                if (destinatarioCliente) {
                    aviso.textContent += '  Destinatários: Cliente';
                }
                if (destinatarioEstoquista) {
                    aviso.textContent += ' Estoquista';
                }
                if (destinatarioCaixa) {
                    aviso.textContent += ' Caixa';
                }
                
                alert(destinatarios.join(', '));


                var botaoRemover = document.createElement("button");
                botaoRemover.className = "remover-aviso";
                botaoRemover.innerHTML = '<img src="caminho-para-sua-imagem.png" alt="Remover Aviso">';

                botaoRemover.addEventListener("click", function() {
                    aviso.remove();
                });

                aviso.appendChild(botaoRemover);


                document.getElementById("avisos-container").appendChild(aviso);
            }
        });
    });

    </script>

</body>
</html>
