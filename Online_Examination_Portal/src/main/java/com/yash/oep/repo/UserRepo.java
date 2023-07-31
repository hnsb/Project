package com.yash.oep.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.yash.oep.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	public User findByUsername(String username);

}
