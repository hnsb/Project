package com.yash.oep.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yash.oep.model.User;
import com.yash.oep.repo.UserRepo;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.userRepo.findByUsername(username);
		if(user==null)
		{
//			System.out.println("I am in UserDetailsServiseImpl Class");
			System.out.println("user not found");
			throw new UsernameNotFoundException("No user found !!! ");
			
			
		}
		return (UserDetails) user;
	}
	

}
