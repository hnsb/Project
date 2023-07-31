package com.yash.oep.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.yash.oep.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
