package com.aj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aj.model.Expense;
import com.aj.model.User;
import com.aj.service.ExpServiceImpl;
import com.aj.service.ExpenseService;
import com.aj.service.UserService;
import com.aj.service.UserServiceImpl;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService usrSvc = new UserServiceImpl();
	ExpenseService expSvc = new ExpServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// check session role attribute to direct page appropriately
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (req.getSession().getAttribute("role").equals("admin")) {
			System.out.println("hit home serlvet, admin case");
			writeAdminHTML(res);
		} else {
			req.getRequestDispatcher(RequestHelper.process(req)).forward(req, res);
		}
	}

//Get expenses and users
	protected void writeAdminHTML(HttpServletResponse res) {
		try {
			PrintWriter out = res.getWriter();
			List<Expense> exps = expSvc.getAllExpenses();
			List<User> usrs = usrSvc.getAllUsers();
			String content = "";
			String headHtml = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Admin Home</title>\r\n" + "<link rel=\"stylesheet\"\r\n"
					+ "href=\"https://stackpath.bootstrapcdn.com" + "/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n"
					+ "integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/" + "1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n"
					+ "crossorigin=\"anonymous\">\r\n" + "<link rel=stylesheet type=\"text/css\" "
					+ "href=\"../css/style.css\">\r\n" + "\r\n" + "</head>";
			String openBody = "<body>\r\n" + "<div class=\"container\">\r\n" + "<div class=\"title\">\r\n"
					+ "<h3>Welcome Admin!</h3>\r\n" + "<h5>You are viewing all expenses in the system.</h5>" + "</div>"
					+ "<div class=\"form-group\">";
			String endWrapper = "</table>\r\n" + "</div>\r\n" + "</div>\r\n" + "<script src=\"https://code.jquery.com/"
					+ "jquery-3.3.1.slim.min.js\"\r\n" + "integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRV"
					+ "zpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\r\n" + "crossorigin=\"anonymous\"></script>\r\n"
					+ "<script\r\n" + "src=\"https://cdnjs.cloudflare.com/"
					+ "ajax/libs/popper.js/1.14.7/umd/popper.min.js\"\r\n"
					+ "integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9W" + "O1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\"\r\n"
					+ "crossorigin=\"anonymous\"></script>\r\n" + "<script\r\n"
					+ "src=\"https://stackpath.bootstrapcdn.com" + "/bootstrap/4.3.1/js/bootstrap.min.js\"\r\n"
					+ "integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6" + "VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\"\r\n"
					+ "crossorigin=\"anonymous\"></script>\r\n" + "</body>\r\n" + "</html>";
			String tableHeaders = "<table border=\"2\" " + "class=\"table\" id=\"reimbtable\">\r\n" + "<tr>\r\n"
					+ "<th>User Id</th>\r\n" + "<th>First Name</th>\r\n" + "<th>Last Name</th>\r\n"
					+ "<th>Type</th>\r\n" + "<th>Amount</th>\r\n" + "<th>Date submitted</th>\r\n"
					+ "<th>Date resolved</th>\r\n" + "<th>Status</th>\r\n" + "<th>Description</th>\r\n"
					+ "<th>Ticket Id</th></tr>";

			for (Expense e : exps) {
				String typeStr = null;
				String type = e.getType();

				switch (type) {
				case "1":
					typeStr = "Lodging";
					break;
				case "2":
					typeStr = "Travel";
					break;
				case "3":
					typeStr = "Food";
					break;
				case "4":
					typeStr = "Other";
				}

				for (User u : usrs) {
					if (e.getFk_e_id().equals(u.getU_id())) {
						User current = u;
						content += "<tr><td>" + e.getFk_e_id() + "</td><td>" + current.getFname() + "</td><td>"
								+ current.getLname() + "</td><td>" + typeStr + "</td><td>" + e.getAmount() + "</td><td>"
								+ e.getSubmitted() + "</td><td>" + e.getResolved() + "</td><td>" + e.getState()
								+ "</td><td>" + e.getDesc() + "</td><td>" + e.getExp_id() + "</td></tr>";
					}
				}
			}
			out.println(headHtml + openBody + tableHeaders + content + endWrapper);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
