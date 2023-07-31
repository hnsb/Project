package com.yash.oep.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.oep.model.exam.Questions;
import com.yash.oep.model.exam.Quize;

public interface QuestionRepo extends JpaRepository<Questions, Long> {

	Set<Questions> findByQuize(Quize quize);

}
