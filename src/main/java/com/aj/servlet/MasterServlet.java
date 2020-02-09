package com.aj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aj.servlet.RequestHelper;


public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In Master Servlet, get");

		request.getRequestDispatcher(RequestHelper.process(request)).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In Master Servlet, post");

		request.getRequestDispatcher(RequestHelper.process(request)).forward(request, response);
	}

}
