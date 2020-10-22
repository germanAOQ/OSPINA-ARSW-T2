api = (function () {
    return {
        getClimaByCiudad: function (ciudad, callback) {
            var f;
                $.get("/clima/"+ciudad,function(data){
                    f=data;
                });
                return callback(f)
        }
    }
})();