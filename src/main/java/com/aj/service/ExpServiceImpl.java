package com.aj.service;

import java.util.ArrayList;
import java.util.List;

import com.aj.DAO.ExpenseDAO;
import com.aj.DAO.ExpenseDAOImpl;
import com.aj.model.Expense;
import com.aj.model.User;

public class ExpServiceImpl implements ExpenseService {
	public static ExpenseDAO expDao = new ExpenseDAOImpl();
	List<Expense> allExpenses = new ArrayList<>();
	
	@Override
	public List<Expense> getAllExpenses() {
		allExpenses = expDao.selectAllExpenses();
		return allExpenses;
	}

	@Override
	public List<Expense> getExpensesByState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Expense> getExpensesByUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createExpense(Expense ex) {
		return expDao.createNewExpense(ex);
	}

}
