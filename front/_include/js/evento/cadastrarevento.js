$(document).ready(function () {
  $("#cadastro").on("submit", function (event) {
    event.preventDefault();

    let nome = $("input[name=nome]").val();
    let datainicial = new Date($("input[name=datainicial]").val());
    let datafinal = new Date($("input[name=datafinal]").val());
    let id = $("input[name=edit_id]").val();
    
    var evento = {
      nome: nome,
      data_inicial: datainicial,
      data_final: datafinal
    };

    if(!id){
      $.ajax({
        url: "http://localhost:8080/myapp/eventos/",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(evento)
      }).done(function (data) {
        location.reload();
      }).fail(function (jqXHR, textStatus) {
        console.log(jqXHR);
        console.log(textStatus);
      });      
    }else{
      $.ajax({
        url: "http://localhost:8080/myapp/eventos/"+id,
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify(evento)
      }).done(function (data) {
        location.reload();
      }).fail(function (jqXHR, textStatus) {
        console.log(jqXHR);
        console.log(textStatus);
      });
    }
  });
});