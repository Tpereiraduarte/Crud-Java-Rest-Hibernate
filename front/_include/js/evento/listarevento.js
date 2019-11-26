$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/myapp/eventos/",
        method: "GET",
        contentType: "application/json",
        dataType: 'json',
        success: function (result) {
            $('#colunas').append(
                "<tr>"
                    +"<th>Nome</th>"
                    +"<th>Data Incial</th>"
                    +"<th>Data Final</th>"
                    +"<th>Ações</th>"
                +"</tr>"
            );
            result.forEach(function(currentValue){
                $('#valores').append(
                    "<tr><td>"+currentValue.nome+"</td>"
                    +"<td>"+currentValue.data_inicial.substring(0, 10)+"</td>"
                    +"<td>"+currentValue.data_final.substring(0, 10)+"</td>"
                    +"<td>"
                        +"<a href='javascript:removerEvento("+ currentValue.id+")'>Remover </a>"
                        +"<a href='javascript:editarEvento("+ currentValue.id+")'>Editar </a>"
                    +"</td></tr>"
                );
            });
        }
    });
});