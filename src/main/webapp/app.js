var app=angular.module("t",[]);

app.controller("test",['$http', '$scope',function(http, scope){
    scope.d={};
    http.get("/k").success(function(data){
        scope.d=data;
    })
}]);