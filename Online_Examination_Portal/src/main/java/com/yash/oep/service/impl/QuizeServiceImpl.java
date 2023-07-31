package com.yash.oep.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.oep.model.exam.Category;
import com.yash.oep.model.exam.Quize;
import com.yash.oep.repo.QuizeRepo;
import com.yash.oep.service.QuizeService;
@Service
public class QuizeServiceImpl implements QuizeService{
	
	@Autowired
	private QuizeRepo quizeRepo;

	@Override
	public Quize addQuize(Quize quize) {
		
		return this.quizeRepo.save(quize);
	}

	@Override
	public Quize updateQuize(Quize quize) {
		
		return this.quizeRepo.save(quize);
	}

	@Override
	public Set<Quize> getQuizzes() {
		
		return new HashSet<>(this.quizeRepo.findAll());
	}

	@Override
	public Quize getQuize(Long quizeId) {
		
		return this.quizeRepo.findById(quizeId).get();
	}

	@Override
	public void deleteQuize(Long qId) {
		
		this.quizeRepo.deleteById(qId);
		
	}

	@Override
	public List<Quize> getQuizzesOfCategory(Category category) {
		
		return this.quizeRepo.findBycategory(category);
	}

	@Override
	public List<Quize> getActiveQuizzes() {
		
		return this.quizeRepo.findByActive(true);
	}

	@Override
	public List<Quize> getActiveQuizzesOfCategory(Category c) {
		
		return this.quizeRepo.findByCategoryAndActive(c, true);
	}

}
