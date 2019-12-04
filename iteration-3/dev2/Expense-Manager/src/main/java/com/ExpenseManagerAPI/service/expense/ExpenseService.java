package com.ExpenseManagerAPI.service.expense;

import java.util.List;

import com.ExpenseManagerAPI.domain.Expense;

public interface ExpenseService {
	
	List<Expense> findAll();
	
	List<Expense> findByMonthAndYear(String month, int year);
	
	List<Expense> findByYear(int year);

	Expense findOneById(String id);
	
	void saveOrUpdateExpense(Expense expense);
	
	void deleteExpense(String id);

}
