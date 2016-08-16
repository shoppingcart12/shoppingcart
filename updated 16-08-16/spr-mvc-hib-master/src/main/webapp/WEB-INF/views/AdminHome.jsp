<%-- <?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Home page</title>
</head>
<body>
<h1>Home page</h1>
<p>
${message}<br/>

<a href="${pageContext.request.contextPath}/product/add.html">Add new Product</a><br/>
<a href="${pageContext.request.contextPath}/productslist">Product list</a><br/>
</br>
</br>
<a href="${pageContext.request.contextPath}/goLogin">Logout</a><br/>
</p>
</body>
</html> --%>

<!-- <!-- <div ng-controller="HomeController">
	This is product page
</div>

<!DOCTYPE html>
<html ng-controller="loginController">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="/release/ui-grid.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular-touch.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular-animate.js"></script>
  <script src="Hover.js"></script>
</head>
<body> -->
<head>
<style>
#thumbnail:hover + #title {
	display: block;
}
</style>
</head><body>
<div ng-controller="loginController">
   <ul class="nav nav-tabs">
    <li class="active">
        Welcome:<p>{{username}}</p>
    </li>
    <li>
        <!-- <a href="#">Product Details</a> -->
        <a href="#" data-toggle="tooltip" title="Hello! Let's see the products">Product Details</a>
    </li>
    <ul class="nav navbar-nav navbar-right">
         <li><a href="" ng-click="logout()"><span class="glyphicon glyphicon-user"></span>Sign Out</a></li>
    </ul>
</ul>
<div class="container" align="right">
  <h2>Select Brand</h2>
  <select class="btn btn-default dropdown-toggle" ng-model="user">
  <option ng-repeat="pbrand in brands">{{ pbrand }}</option>
</select>




 <table class="table">
   		 <th>Product Brand</th>
         <th>Product Name</th>
         <th> <a href="#" ng-click="sortType = 'price'">Price</a></th>
         
      </tr>
      
   <tbody>
   <tr ng-repeat="user in product | filter:user">
		<td>{{ user.brand}}</td>
		<td id="thumbnail">{{ user.productname }}</td>
		<td>{{ user.price }}</td>
		
		
		<td><img alt="" src="/images/{{user.imgpath}}" height="100px" width="100px">
		
		
		<div id="title">{{ user.productname }}{{ user.productid }}</div>
		
		</td>
   </tbody>
 </table>
</div>
</body>
<!-- </body>
</html> -->
