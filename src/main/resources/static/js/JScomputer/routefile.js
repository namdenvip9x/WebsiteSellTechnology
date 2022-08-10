var app = angular.module("myApp",["ngRoute"]);

app.config(function($routeProvider){
	$routeProvider
	    .when("/product",{
          templateUrl: "/asserts/view/product/index.html"
        })
         .when("/shop",{
          templateUrl: "/asserts/view/shop/shop.html"
        })

        .otherwise({ 
	     template:"/asserts/view/layout.html"});
	
});