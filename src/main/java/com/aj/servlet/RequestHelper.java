package com.aj.servlet;

import javax.servlet.http.HttpServletRequest;

import com.aj.controller.HomeController;
import com.aj.controller.LoginController;

public class RequestHelper {
	public static String process(HttpServletRequest req) {
		System.out.println(req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/0AJsERS/login.change": 
			System.out.println("In login.change");
			return LoginController.login(req);
		case "/0AJsERS/AdminHome.change":
			return HomeController.home(req);
		default: 
			System.out.println("In default case");
			return "html/badLogin.html";
		}
	}
}
