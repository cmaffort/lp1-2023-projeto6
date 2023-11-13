const enviarDados = (dados) => {

    const xhr = new XMLHttpRequest();
    xhr.open('get', '${pageContext.request.contextPath}/ServletWeb?acao=AssinarContrato', true);
    xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log('Dados enviados com sucesso.');
        }
    };
    xhr.send(JSON.stringify(dados));
    console.log('Dados:', dados);
};

const criarContrato = () => {
    const dataAtual = new Date().toISOString().split('T')[0];
    Swal.fire({
        cancelButtonText: 'Cancelar',
        confirmButtonText: 'Confirmar',
        html:
            '<input style = "width:40vh;height:50%;" type="text" id="descricao" class="swal2-input" placeholder="Descrição">' +
            '<input type="number" id="numeroDeLojas" class="swal2-input" placeholder="Número de Lojas">' +
            `<br>data de criaçao:<input type="date" id="dataDeCriacao" class="swal2-input" value="${dataAtual}" readonly>` +
            '<select id="periodicidade" class="swal2-input">' +
            '  <option value= 1>Um mes</option>' +
            '  <option value= 2>Dois meses</option>' +
            '  <option value= 3>Tres meses</option>' +
            '  <option value= 6 >Seis meses</option>' +
            '  <option value= 12>Anual</option>' +
            '</select>',
        preConfirm: () => {
            const descricao = document.getElementById('descricao').value;
            const documento = null;
            const numeroDeLojas = document.getElementById('numeroDeLojas').value;
            const dataDeCriacao = document.getElementById('dataDeCriacao').value;
            const periodicidade = document.getElementById('periodicidade').value;
            const preco = numeroDeLojas * periodicidade * 100;
            const taxaDeMulta = (preco / 100) * 10;

            const dados = {
                descricao,
                preco,
                documento,
                taxaDeMulta,
                numeroDeLojas,
                dataDeCriacao,
                periodicidade
            };

            enviarDados(dados);

            return dados;
        },
        showCancelButton: true,
        title: 'Criar Contrato'
    }).then((result) => {
        if (result.isConfirmed) {
            console.log('Contrato criado com sucesso.');
        }
    });
};
document.getElementById("chamar-funcao").addEventListener("click", criarContrato);