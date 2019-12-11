$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/myapp/palestras/",
        method: "GET",
        contentType: "application/json",
        dataType: 'json',
        success: function (result) {
            result.forEach(function (currentValue) {
                $('#accordionArea').append(
                    '<div class="titulo-palestra">'+currentValue.tema+'</div>'+
                            '<div class="accordion-inner">'
                                + currentValue.descricao +'</br>'
                                + currentValue.palestrante+'</br>'+
                                'Data:' + currentValue.data.substring(0, 10)+
                            '</div>'+
                    '</div>');
            });
        }
    });
});