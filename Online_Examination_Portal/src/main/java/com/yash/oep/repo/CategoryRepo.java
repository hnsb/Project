package com.yash.oep.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.oep.model.exam.Category;

public interface CategoryRepo extends JpaRepository<Category,Long> {

}
