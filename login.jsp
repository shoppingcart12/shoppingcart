<div  ng-controller="loginController">
  <form name="myForm">
    Username:
    <input type="text" name="username" ng-model="username" required><span style="color:red;" ng-show="myForm.username.$error.required">Username Required</span><br>
    Password:
    <input type="password" name="password" ng-model="pwd" required><span style="color:red;" ng-show="myForm.password.$error.required">Password Required</span>
    <br><br>
    <button ng-click="reset()">Submit</button>
  </form>
  
</div>
