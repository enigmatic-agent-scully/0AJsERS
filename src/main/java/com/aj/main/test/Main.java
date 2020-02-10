package com.aj.main.test;

import java.util.List;

import com.aj.model.CreateNewRandom;
import com.aj.model.Expense;
import com.aj.model.User;
import com.aj.service.ExpServiceImpl;
import com.aj.service.ExpenseService;
import com.aj.service.UserService;
import com.aj.service.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		UserService usrSvc = new UserServiceImpl();
		ExpenseService expSvc = new ExpServiceImpl();
//		List<User> newUsers = CreateNewRandom.createUsers();
//		for (User u : newUsers) {
//			usrSvc.createUser(u);
//		}
		String[] amounts = {"178.66", "1234.56", "102.7", "938.66", "666.66", "1.97", "19.99", "0.01"};
		String[] descs = {"I am", "almost DONE", "just INSERTING", "test data", "here's some", "more test", "i can't wait", "to be done"};
		List<User> users = usrSvc.getAllUsers();
		String amount = null, desc = null;
		for (User u : users) {
			
			for (int i = 0; i < amounts.length; i++) {
				amount = amounts[i];
				desc = descs[i];
			}
			Expense newExp = new Expense(null, u.getU_id(), "1", null, null, "pending", amount, desc);
			expSvc.createExpense(newExp);
		}
	}

}
