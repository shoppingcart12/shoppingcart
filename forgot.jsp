<div class="container" ng-controller="loginController">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<h1 align="center" class="text-center login-title">Password Reset Page</h1>

				<div class="account-wall">
					<form class="form-signin">
						Username: <input type="text" class="form-control" placeholder="Username" ng-model="user" required><br/>
						<button class="btn btn-lg btn-primary btn-block" ng-click="find()" type="submit">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>
