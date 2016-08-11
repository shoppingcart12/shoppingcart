package com.sprhib.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.UserDao;
import com.sprhib.dao.UserDaoImpl;
import com.sprhib.model.Product;
import com.sprhib.model.Users;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    
         @Autowired
		 private UserDao loginDAO;
       
         public UserDao getLoginDAO() {
			return loginDAO;
		}

     	public void setLoginDAO(UserDao loginDAO) {
			this.loginDAO = loginDAO;
		}
    
     	public boolean checkLoginInf(String username, String password){
     		boolean valid=false;
     		try{
	             System.out.println("In Service class...Check Login");
	             System.out.println(username + password );
	             valid=loginDAO.checkLoginInf(username, password);
     		}catch(Exception e){
     			e.printStackTrace();
     		}
	       return valid;
        }
     	
		public boolean updatePwd(Users user){
			boolean valid=false;
			try{
            System.out.println("In Service class...Check Login");
            valid=loginDAO.updatePwd(user);
			}catch(Exception e){
     			e.printStackTrace();
     		}
	       return valid;
        }

		@Override
		public boolean checkUserInf(String username) {
			boolean valid=false;
			try{
			 System.out.println("In Service class...Check Login");
             System.out.println(username);
             valid=loginDAO.checkUserInf(username);
			}catch(Exception e){
     			e.printStackTrace();
     		}
	       return valid;
		}
		
		public void addUser(Users user) {
			try{
			loginDAO.addUser(user);		
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		@Override
		public Integer getUserRole(String username) {
            return loginDAO.getRole(username);
		}
}