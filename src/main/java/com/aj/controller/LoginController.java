package com.aj.controller;

import javax.servlet.http.HttpServletRequest;

public class LoginController {

	public static String login(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {
			System.out.println("returning login.change");
			return "html/login.change";
		}
		System.out.println("In login controller");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username + " " + password);
		
		if(!(username.equals("aj")) && password.equals("jordan")) {
			System.out.println("In bad login");
			return "badLogin.change";
		}
		else {
			req.getSession().setAttribute("loggedinusername", username);
			req.getSession().setAttribute("loggedinpw", password);
			System.out.println("login controller else ");
			return "AdminHome.change";
		}
	}
}
