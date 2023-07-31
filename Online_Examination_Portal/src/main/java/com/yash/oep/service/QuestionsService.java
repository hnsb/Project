package com.yash.oep.service;

import java.util.Set;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.stereotype.Service;

import com.yash.oep.model.exam.Questions;
import com.yash.oep.model.exam.Quize;
@Service
public interface QuestionsService {
	
	public Questions addQuestion(Questions question);
	
	public Questions updateQuestion(Questions questions);
	
	public Set<Questions> getQuetions();
	
	public Questions getQuetions( Long questionsId);
	
	public Set<Questions> getQuestionsOfQuize(Quize quize);
	
	public void deleteQuestion(Long quesId);
	public Questions get(Long quesId);

}
