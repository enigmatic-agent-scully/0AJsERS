package com.aj.controller;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.aj.model.Expense;
import com.aj.service.ExpServiceImpl;
import com.aj.service.ExpenseService;

public class EmployeeController {
	
	public static String submitExpense(HttpServletRequest req) {
		System.out.println("In employee controller");
		ExpenseService expSvc = new ExpServiceImpl();
		Expense newExp = new Expense();
		Map<String, String[]> params = req.getParameterMap();
		for (String key : params.keySet()) {
			System.out.print(key + ": ");
			String[] arr = (String[]) params.get(key);
			for(String val : arr) {
				System.out.print(val + " ");
			}
		}
		
		int e_id = (int) req.getSession().getAttribute("u_id");
		//System.out.println(e_id);
		System.out.println(req.getParameter("Amount"));
		String desc = req.getParameter("Description");
		System.out.println(desc);
		newExp.setFk_e_id(e_id);
		//newExp.setType(type);
		//newExp.setAmount(amount);
		newExp.setDesc(desc);
		System.out.println(newExp);
		expSvc.createExpense(newExp);
		
		return "/html/EmployeeHome.html";
	}
}
