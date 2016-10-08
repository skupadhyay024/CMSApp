'use strict';
 
var myApp = angular.module('myApp',['ngRoute']);
myApp.config(function($routeProvider,$httpProvider,$locationProvider){
	$routeProvider.when("/login",{
		templateUrl:"view/login.html",
		controller:"appctrl"
		
		
	}).when("/dashboard",{
	

		templateUrl:"view/dashboard.html",
			controller:"appctrl"
	}).when("/newart",{
	

		templateUrl:"view/newarticle.html",
			controller:"appctrl"
	}).otherwise({
		redirectTo : "/login"
	});
	
});