$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/myapp/usuariopalestras/",
        method: "GET",
        contentType: "application/json",
        dataType: 'json',
        success: function (result) {
            result.forEach(function (currentValue) {
            $('#lista-palestras').append(
            "<h4>Usuario: " + currentValue.usuario.nome +"</h4>"
                +"<p>Email: "+currentValue.usuario.email +"</p>"
                + "<p>Nome do Evento: " + currentValue.palestra.eventoPalestras.nome + "</p>"
            );
                $('#lista-palestras').append("<p>Palestra: " + currentValue.palestra.tema + "</p>");
                
                $('#lista-palestras').append(
                    "<a href='javascript:removerUsuarioPalestra("+ result.id+")'>Remover </a>"
                    + "<a href='javascript:editarUsuarioPalestra("+ result.id+")'>Editar </a><hr/>"
                    );
            });
        }
    });
});