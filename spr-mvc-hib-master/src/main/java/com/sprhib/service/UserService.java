package com.sprhib.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.IUserDao;
import com.sprhib.dao.UserDao;
import com.sprhib.model.Users;


@Service
@Transactional
public class UserService implements IUserService{
    
         @Autowired
		 private IUserDao loginDAO;

		  
	     
	      public IUserDao getLoginDAO() {
			return loginDAO;
		}



		public void setLoginDAO(IUserDao loginDAO) {
			this.loginDAO = loginDAO;
		}



		public boolean checkLogin(String username, String password){
	             System.out.println("In Service class...Check Login");
	             System.out.println(username + password );
	             return loginDAO.checkLogin(username, password);

}
		public boolean updatePwd(Users user){
            System.out.println("In Service class...Check Login");
            return loginDAO.updatePwd(user);

}



		@Override
		public boolean checkUsername(String username) {
			 System.out.println("In Service class...Check Login");
             System.out.println(username);
             return loginDAO.checkuser(username);
		}



		@Override
		public Integer getUserRole(String username) {
            return loginDAO.getRole(username);
		}
}