<div class="container" ng-controller="loginController">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<h1 align="center" class="text-center login-title">Reset Password</h1>

				<div class="account-wall">
					<form class="form-signin">
						Username: <input type="text" class="form-control"
							placeholder="Username" ng-model="runame" required autofocus><br>
						Password: <input type="password" class="form-control"
							placeholder="Password" required><br> Confirm
						Password: <input type="password" class="form-control"
							placeholder="Confirm Password" required><br>
						<!-- Email-ID: <input type="text" class="form-control"
					
							placeholder="Email" required><br> -->
							
						<button class="btn btn-lg btn-primary btn-block" ng-click="resetuser()" type="submit">Reset Password</button>
					</form>
				</div>
			</div>
		</div>
	</div>
