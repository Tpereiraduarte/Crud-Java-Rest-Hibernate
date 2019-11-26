$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/myapp/usuariopalestras/",
        method: "GET",
        contentType: "application/json",
        dataType: 'json',
        success: function (result) {
            $('#lista-palestras').append(
            "<h4>Usuario: " + result[0].usuario.nome +" "+result[1].usuario.sobrenome+"</h4>"
                + "<p>Nome do Evento: " + result[0].palestra.eventoPalestras.nome + "</p>"
            );
            result.forEach(function (currentValue) {
                $('#lista-palestras').append("<p>Palestra: " + currentValue.palestra.tema + "</p>");
            });

            $('#lista-palestras').append(
                "<a href='javascript:removerUsuarioPalestra("+ result[0].id+")'>Remover </a>"
                + "<a href='javascript:editarUsuarioPalestra("+ result[0].id+")'>Editar </a><hr/>"
            );
        }
    });
});