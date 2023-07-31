package com.yash.oep.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.oep.model.exam.Category;
import com.yash.oep.repo.CategoryRepo;
import com.yash.oep.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Category addCategory(Category category) {
		
		return this.categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
	
		return this.categoryRepo.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		
		return new LinkedHashSet<>(this.categoryRepo.findAll());
	}

	@Override
	public Category getCategory(Long categoryId) {
		
		return this.categoryRepo.findById(categoryId).get();
	}

	public void deleteCategory(Long categoryId) {
		
		Category category = new Category();
		category.setId(categoryId);
		this.categoryRepo.delete(category);
		
	}

}
