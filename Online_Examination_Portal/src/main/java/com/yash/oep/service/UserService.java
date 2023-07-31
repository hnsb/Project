package com.yash.oep.service;

import java.util.Set;

import com.yash.oep.model.User;
import com.yash.oep.model.UserRole;

public interface UserService {
	
	//creating user
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	
	//get user by username
	public User getUser(String username);
	
	//delet user by Id
	
	public void  deleteUser(int id);

}
