package com.aj.DAO;

import java.util.List;

import com.aj.model.Expense;
import com.aj.model.User;

public interface ExpenseDAO {
	
	public boolean createNewExpense(Expense ex);
	
	public List<Expense> selectAllExpenses();
	public List<Expense> selectPendingExpenses();
	
	public String updateExpense(Expense ex);
	
	public String deleteExpense(Expense ex);
}
