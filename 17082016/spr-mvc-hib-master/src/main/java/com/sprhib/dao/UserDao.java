package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.Product;
import com.sprhib.model.Users;

public interface UserDao {
	public boolean checkLoginInf(String username, String password);
	public boolean updatePwd(Users user);
	public boolean checkUserInf(String username);
	public Integer getRole(String username);
	public void addUser(Users user);
}
