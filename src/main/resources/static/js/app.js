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
        $("table").find("tr:gt(0)").remove();
        
        var mapFunctions = functions.map(
            function (f) {
                f.name;
                f.temperatura;
                f.sensacionTermica;
                f.minTemperatura;
                f.maxTemperatura;
                f.presion;
                f.humedad;
                  
            });

            name = functions[0].name;
            temperatura = functions[0].temperatura;
            sensacionTermica = functions[0].sensacionTermica;
            minTemperatura = functions[0].minTemperatura;
            maxTemperatura = functions[0].maxTemperatura;
            presion = functions[0].presion;
            humedad = functions[0].humedad;

            var row = '<tr><td>' + name + '</td><td>' + temperatura + '</td><td>' + sensacionTermica + '</td><td>' + minTemperatura + '</td><td>' + maxTemperatura + '</td><td>' + presion + '</td><td>' + humedad +'</td><td>'+'</tr>';
            $("#table").append(row);
        }

    return {
        ingresarInfo: ingresarInfo
    }
})();