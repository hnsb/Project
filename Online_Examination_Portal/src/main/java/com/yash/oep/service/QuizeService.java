package com.yash.oep.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yash.oep.model.exam.Category;
import com.yash.oep.model.exam.Quize;

@Service
public interface QuizeService {

	
	public Quize addQuize(Quize quize);
	
	public Quize updateQuize(Quize quize);
	
	public Set<Quize> getQuizzes();
	
	public Quize getQuize(Long quizeId);
	
	public void deleteQuize(Long quizId);

	public List<Quize> getQuizzesOfCategory(Category category);
	
	public List<Quize> getActiveQuizzes();
	
	public List<Quize> getActiveQuizzesOfCategory(Category c);

	
	
}
