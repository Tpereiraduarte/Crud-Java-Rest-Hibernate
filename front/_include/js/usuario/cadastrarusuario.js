$(document).ready(function () {  
  $("#cadastro").on("submit", function (event) {
    event.preventDefault();
    let nome = $("input[name=nome]").val();
    let sobrenome = $("input[name=sobrenome]").val();
    let email = $("input[name=email]").val();
    let senha = $("input[name=senha]").val();
    let id = $("input[name=edit_id]").val();
    
    var usuario = {
      nome: nome,
      sobrenome: sobrenome,
      email: email,
      senha: senha
    };
debugger
    if(!id){
      $.ajax({
        url: "http://localhost:8080/myapp/usuarios/",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(usuario)
      }).done(function (data) {
        location.reload();
      }).fail(function (jqXHR, textStatus) {
          console.log(jqXHR);
          console.log(textStatus);
      });      
    }else{
      $.ajax({
        url: "http://localhost:8080/myapp/usuarios/"+id,
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify(usuario)
      }).done(function (data) {
        location.reload();
      }).fail(function (jqXHR, textStatus) {
          console.log(jqXHR);
          console.log(textStatus);
      });
    }
  });
});