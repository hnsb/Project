package com.yash.oep.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.oep.model.exam.Questions;
import com.yash.oep.model.exam.Quize;
import com.yash.oep.repo.QuestionRepo;
import com.yash.oep.service.QuestionsService;
@Service
public class QuestionsServiceImpl implements QuestionsService {
	@Autowired
	private QuestionRepo questionRepo;

	@Override
	public Questions addQuestion(Questions question) {
		
		return this.questionRepo.save(question);
	}

	@Override
	public Questions updateQuestion(Questions questions) {
		
		return this.questionRepo.save(questions);
	}

	@Override
	public Set<Questions> getQuetions() {
	
		return new HashSet<>(this.questionRepo.findAll());
	}

	@Override
	public Questions getQuetions(Long questionsId) {
	
		return this.questionRepo.findById(questionsId).get();
	}

	@Override
	public Set<Questions> getQuestionsOfQuize(Quize quize) {
		
		return this.questionRepo.findByQuize(quize);
	}



	@Override
	public void deleteQuestion(Long quesId) {
		
		Questions questions = new Questions();
		questions.setQuesId(quesId);
		this.questionRepo.delete(questions);
		
	}

	@Override
	public Questions get(Long quesId) {
		
		return this.questionRepo.getOne(quesId);
	}

}
