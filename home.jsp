<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
<style>
input.ng-invalid {
    background-color:pink;
}
input.ng-valid {
    background-color:lightgreen;
}
</style>
<body ng-app="myApp">
	<div ng-view></div> 


</body>
</html>

<script>
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
</script>