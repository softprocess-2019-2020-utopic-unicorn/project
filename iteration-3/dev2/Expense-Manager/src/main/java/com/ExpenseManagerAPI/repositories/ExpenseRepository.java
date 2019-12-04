package com.ExpenseManagerAPI.repositories;

import java.util.List;

import com.ExpenseManagerAPI.domain.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String>{

	List<Expense> findByMonthAndYear(String month, int year);

	@Query("{ 'id' : ?0 }")
	Expense findById(String id);
	List<Expense> findByYear(int year);

}
