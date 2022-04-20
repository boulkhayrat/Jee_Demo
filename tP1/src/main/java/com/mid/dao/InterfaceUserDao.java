package com.mid.dao;

import com.mid.model.User;

public interface InterfaceUserDao {
	
	public User selectUser(String email);
	public String selectRole(String email);
	

}
