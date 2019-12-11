$(document).ready(function () {
  $.ajax({
    url: "http://localhost:8080/myapp/eventos/",
    method: "GET",
    contentType: "application/json",
    dataType: 'json',
    success: function (result) {
      result.forEach(function (currentValue) {
        $('#evento').append("<option value=" + currentValue.id + ">" + currentValue.nome + "</option>");
      });
    }
  });

  $("#cadastro").on("submit", function (event) {
    event.preventDefault();
    let tema = $("input[name=tema]").val();
    let descricao = $("textarea[name=descricao]").val();
    let data = new Date($("input[name=data]").val());
    let palestrante = $("input[name=palestrante]").val();
    let evento = $("select[name=evento_id]").val();
    let computador = $('input[name="computador"]');
    let projetor = $('input[name="projetor"]');

    let valores;
    if (computador.prop("checked")) {
      valores = 1;
    }

    if (projetor.prop("checked")) {
      valores = 2;
    }

    if (projetor.prop("checked") && computador.prop("checked")) {
      valores = 3;
    } else {
      valores = 0;
    }

    let id = $("input[name=edit_id]").val();
    var palestra = {
      tema: tema,
      descricao: descricao,
      data: data,
      palestrante: palestrante,
      eventoPalestras: { id: evento },
      salaPalestras: { id: "2"}
    }

    if (!id) {
      $.ajax({
        url: "http://localhost:8080/myapp/salas/",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(valores)
      }).done(function (data) {
        var palestra = {
          tema: tema,
          descricao: descricao,
          data: data,
          palestrante: palestrante,
          eventoPalestras: { id: evento },
          salaPalestras: { id: data.toString() }
        };
      }).fail(function (jqXHR, textStatus) {
        console.log(jqXHR);
        console.log(textStatus);
      });

      $.ajax({
        url: "http://localhost:8080/myapp/palestras/",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(palestra)
      }).done(function (data) {
        location.reload();
      }).fail(function (jqXHR, textStatus) {
        console.log(jqXHR);
        console.log(textStatus);
      });
    } else {
      $.ajax({
        url: "http://localhost:8080/myapp/palestras/" + id,
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify(palestra)
      }).done(function (data) {
        location.reload();
      }).fail(function (jqXHR, textStatus) {
        console.log(jqXHR);
        console.log(textStatus);
      });
    }
  });
});