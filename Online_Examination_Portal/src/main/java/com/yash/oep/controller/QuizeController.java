package com.yash.oep.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.oep.model.exam.Category;
import com.yash.oep.model.exam.Quize;
import com.yash.oep.service.QuizeService;

@RestController
@RequestMapping("/quize")
@CrossOrigin("*")
public class QuizeController {

	@Autowired
	private QuizeService quizeService;
	
	
//	Add Quize
	
	@PostMapping("/")
	public ResponseEntity<?> addQuize(@RequestBody Quize quize )
	{
		return ResponseEntity.ok(this.quizeService.addQuize(quize));
	}
	
//	update quize
	@PutMapping("/")
	public ResponseEntity<?> updateQuize(@RequestBody Quize quize)
	{
		return ResponseEntity.ok(this.quizeService.updateQuize(quize));
	}
	
	
//	get quize all 
	
	@GetMapping("/")
	public ResponseEntity<?> quizzes()
	{
		return ResponseEntity.ok(this.quizeService.getQuizzes());
	}
	
//	get single quiz
	@GetMapping("/{qid}")
	public Quize quize(@PathVariable("qid") Long id)
	{
		return this.quizeService.getQuize(id);
	}
	
//	delete quiz
	
	@DeleteMapping("/{qid}")
	public void deletquize(@PathVariable("qid") Long id)
	{
		this.quizeService.deleteQuize(id);
	}
	
//	get single quiz
	@GetMapping("/category/{id}")
	public List<Quize> getQuiz(@PathVariable("id") Long id)
	{
		Category category = new Category();
		category.setId(id);
		return this.quizeService.getQuizzesOfCategory(category);
	}
//	get Active quizzes
	@GetMapping("/active")
	public List<Quize> getActiveQuizzes()
	{
		return this.quizeService.getActiveQuizzes();
	}
	
//	get Active quizzes of category
	@GetMapping("/category/active/{id}")
	public List<Quize> getActiveQuizzes(@PathVariable("id")Long id)
	{
		Category category = new  Category();
		category.setId(id);
		return this.quizeService.getActiveQuizzesOfCategory(category);
	}
	
	
}
