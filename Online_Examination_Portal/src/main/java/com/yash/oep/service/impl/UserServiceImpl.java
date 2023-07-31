package com.yash.oep.service.impl;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.yash.oep.model.User;
import com.yash.oep.model.UserRole;
import com.yash.oep.repo.RoleRepo;
import com.yash.oep.repo.UserRepo;
import com.yash.oep.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
    private RoleRepo roleRepo;
	
	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception{
		
		User local=this.userRepo.findByUsername(user.getUsername());
		if(local != null)
		{
			System.out.println("User is alraedy there !!");
			throw new Exception("user is already there !!");
		}
		else
		{
			//user create
			for(UserRole ur:userRoles)
			{
				roleRepo.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepo.save(user);
			
		}
		
		return local;
	}

	@Override
	public User getUser(String username) {
		
		return this.userRepo.findByUsername(username);
	}

	@Override
	public void  deleteUser(int id) {
		
		this.userRepo.deleteById(id);
	}

}
