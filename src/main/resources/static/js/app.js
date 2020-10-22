var app = (function(){
    var apiu = "js/apiclient.js"

    var _paisSeleccionado;

    function ingresarInfo(){
        _paisSeleccionado = $("#ciudad").val();
        $.getScript(apiu, function() {
            api.getClimaByCiudad(_paisSeleccionado, convertElementsToObject);
        })

    }

    function convertElementsToObject(functions) {
        //$("table").find("tr:gt(0)").remove();
        console.log(functions)
        name = functions.name;
        temperatura = functions.temperatura;
        sensacionTermica = functions.sensacionTermica;
        minTemperatura = functions.minTemperatura;
        maxTemperatura = functions.maxTemperatura;
        presion = functions.presion;
        humedad = functions.humedad;

            var row = '<tr><td>' + name + '</td><td>' + temperatura + '</td><td>' + sensacionTermica + '</td><td>' + minTemperatura + '</td><td>' + maxTemperatura + '</td><td>' + presion + '</td><td>' + humedad +'</td><td>'+'</tr>';
            $("#table").append(row);
        }

    return {
        ingresarInfo: ingresarInfo
    }
})();