var Url = "http://"+$(location).attr('hostname')+":"+$(location).attr('port')+"/clima/";
api = (function () {
    return {
        getClimaByCiudad: function (ciudad, callback) {
            var f;
                $.get(Url+ciudad,function(data){
                    f=data;
                });
                return callback(f)
        }
    }
})();