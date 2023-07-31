package com.yash.oep.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.oep.model.exam.Category;
import com.yash.oep.model.exam.Quize;

public interface QuizeRepo extends JpaRepository<Quize, Long> {
	
	public List<Quize> findBycategory(Category category);
	
	public List<Quize> findByActive(Boolean b);
	
	public List<Quize> findByCategoryAndActive(Category c,Boolean b);

}
