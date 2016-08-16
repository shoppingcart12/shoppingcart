<div class="container" ng-controller="loginController">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 align="center" class="text-center login-title">Product Login Page</h1>
          <div align="right">
           		 <a href="" ng-click="regi()" class="text-center new-account">New User</a>
            </div>          
            <div class="account-wall">
                <form  class="form-signin" novalidation>
                Username: <input type="text" class="form-control" ng-model="username" placeholder="Enter Username" required><br>
                Password: <input type="password" class="form-control" ng-model="password" placeholder="Password" required><br>
                <button class="btn btn-primary" ng-click="submit()" type="submit">Sign in</button>
                  <div align="right">
           		 <a href="" ng-click="forgot()" class="text-center new-account">Forgot Password?</a>
           		 <p align="center" style="color:red;">{{failure}}</p>
            </div>
            
                </form>
           </div>            
        </div>
    </div>
    
</div>
