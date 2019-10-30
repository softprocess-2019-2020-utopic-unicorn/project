package com.ExpenseManagerAPI.service.expense;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExpenseManagerAPI.domain.Expense;
import com.ExpenseManagerAPI.repositories.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public List<Expense> findAll() {
		return expenseRepository.findAll();
	}

	@Override
	public List<Expense> findByMonthAndYear(String month, int year) {
		return expenseRepository.findByMonthAndYear(month, year);
	}

	@Override
	public void saveOrUpdateExpense(Expense expense) {
		expenseRepository.save(expense);
	}

	@Override
	public void deleteExpense(String id) {
		expenseRepository.delete(id);		
	}

	@Override
	public List<Expense> findByYear(int year) {
		return expenseRepository.findByYear(year);
	}

	@Override
	public Expense findOneById(String id) {
		return expenseRepository.findById(id);
	}

}
