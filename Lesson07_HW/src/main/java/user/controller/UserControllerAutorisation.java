package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.User;
import user.service.DBwork;

public class UserControllerAutorisation extends HttpServlet {

	private String errorText = "";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/autorisFormView.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/autorisUserView.jsp");
		HttpSession session = req.getSession();
		
		if (req.getParameter("logOut") != null) {
			session.setAttribute("userIn", null);
		}
		
		if (session.getAttribute("userIn") == null) {
			String login = req.getParameter("login"); 	//by name = 'login'
			String password = req.getParameter("password");

			DBwork dbWorker = new DBwork();
			User user = dbWorker.getName(login, password);

			if (user == null) {
				if (req.getParameter("logOut") == null) {
					errorText = "Login or Password isn't right!";
					req.setAttribute("errorText", errorText);
				}
				rd = req.getRequestDispatcher("WEB-INF/views/autorisFormView.jsp");
			} else {
				req.setAttribute("user", user);
				session.setAttribute("userIn", user);
			}
		}
		rd.forward(req, resp);
		
	}
}
