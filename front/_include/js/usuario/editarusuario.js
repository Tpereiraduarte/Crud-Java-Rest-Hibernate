function editarPalestra(id){
    $.ajax({
        url: "http://localhost:8080/myapp/usuarios/"+id,
        method: "GET",
        contentType: "application/json",
    }).done(function (currentValue) {
        var modal = document.getElementById("myModal");
        modal.style.display = "block";
        $("input[name=nome]").val(currentValue.nome);
        $("textarea[name=sobrenome]").val(currentValue.sobrenome);
        $("input[name=senha]").val(currentValue.senha);
        $("#id-edit").append("<input type='hidden' name='edit_id' value="+currentValue.id+" / >");
    }).fail(function (jqXHR, textStatus) {
        console.log(jqXHR);
        console.log(textStatus);
    });
}

