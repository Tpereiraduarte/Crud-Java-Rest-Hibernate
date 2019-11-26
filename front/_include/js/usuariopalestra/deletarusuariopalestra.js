function removerPalestra(id){
    $.ajax({
        url: "http://localhost:8080/myapp/palestras/"+id,
        method: "DELETE",
        contentType: "application/json",
    }).done(function (data) {
        location.reload();
    }).fail(function (jqXHR, textStatus) {
        console.log(jqXHR);
        console.log(textStatus);
    });
}