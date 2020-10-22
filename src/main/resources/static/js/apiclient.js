var Url = "http://" + $(location).attr('hostname') + ":" + $(location).attr('port') + "/clima/";
api = (function () {
    return {
        getClimaByCiudad: function (ciudad, callback) {
            $.getJSON("clima/" + ciudad , function (data) {
                callback(data);
            });
        }
    }
})();