package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.bean.User;
import com.java.dao.UserDao;

@Service("userService")
public class UserService implements IUserService{
    
         @Autowired
		 private UserDao loginDAO;

		   public void setLoginDAO(UserDao loginDAO) {
	             this.loginDAO = loginDAO;
	      }
	     
	      public boolean checkLogin(String username, String password){
	             System.out.println("In Service class...Check Login");
	             System.out.println(username + password );
	             loginDAO = new UserDao();
	             return loginDAO.checkLogin(username, password);

	

}
}