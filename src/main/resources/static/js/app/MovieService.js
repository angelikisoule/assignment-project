'use strict'
angular.module('demo.services', []).factory('MovieService', ["$http", "CONSTANTS", function($http, CONSTANTS) {
    var service = {};
    service.list = function() {
        var url = CONSTANTS.movieList ;
        return $http.get(url);
    }
    
    service.saveMovie = function(movieDto) {
        return $http.put(CONSTANTS.saveMovie, movieDto);
    }
    return service;
}]);