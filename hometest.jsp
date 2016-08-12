<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>

.form-signin
{
    max-width: 330px;
    padding: 15px;
    margin: 0 auto;
}
.form-signin .form-signin-heading, .form-signin .checkbox
{
    margin-bottom: 10px;
}
.form-signin .checkbox
{
    font-weight: normal;
}
.form-signin .form-control
{
    position: relative;
    font-size: 16px;
    height: auto;
    padding: 10px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}
.form-signin .form-control:focus
{
    z-index: 2;
}
.form-signin input[type="text"]
{
    margin-bottom: -1px;
    border-bottom-left-radius: 0;
    border-bottom-right-radius: 0;
}
.form-signin input[type="password"]
{
    margin-bottom: 10px;
    border-top-left-radius: 0;
    border-top-right-radius: 0;
}
.account-wall
{
    margin-top: 20px;
    padding: 40px 0px 20px 0px;
    background-color: #f7f7f7;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}
.login-title
{
    color: #555;
    font-size: 30px;
    font-weight: 400;
    display: block;
}
.need-help
{
    margin-top: 10px;
}
.new-account
{
    display: block;
    margin-top: 10px;
}

body {
background-color: #ccc;
}

table.table td {
background-color: white;
}

table.table td:hover {
background-color: grey;
}

.grid {
  width: 500px;
  height: 200px;
}
.red { color: red;  background-color: yellow !important; }
.blue { color: blue;  }

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
                        templateUrl : '${pageContext.request.contextPath}/logintest',
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


app.controller("HomeController", function($scope){});
</script>