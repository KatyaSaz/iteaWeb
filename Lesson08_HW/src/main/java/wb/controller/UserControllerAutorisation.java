package wb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wb.model.User;
import wb.service.UserService;

public class UserControllerAutorisation extends HttpServlet {

	private static final String LOGIN_FORM = "WEB-INF/views/login.jsp";
	
	private String errorText = "";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(LOGIN_FORM);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(LOGIN_FORM);
		HttpSession session = req.getSession();

		String login = req.getParameter("login"); // by name = 'login'
		String password = req.getParameter("password");
		if (req.getParameter("logOut") != null) {
			session.setAttribute("userIn", null);
		} else {
			UserService userService = new UserService();
			User user = userService.getName(login, password);
			errorText = "";
			session.setAttribute("userIn", user);
			if (user == null) {
				errorText = "Login or Password isn't right!";
				req.setAttribute("errorText", errorText);
			}
		}
		rd.forward(req, resp);
	}
}
