package com.aj.main.test;

import java.util.List;

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
		// usrSvc.createUser(CreateNewRandom.createRandomUser());
		List<User> users = usrSvc.getAllUsers();
		for (User u : users) {
			Expense newExp = new Expense(null, u.getU_id(), 1, null, null, "pending", (float) 102.07, "description");
			expSvc.createExpense(newExp, u.getU_id());
		}
		System.out.println(expSvc.getAllExpenses());
	}

}
