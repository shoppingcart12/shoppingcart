package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.Users;


public interface IUserDao {
	
	public boolean checkLogin(String username, String password);
	public boolean updatePwd(Users user);
	public boolean checkuser(String username);
	public Integer getRole(String username);
}
