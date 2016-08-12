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
<div ng-controller="loginController">
   <ul class="nav nav-tabs">
    <li class="active">
        Welcome:<p ng-bind="username"></p>
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
  <select class="btn btn-default dropdown-toggle">
  <option selected disabled>Select</option>
  <option value="All">All</option>
  <option value="Samsung">Samsung</option>
  <option value="Motorola">Motorola</option>
  <option value="Nokia">Nokia</option>
</select>

 <table class="table">
   		 <th>Product Brand</th>
         <th>Product Name</th>
         <th> <a href="#" ng-click="sortType = 'price'">Price</a></th>
      </tr>
         
   <tbody>
      <tr>
         <td>Samsung</td>
         <td><a href="#" data-toggle="tooltip" title="Samsung Galaxy J3 (6) The Samsung Galaxy J3 (6) 
         is powered by 1.5GHz quad-core and it comes with 1.5GB of RAM. The phone packs 8GB of internal 
         storage that can be expanded up to 128GB via a microSD card">Galaxy J3</a></td>
         <td>9000</td>
      </tr>      
      <tr>
         <td>Samsung</td>
         <td><a href="#" data-toggle="tooltip" title="Samsung Galaxy S6 smartphone was launched in March 2015.
          The phone comes with a 5.10-inch touchscreen display with a resolution of 1440 pixels by 2560 pixels
           at a PPI of 577 pixels per inch. The Samsung Galaxy S6 is powered by 1.5GHz octa-core Samsung Exynos
            7420 processor and it comes with 3GB of RAM.">Galaxy s6</a></td>
         <td>30000</td>
      </tr>
      <tr>
         <td>Motorola</td>
         <td><a href="#" data-toggle="tooltip" title="Moto G4 was launched in May,2016. The phone comes with 5.5 inch
         touchscreen with a resolution of 1080 by 1920 pixels. it has 2GB of RAM and internal memory of 32GB">Moto G4</a></td>
         <td>14000</td>
      </tr>
      <tr>
         <td>Nokia</td>
         <td><a href="#" data-toggle="tooltip" title="Nokia Lumia 625 is a Windows Phone 8 Smartphone from Nokia. 
         It comes with 4.7 inch LCD Display,1.2 GHz Dual Core Processor and 5 MP Camera">Lumia 625</a></td>
         <td>12000</td>
      </tr>
   </tbody>
 </table>
</div>
<!-- </body>
</html> -->
