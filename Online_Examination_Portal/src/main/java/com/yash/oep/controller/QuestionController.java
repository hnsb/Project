package com.yash.oep.controller;

import java.awt.peer.KeyboardFocusManagerPeer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
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

import com.yash.oep.model.exam.Questions;
import com.yash.oep.model.exam.Quize;
import com.yash.oep.service.QuestionsService;
import com.yash.oep.service.QuizeService;



@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
	
	@Autowired
	private QuizeService quizeService;
	@Autowired
	private QuestionsService questionsService;
	
//	Add question
	
	@PostMapping("/")
	public ResponseEntity<Questions> add(@RequestBody Questions question)
	{
		return ResponseEntity.ok(this.questionsService.addQuestion(question));
	}
	
//	Update question 
	@PutMapping("/")
	public ResponseEntity<Questions> update(@RequestBody Questions questions)
	{
		return ResponseEntity.ok(this.questionsService.updateQuestion(questions));
	}
	
//	get all question of any quiz
	
	@GetMapping("/quize/{qId}")
	public ResponseEntity<?> getQuestionOfQuize(@PathVariable("qId") Long qId)
	{
		/*Quize quize = new Quize();
		quize.setqId(qid);
		Set<Questions> questionOfQuiz= this.questionsService.getQuestionsOfQuize(quize);
		return ResponseEntity.ok(questionOfQuiz);*/
		
		Quize quiz = this.quizeService.getQuize(qId);
		Set<Questions> question= quiz.getQuestions();
		List list = new ArrayList(question);
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions()))
		{
			list=list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()+1));
		}
		 Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/quize/all/{qId}")
	public ResponseEntity<?> getQuestionOfQuizeAdmin(@PathVariable("qId") Long qId)
	{
		Quize quize = new Quize();
		quize.setqId(qId);
		Set<Questions> questionOfQuiz= this.questionsService.getQuestionsOfQuize(quize);
		return ResponseEntity.ok(questionOfQuiz);
		
		
	}
	
//	get single Questions
	@GetMapping("/{quesId}")
	public Questions get(@PathVariable("quesId") Long quesId)
	{
		return this.questionsService.getQuetions(quesId);
	}
	
//	delete question
	@DeleteMapping("/{quesId}")
	public void delete(@PathVariable("quesId") Long quesId)
	{
		this.questionsService.deleteQuestion(quesId);
	}
	
//	eval quiz
	@PostMapping("/eval-quiz")
	public ResponseEntity<?> evalQuiz(@RequestBody List<Questions> questions)
	{
		
		double marksGot=0;
		int correctAnswer=0;
		int attempted=0;
//		System.out.println(questions.);
		for(Questions q : questions){
			Questions question=this.questionsService.get(q.getQuesId());
			if(question.getAnswer().equals(q.getGivenAnswer()))
			{
              correctAnswer++;
              
              double marksSingle=Double.parseDouble(questions.get(0).getQuize().getMaxMarks())/questions.size();
              marksGot+=marksSingle;
				
			}
//			if(q.getGivenAnswer()!=null || !q.getGivenAnswer().trim().equals(""))
			if(q.getGivenAnswer()!=null)
			{
				attempted++;
			}
		}
		Map<String,Object> map = Map.of("marksGot",marksGot,"correctAnswer",correctAnswer,"attempted",attempted);
		return ResponseEntity.ok(map);
	}

}
