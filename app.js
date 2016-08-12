
	var app = angular.module("myApp", ["ngRoute"]);
	app.config([ '$routeProvider', function($routeProvider) {
	                    $routeProvider.when('/product', {
	                        templateUrl : '${pageContext.request.contextPath}/product',
	                        controller : 'HomeController'
	                    })
	                    $routeProvider.when('/', {
	                        templateUrl : '${pageContext.request.contextPath}/login',
	                        controller : 'loginController'
	                    }).otherwise({
	                        redirectTo : '${pageContext.request.contextPath}/dummy'
	                    });
	                   // $locationProvider.html5Mode(true);
	                }
	            ]);
	
app.controller("loginController",function($scope,$location)
{
	
	 $scope.reset = function() {
	    	
    		$location.path("/product" );
    	

};
});

app.controller("HomeController", function($scope){});
