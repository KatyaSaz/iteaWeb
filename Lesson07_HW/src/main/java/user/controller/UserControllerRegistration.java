package user.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.User;
import user.service.DBwork;

public class UserControllerRegistration extends HttpServlet {

	private final String CHECKED = "checked";
	private final String SELECTED = "selected";

	private StringBuilder resultError = null;
	private String[] genderChoice = { "", "" }; // [0] - male, [1] - female
	private String[] addressChoice = { "", "", "" }; // [0] - lnr, [1] - dnr, [2] - crimea

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/regisFormView.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd = null;
		Pattern pattern = null;
		Matcher matcher = null;
		boolean isError = false;
		User user = new User();

		resultError = new StringBuilder();
		resultError.append("");
		resultError.append("<ul>");

		String login = req.getParameter("login");
		String password = req.getParameter("password");
		String rePassword = req.getParameter("rePassword");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		String comment = req.getParameter("comment");
		String agree = req.getParameter("agree");

		if (login != null) {
			if (login.isEmpty()) {
				resultError.append("<li>The 'login' is empty.</li>");
				isError = true;
			} else {
				pattern = Pattern.compile("^[\\w\\.-]+@[a-zA-Z0-9-]+\\.([a-z]{2}|com|org|net|edu|gov|info)$");
				matcher = pattern.matcher(login);
				if (!matcher.matches()) {
					resultError.append("<li>The 'login' must be an email address.</li>");
					isError = true;
				} else {
					user.setLogin(login);
				}
			}
			if (password.isEmpty()) {
				resultError.append("<li>The 'password' is empty.</li>");
				isError = true;
			}
			if (rePassword.isEmpty()) {
				resultError.append("<li>The 'rePassword' is empty.</li>");
				isError = true;
			} else {
				if (!password.isEmpty()) {
					if (!password.equals(rePassword)) {
						resultError.append("<li>The 'password' and 'rePassword' must be the same.</li>");
						isError = true;
					} else {
						pattern = Pattern.compile("^(?=.*[A-Z])[a-zA-Z0-9]{8,}$");
						matcher = pattern.matcher(password);
						if (!matcher.matches()) {
							resultError.append(
									"<li>The 'password' must consist of numbers and letters<br>(at least one must be capital).<br>Length must be at least 8 characters long.</li>");
							isError = true;
						} else {
							user.setPassword(password);
						}
					}
				}
			}
			if (name.isEmpty()) {
				resultError.append("<li>The 'name' is empty.</li>");
				isError = true;
			} else {
				user.setName(name);
			}
			if (gender.isEmpty()) {
				resultError.append("<li>The 'gender' is empty.</li>");
				isError = true;
			} else {
				user.setGender(gender);
				if (gender.equals("male")) {
					genderChoice[0] = CHECKED;
				}
				if (gender.equals("female")) {
					genderChoice[1] = CHECKED;
				}
			}
			if (address.isEmpty()) {
				resultError.append("<li>The 'address' is empty.</li>");
				isError = true;
			} else {
				user.setAddress(address);
				if (address.equals("lnr")) {
					addressChoice[0] = SELECTED;
				}
				if (address.equals("dnr")) {
					addressChoice[1] = SELECTED;
				}
				if (address.equals("crimea")) {
					addressChoice[2] = SELECTED;
				}
			}
			if (comment.isEmpty()) {
				resultError.append("<li>The 'comment' is empty.</li>");
				isError = true;
			} else {
				user.setComment(comment);
			}
			if (agree == null) {
				resultError.append("<li>The 'agree' is empty.</li>");
				isError = true;
			}
			resultError.append("</ul>");
			req.setAttribute("user", user);
			req.setAttribute("genderChoice", genderChoice);
			req.setAttribute("addressChoice", addressChoice);

			if (isError) {
				req.setAttribute("errorText", resultError.toString());
				rd = req.getRequestDispatcher("WEB-INF/views/regisFormView.jsp");
			} else {
				DBwork dbWork = new DBwork();
				dbWork.addNewUser(user);
				rd = req.getRequestDispatcher("WEB-INF/views/regisUserView.jsp");
			}
			rd.forward(req, resp);
		}
	}
}
