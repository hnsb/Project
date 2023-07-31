package com.yash.oep.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.oep.helper.UserFoundException;
import com.yash.oep.model.Role;
import com.yash.oep.model.User;
import com.yash.oep.model.UserRole;
import com.yash.oep.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService; 
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
//	create user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception
	{
//		encoding password with bcrptpasswordEncoder
		
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		
		Set<UserRole> roles = new HashSet<>();
		
		Role role = new Role();
		role.setRoleName("NORMAL");
		
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		
		roles.add(userRole);
		
		return this.userService.createUser(user, roles);
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username)
	{
		return this.userService.getUser(username);
	}
	//delete user By id
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") int id)
	{
		this.userService.deleteUser(id);
	}
	@ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserFoundException ex)
    {
    	 ex.printStackTrace();
		return null;
    }
}
