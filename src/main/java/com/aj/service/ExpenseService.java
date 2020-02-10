package com.aj.service;

import java.util.List;

import com.aj.model.Expense;
import com.aj.model.User;

public interface ExpenseService {
	
	
	public List<Expense> getAllExpenses();
	public List<Expense> getExpensesByState();
	
	public List<Expense> getExpensesByUserId();
	
	public boolean createExpense(Expense ex);
	
	
}
