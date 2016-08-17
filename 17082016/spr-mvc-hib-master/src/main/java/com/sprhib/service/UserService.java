package com.sprhib.service;

import com.sprhib.model.Users;
public interface UserService {
	public boolean checkLoginInf(String username, String password);
	public boolean updatePwd(Users user);
	public boolean checkUserInf(String username);
	public Integer getUserRole(String username);
    public void addUser(Users user);
}
