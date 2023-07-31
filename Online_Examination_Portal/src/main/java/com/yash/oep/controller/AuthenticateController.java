package com.yash.oep.controller;



import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.yash.oep.config.JwtUtil;
import com.yash.oep.helper.UserNotFoundException;
import com.yash.oep.model.JwtRequest;
import com.yash.oep.model.JwtResponse;
import com.yash.oep.model.User;
import com.yash.oep.service.impl.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	@Autowired
	private JwtUtil jwtUtil;


	
	//generate Token
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateTokan( @RequestBody JwtRequest jwtRequest) throws Exception 
	{
		try {
			
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
			}catch (UserNotFoundException e) {
				e.printStackTrace();
				System.out.println("User not Found");
			}
		
		UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
		String token =this.jwtUtil.generateToken(userDetails);
     	System.out.println(token);
		return ResponseEntity.ok(new JwtResponse(token));
		
	}
	
	
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = this.userDetailsServiceImpl
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = this.jwtUtil.generateToken(userDetails);
         System.out.println(jwt);
		return ResponseEntity.ok(new JwtResponse(jwt));
	}

	
	
	private void authenticate(String username,String password) throws Exception
	{
		
		try {
			  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		}catch (DisabledException e) {
			throw new Exception("USER DISABLED"+ e.getMessage());
		}catch (BadCredentialsException e) {
			throw new Exception("Invalid Credentials " +e.getMessage());
			
		}
		
	}
	//return the current user details
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal)
	{
		return ((User) this.userDetailsServiceImpl.loadUserByUsername(principal.getName()));
	}

}
