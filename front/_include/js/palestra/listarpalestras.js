$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/myapp/palestras/",
        method: "GET",
        contentType: "application/json",
        dataType: 'json',
        success: function (result) {
            $('#colunas').empty();
            $('#valores').empty();
            $('#lista-palestras').empty();
            result.forEach(function (currentValue) {
                $('#lista-palestras').append(
                    "<h4>Tema: " + currentValue.tema + "</h4>"
                    + "<p>Descrição: " + currentValue.descricao + "</p>"
                    + "<p>Palestrante: " + currentValue.palestrante + "</p>"
                    + "<p>Data: " + currentValue.data.substring(0, 10) + "</p>"
                    + "<p>Evento: " + currentValue.eventoPalestras.nome + "</p>"
                    + "<a href='javascript:removerPalestra("+ currentValue.id+")'>Remover </a>"
                    + "<a href='javascript:editarPalestra("+ currentValue.id+")'>Editar </a><hr/>"
                );
            });
        }
    });
});