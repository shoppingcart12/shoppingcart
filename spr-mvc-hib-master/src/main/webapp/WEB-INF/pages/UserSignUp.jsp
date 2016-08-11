<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
</head>
<body>
    <form:form  method="POST" action="signUpUser">
        <div align="center">
            <table>
                <tr>
                 
                    <td>User Name</td>
                    <td><input type="text" name="username" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="email" name="email" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit" /></td>
                </tr>
                
            <tr>
                    <td></td>
                    <td><a href="${pageContext.request.contextPath}/goLogin">Go To Login</a></td>
                   
                </tr>
            </table>
            <div style="color: red">${message}</div>
        </div>
    </form:form>
</body>
</html>