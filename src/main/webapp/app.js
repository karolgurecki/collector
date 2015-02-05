var app=angular.module("t",[]);

app.controller("test",['$http', '$scope',function(http, scope){
    scope.d=null;
    scope.h=function(){
        http.get("k").success(function(data){
            scope.d=data;
        });
    };
}]);