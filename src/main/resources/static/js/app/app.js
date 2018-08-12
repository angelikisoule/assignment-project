'use strict'
var demoApp = angular.module('demo', ['ui.bootstrap', 'demo.controllers', 'ngTable',
    'demo.services'
]);
demoApp.constant("CONSTANTS", {
    movieList: "/movies/",
    saveMovie: "/movies/",
    deleteMovie: "/movies/"
});