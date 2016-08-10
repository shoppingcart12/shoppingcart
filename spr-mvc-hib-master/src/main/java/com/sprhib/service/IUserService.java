package com.sprhib.service;

import java.util.List;

import com.sprhib.model.Users;
public interface IUserService {
	
	public boolean checkLogin(String username, String password);
	public boolean updatePwd(Users user);
	public boolean checkUsername(String username);
	public Integer getUserRole(String username);

}
