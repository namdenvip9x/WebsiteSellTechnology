var app = angular.module("myApp",["ngRoute"]);
app.config(function($routeProvider){
	$routeProvider
	    .when("/product",{
          templateUrl:"/asserts/admin/product/managepro.html",
          controller: "Ctrlproduct"
        })
        .when("/categories",{
          templateUrl:"/asserts/admin/categories/managecate.html",
          controller: "Ctrlcate"
        })
         .when("/users",{
          templateUrl:"/asserts/admin/users/account.html",
          controller: "Ctrluser"
        })
          .when("/athotiting",{
          templateUrl:"/asserts/admin/athotiting/athotities.html",
          controller: "Ctrlathotities"
        })
        .otherwise({ 
	     redirectTo:"/product"
});
	
});