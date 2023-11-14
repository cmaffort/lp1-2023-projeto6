let $botoesExcluirChefe = $('.botoaoExcluirChefe');

$botoesExcluirChefe.on('click', function (e) {
    let chefeId = $(this).siblings('input[name="chefeId"]')[0].value;
    console.log($(this).siblings('input[name="chefeId"]')[0].value);
    $.post(`${contextPath}/servletweb?acao=ExcluirChefe`, {chefeId: chefeId}, data => {
        location.replace(contextPath + data.redirect);
    }, 'json');
});