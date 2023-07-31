package com.yash.oep;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.yash.oep.model.Role;
import com.yash.oep.model.User;
import com.yash.oep.model.UserRole;
import com.yash.oep.service.UserService;

@SpringBootApplication
public class OnlineExaminationPortalApplication implements CommandLineRunner{
     @Autowired
	private UserService userService;
     @Autowired
	private BCryptPasswordEncoder  bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineExaminationPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception { 
		
		System.out.println("Starting code");
		
//		User user = new User(1, "Dev123", "dev@123", "deva", "sharma", "dev@gmail.com", "defult.png", true);
		
		
		/*User user=new User();
		
		
		user.setFname("Priti");
		user.setLname("Sharma");
		user.setUsername("priti123");
		user.setPassword(this.bCryptPasswordEncoder.encode("123"));
		user.setEmail("priti@gmail.com");
		user.setProfile("abc.png");
		
		Role role = new Role();
		role.setRoleName("ADMIN");
		
		Set<UserRole> userRoleSet = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoleSet.add(userRole);
		
		
		User user1 = this.userService.createUser(user, userRoleSet);
		System.out.println(user1.getUsername());*/
		
	}

}
