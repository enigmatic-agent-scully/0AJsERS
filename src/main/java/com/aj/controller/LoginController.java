package com.aj.controller;

import javax.servlet.http.HttpServletRequest;

import com.aj.model.User;
import com.aj.service.UserServiceImpl;

public class LoginController {

	public static String login(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {
			System.out.println("returning login.change");
			return "html/login.html";
		}
		System.out.println("In login controller");
		UserServiceImpl usrSvc = new UserServiceImpl();
		
		//getting params
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username + " " + password);
		User foundUser = usrSvc.findByUnameAndPass(username, password);
		
		if(!(username.equals(foundUser.getUname())) && password.equals(foundUser.getPw())) {
			System.out.println("In bad login");
			return "badLogin.change";
		}
		else {
			//setting session attributes to be used throughout
			req.getSession().setAttribute("loggedinusername", username);
			req.getSession().setAttribute("loggedinpw", password);
			req.getSession().setAttribute("role", foundUser.getRole());
			req.getSession().setAttribute("u_id", foundUser.getU_id());
			System.out.println("login controller " + foundUser);
			//Returning home.home to go to HomeServlet, read role session attribute, and delegate
			//accordingly
			return "home.home";
		}
	}
}
