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
    
    service.deleteMovie = function(movieDto) {
        return $http.delete(CONSTANTS.deleteMovie + '/' + movieDto.id);
    }
    
    service.likeMovie = function(movieDto) {
        return $http.post(CONSTANTS.movieList+'/'+movieDto.id);
    }
    return service;
}]);