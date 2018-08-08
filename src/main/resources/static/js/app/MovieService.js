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
    	
//    	return 
//    	$http({
//    	    method: 'DELETE',
//    	    url: CONSTANTS.deleteMovie,
//    	    data: movieDto,
//    	    headers: {
//    	        'Content-type': 'application/json;charset=utf-8'
//    	    }
//    	});
    }
    return service;
}]);