var app = angular.module("shoping-cart", []);

app.controller("shoping-ctrl", function ($scope, $http) {
	alert('đa]')

	$scope.cart = {
		items: [],

		add(id) {
			alert(id)
		}
	}


})