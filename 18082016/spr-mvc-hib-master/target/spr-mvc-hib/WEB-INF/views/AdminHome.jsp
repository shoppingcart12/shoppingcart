
<div ng-controller="loginController">

	<div class="mainDIV">
		<div class="leftDIV">
			<h4 style="color: #2980B9;">Welcome:<font color="blue">{{loggedin}}</font></h4>
			 <h4 style="color: #2980B9;">Role:<font color="blue">{{role}}</font></h4> 
		</div>
		<div class="middleDIV">
			<h2 align="center" style="color: #2980B9;">Product Details</h2>
		</div>
		<div class="rightDIV">
			<a href="" ng-click="logout()"><span
				class="glyphicon glyphicon-user"></span>Sign Out</a>
		</div>
	</div>
	<br/>
	<div>
		<div>
			<button ng-if="isTrue" type="button" class="btn btn-info"
				data-toggle="modal" data-target="#myModal">Add Product</button>
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Product Details</h4>
						</div>
						<div class="modal-body">
						<form>
									Product Brand:
									<select class="btn btn-default dropdown-toggle"
										ng-model="pbrand" required="required">
											<option ng-repeat="pbrand in brands">{{ pbrand }}</option>
									</select><br/>
									Product Name:
									<input type="text" ng-model="pname" required="required"><br/>
									Product price:
									<input type="text" ng-model="pprice" required="required"><br/>
									<input type="submit" class="btn btn-default" value="submit" data-dismiss="modal" ng-click="addproduct()">
								
							</form>
						</div>
					</div>

				</div>
			</div>

		</div>
	</div>
	<div class="container" align="right">
		<select class="btn btn-default dropdown-toggle" ng-model="user" >
			<option ng-repeat="pbrand in brands">{{ pbrand }}</option>
		</select> 


		<table class="table table-bordered">
		<thead>
			<tr>
				<th ng-click="orderByMe('brand')"><span class="glyphicon glyphicon-filter"></span>Product Brand</th>
				<th ng-click="orderByMe('productname')"><span class="glyphicon glyphicon-filter"></span>Product Name</th>
				<th ng-click="orderByMe('price')"><span class="glyphicon glyphicon-filter"></span>Price</th>
			</tr>
		</thead>

		<tbody>
				<tr ng-repeat="user in product | filter:user | orderBy:myOrderBy">
						<td>{{ user.brand}}</td>
						<td>{{ user.productname }}</td>
						<td>{{ user.price | currency:"&#8377;" }}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>