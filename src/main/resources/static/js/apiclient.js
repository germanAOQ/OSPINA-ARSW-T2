api = (function () {
    return {
        getClimaByCiudad: function (ciudad, callback) {
            var f;
                $.get(Url+name,function(data){
                    f=data;
                });
                return callback(f)
        }
    }
})();