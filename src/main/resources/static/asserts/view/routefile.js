var app = angular.module("myApp",["ngRoute"]);
app.config(function($routeProvider){
	$routeProvider
	    .when("/product",{
          templateUrl:"/asserts/view/product/index.html",
          controller: "productCtrl"
        })
         .when("/shop",{
          templateUrl: "/asserts/view/shop/shop.html",
          controller: "shopCtrl"
        }) 
          .when("/cart",{
          templateUrl: "/asserts/view/cart/carts.html",
          
        }) 
        .otherwise({ 
	     redirectTo:"/product"
});
	
});