var app = angular.module("myApp", ["ngRoute"]);
app.config([ '$routeProvider', function($routeProvider) {
                    $routeProvider.when('/product', {
                        templateUrl : '${pageContext.request.contextPath}/product',
                        controller : 'HomeController'
                    })
                    $routeProvider.when('/regi', {
                        templateUrl : '${pageContext.request.contextPath}/registest',
                        controller : 'loginController'
                    })
                    $routeProvider.when('/logout', {
                        templateUrl : '${pageContext.request.contextPath}/logout',
                        controller : 'loginController'
                    })
                    $routeProvider.when('/forgot', {
                        templateUrl : '${pageContext.request.contextPath}/forgot',
                        controller : 'loginController'
                    })
                     $routeProvider.when('/reset', {
                        templateUrl : '${pageContext.request.contextPath}/reset',
                        controller : 'loginController'
                    })
                    $routeProvider.when('/', {
                        templateUrl : '${pageContext.request.contextPath}/plogin',
                        controller : 'loginController'
                    }).otherwise({
                        redirectTo : '${pageContext.request.contextPath}/dummy'
                    });
                   // $locationProvider.html5Mode(true);
                }
            ]);

app.controller("loginController",function($scope,$http,$location)
{
	$scope.submit = function() {
		
		 $http.get("http://localhost:8081/TestAng/test?username="+$scope.username+"&password="+$scope.pwd).then (function(response)
			    	{ 
			    		$scope.message=response.data;
			    		$location.path("/product" );
			    	}); 
	    	/* if($scope.username==null || $scope.password==null)
	    		alert("Usernaem and Paswword cannot be empty");
	    	else
	    		{
				 	if($scope.username==$scope.password)
					$location.path("/product" );
				 	else alert("Wrong Credential");
	    		} */
	};
	
	$scope.regi = function()
	{
		$location.path("/regi");
	};

	$scope.forgot=function()
	{
		$location.path("/forgot");
	};
	
	$scope.runame=$scope.user;
	$scope.find=function()
	{
		if($scope.user=="naveen") $location.path("/reset"); 
		else alert("Username "+$scope.user+" not found");
	};
	
	$scope.logout=function()
	{
		$location.path("/logout");
	};
	
	$scope.gotohome=function()
	{
		$location.path("/");
	};
});