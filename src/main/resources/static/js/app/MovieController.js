'use strict'
var module = angular.module('demo.controllers', []);
module.controller("MovieController", ["$scope", "MovieService",
    function($scope, MovieService) {
        $scope.movieDto = {
            id: null,
            name: null,
            likes: 0
        };
        $scope.skills = [];
        $scope.allMovies = [];
        
        MovieService.list().then(function(value) {
        	$scope.allMovies = value.data;
            console.log(value.data);
        }, function(reason) {
            console.log("error occured");
        }, function(value) {
            console.log("no callback");
        });
        
        $scope.saveMovie = function() {
            MovieService.saveMovie($scope.movieDto).then(function() {
                console.log("works");
                MovieService.list().then(function(value) {
                    $scope.allMovies = value.data;
                }, function(reason) {
                    console.log("error occured");
                }, function(value) {
                    console.log("no callback");
                });
                $scope.movieDto = {
                    id: null,
                    name: null
                };
            }, function(reason) {
                console.log("error occured");
            }, function(value) {
                console.log("no callback");
            });
        }
        
        $scope.deleteMovie = function(movieDto) {
        	MovieService.deleteMovie(movieDto).then(function() {
                console.log("works");
                MovieService.list().then(function(value) {
                    $scope.allMovies = value.data;
                }, function(reason) {
                    console.log("error occured");
                }, function(value) {
                    console.log("no callback");
                });
            }, function(reason) {
                console.log("error occured");
            }, function(value) {
                console.log("no callback");
            });
        }
        
        $scope.likeMovie = function(movieDto) {
        	MovieService.likeMovie(movieDto).then(function() {
                console.log("works");
                MovieService.list().then(function(value) {
                    $scope.allMovies = value.data;
                }, function(reason) {
                    console.log("error occured");
                }, function(value) {
                    console.log("no callback");
                });
            }, function(reason) {
                console.log("error occured");
            }, function(value) {
                console.log("no callback");
            });
        }
        
    }
]);