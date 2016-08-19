<div class="container">
<div class="row">
<div class="col-sm-6 col-md-4 col-md-offset-4">
<h1 align="center" class="text-center login-title">Product
Registration Page</h1>
 

<div class="account-wall">
<form class="form-signin">
Role: <select class="form-control" ng-model="prole" required="required">
											<option>Admin</option>
											<option>User</option>
									</select><br/>
Username: <input type="text" class="form-control"
placeholder="Username" ng-model="nuser" required autofocus><br>
Password: <input type="password" class="form-control"
placeholder="Password" ng-model="npwd" required><br> Confirm
Password: <input type="password" class="form-control"
placeholder="Confirm Password" ng-model="ncpwd" required><br>
Email-ID: <input type="text" class="form-control"
placeholder="Email" ng-model="nemail" required><br>
<button class="btn btn-lg btn-primary btn-block" type="submit" ng-click="newuser()">Register</button>
</form>
<p align="center"><a href="" ng-click="gotohome()">Home</a></p>
<p style="color:red;" align="center">{{errpwd}}</p>
</div>
</div>
</div>
</div>