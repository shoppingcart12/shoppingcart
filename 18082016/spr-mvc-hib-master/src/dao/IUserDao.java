package com.java.dao;

import java.util.List;

import com.java.bean.User;

public interface IUserDao {
	
	public boolean checkLogin(String username, String password);

}
