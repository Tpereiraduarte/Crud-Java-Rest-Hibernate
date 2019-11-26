function editarPalestra(id){
    $.ajax({
        url: "http://localhost:8080/myapp/palestras/"+id,
        method: "GET",
        contentType: "application/json",
    }).done(function (currentValue) {
        var modal = document.getElementById("myModal");
        modal.style.display = "block";
        $("input[name=tema]").val(currentValue.tema);
        $("textarea[name=descricao]").val(currentValue.descricao);
        var data = (currentValue.data);
        $("input[name=data]").val(data.substring(0, 10));
        $("input[name=palestrante]").val(currentValue.palestrante);
        $("select[name=evento_id]" ).val(currentValue.eventoPalestras.id).attr('selected','selected');
        $("#id-edit").append("<input type='hidden' name='edit_id' value="+currentValue.id+" / >");
    }).fail(function (jqXHR, textStatus) {
        console.log(jqXHR);
        console.log(textStatus);
    });
}

