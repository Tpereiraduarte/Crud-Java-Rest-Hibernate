function editarEvento(id){
    $.ajax({
        url: "http://localhost:8080/myapp/eventos/"+id,
        method: "GET",
        contentType: "application/json",
    }).done(function (data) {
        var modal = document.getElementById("myModal");
        modal.style.display = "block";
        $("input[name=nome]").val(data.nome);
        var datainicial = (data.data_inicial);
        var datafinal = (data.data_final);
        $("input[name=datainicial]").val(datainicial.substring(0, 10));
        $("input[name=datafinal]").val(datafinal.substring(0, 10));
        $("#id-edit").append("<input type='hidden' name='edit_id' value="+data.id+" / >");
    }).fail(function (jqXHR, textStatus) {
        console.log(jqXHR);
        console.log(textStatus);
    });
}

