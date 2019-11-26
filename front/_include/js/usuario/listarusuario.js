$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/myapp/usuarios/",
        method: "GET",
        contentType: "application/json",
        dataType: 'json',
        success: function (result) {
            $('#colunas').append(
                "<tr>"
                    +"<th>Nome</th>"
                    +"<th>Sobrenome</th>"
                    +"<th>Email</th>"
                    +"<th>Ações</th>"
                +"</tr>"
            );
            result.forEach(function(currentValue){
                $('#valores').append(
                    "<tr><td>"+currentValue.nome+"</td>"
                    +"<td>"+currentValue.sobrenome+"</td>"
                    +"<td>"+currentValue.email+"</td>"
                    +"<td>"
                        +"<a href='javascript:removerEvento("+ currentValue.id+")'>Remover </a>"
                        +"<a href='javascript:editarEvento("+ currentValue.id+")'>Editar </a>"
                    +"</td></tr>"
                );
            });
        }
    });
});