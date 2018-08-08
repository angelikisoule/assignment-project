'use strict'
var module = angular.module('demo.controllers', []);
module.controller("MovieController", ["$scope", "MovieService",
    function($scope, MovieService) {
        $scope.movieDto = {
            id: null,
            name: null
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
//            $scope.movieDto.skillDtos = $scope.skills.map(skill => {
//                return {
//                    skillId: null,
//                    skillName: skill
//                };
//            });
            MovieService.saveMovie($scope.movieDto).then(function() {
                console.log("works");
                MovieService.list().then(function(value) {
                    $scope.allMovies = value.data;
                }, function(reason) {
                    console.log("error occured");
                }, function(value) {
                    console.log("no callback");
                });
//                $scope.skills = [];
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
        
    }
]);