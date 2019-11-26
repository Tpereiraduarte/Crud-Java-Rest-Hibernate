$(document).ready(function () {
  $.ajax({
    url: "http://localhost:8080/myapp/usuarios/",
    method: "GET",
    contentType: "application/json",
    dataType: 'json',
    success: function (result) {
      result.forEach(function(currentValue){
        $('#usuario').append("<option value="+currentValue.id+">"+currentValue.nome+"</option>");
      });
    }
  });
  
  $.ajax({
    url: "http://localhost:8080/myapp/palestras/",
    method: "GET",
    contentType: "application/json",
    dataType: 'json',
    success: function (result) {
      result.forEach(function(currentValue){
        $('#palestras').append("<div><hr/>Evento:"+currentValue.eventoPalestras.nome+
                              "<br/>Data da Palestra:"+currentValue.data.substring(0, 10)+
                              "<br/><input type='checkbox' value="+currentValue.id+" name='palestra'>"
                              +"<label>"+currentValue.tema+"</label></div>");
      });
    }
  });

  $("#cadastro").on("submit", function (event) {
    event.preventDefault();
    let usuario_id = $("select[name=usuario_id]").val();

    let palestra_id = $('input[name="palestra"]:checked').toArray().map(function(check) { 
      return $(check).val(); 
    });
    let id = $("input[name=edit_id]").val();
    
    function UsuarioPalestra(usuario, palestra) {
      this.usuario = usuario;
      this.palestra = palestra;
    }
    
    let cadastros = new Array();
    palestra_id.forEach(function (currentValue) {
      let usuariopalestra = new UsuarioPalestra( {id:usuario_id}, {id:currentValue});
      cadastros.push(usuariopalestra);
    });

    cadastros.forEach(function (result) {
      if(!id){
        $.ajax({
          url: "http://localhost:8080/myapp/usuariopalestras/",
          method: "POST",
          contentType: "application/json",
          data: JSON.stringify(result)
        }).done(function (data) {
          location.reload();
        }).fail(function (jqXHR, textStatus) {
            console.log(jqXHR);
            console.log(textStatus);
        });      
      }else{
        $.ajax({
          url: "http://localhost:8080/myapp/usuariopalestras/"+id,
          method: "PUT",
          contentType: "application/json",
          data: JSON.stringify(result)
        }).done(function (data) {
          location.reload();
        }).fail(function (jqXHR, textStatus) {
            console.log(jqXHR);
            console.log(textStatus);
        });
      }
    });
  });
});