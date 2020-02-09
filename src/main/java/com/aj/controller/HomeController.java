package com.aj.controller;

import javax.servlet.http.HttpServletRequest;

public class HomeController {
	
	public static String home(HttpServletRequest req) {
		System.out.println("In home controller;");
		if (req.getSession().getAttribute("role") == "admin") {
			return "/html/AdminHome.html";
		}
		return "/html/EmployeeHome.html";
		
	}
	
}
