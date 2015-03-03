var app = angular.module("t", []);

app.controller("test", ['$http', '$scope', function (http, scope) {
    scope.d = null;
    scope.h = function (user) {
        http.post("user/login", user);
    };
}]);