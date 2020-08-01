package hw.lesson05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {

	private final String HTML_START = "<!doctype html><html lang=\"en\">";
	private final String HTML_END = "</html>";
	private final String CHECKED = "checked";
	private final String SELECTED = "selected";
	
	private String loginCheck = "";
	private String passwordCheck = "";
	private String rePassCheck = "";
	private String nameCheck = "";
	private String genderFemale = "";
	private String genderMale = "";
	private String addressLnr = "";
	private String addressDnr = "";
	private String addressCrimea = "";
	private String commentCheck = "";
	
	private StringBuilder result = new StringBuilder();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String REG_FORM = "<form action='' method='post'><table><tr><td>login: </td><td><input type='text' name='login' value='"+loginCheck+"'></td></tr>"
				+ "<tr><td>password: </td><td><input type='password' name='password' value='"+passwordCheck+"'></td></tr>"
				+ "<tr><td>retype password: </td><td><input type='password' name='rePassword' value='"+rePassCheck+"'></td></tr>"
				+ "<tr><td>name: </td><td><input type='text' name='name' value='"+nameCheck+"'></td></tr>"
				+ "<tr><td>gender: </td><td>M<input type='radio' name='gender' value='male' "+genderMale+">"
				+ "F<input type='radio' name='gender' value='female' "+genderFemale+"></td></tr>"
				+ "<tr><td>address: </td><td><select name ='address'><option value='lnr' "+addressLnr+">"
				+ "LRN</option><option value='dnr' "+addressDnr+">DNR</option><option value='crimea' "+addressCrimea+">Crimea</option></select></td></tr>"
				+ "<tr><td>comment: </td><td><textarea name = 'comment' cols = '15' rows='10' value=''>"+commentCheck+"</textarea></td></tr>"
				+ "<tr><td>I agree: </td><td><input type='checkbox' name = 'agree'></td></tr>"
				+ "<tr><td></td><td><input type='submit' value='send'></td></tr></table></form></td><td>";
		PrintWriter out = resp.getWriter();
		out.write(HTML_START);
		out.write("<center><table><tr><td>");
		out.write(REG_FORM);
		out.write("</td></tr></table>");
		out.write(HTML_END);		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pattern pattern = null;
		Matcher matcher = null;
		boolean isError = false;
		result = new StringBuilder();
		PrintWriter out = resp.getWriter();
		result.append("");

		result.append("<ul>");

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
				result.append("<li>The 'login' is empty.</li>");
				isError = true;
			} else {
				pattern = Pattern.compile("^[\\w\\.-]+@[a-zA-Z0-9-]+\\.([a-z]{2}|com|org|net|edu|gov|info)$");
				matcher = pattern.matcher(login);
				if (!matcher.matches()) {
					result.append("<li>The 'login' must be an email address.</li>");
					isError = true;
				} else {
					loginCheck = login;
				}
			}
			if (password.isEmpty()) {
				result.append("<li>The 'password' is empty.</li>");
				isError = true;
			} 
			if (rePassword.isEmpty()) {
				result.append("<li>The 'rePassword' is empty.</li>");
				isError = true;
			} else {
				if (!password.isEmpty()) {
					if (!password.equals(rePassword)) {
						result.append("<li>The 'password' and 'rePassword' must be the same.</li>");
						isError = true;
					} else {
						pattern = Pattern.compile("^(?=.*[A-Z])[a-zA-Z0-9]{8,}$");
						matcher = pattern.matcher(password);
						if (!matcher.matches()) {
							result.append(
									"<li>The 'password' must consist of numbers and letters<br>(at least one must be capital).<br>Length must be at least 8 characters long.</li>");
							isError = true;
						} else {
							passwordCheck = password;
							rePassCheck = rePassword;
						}
					}
				}
			}
			if (name.isEmpty()) {
				result.append("<li>The 'name' is empty.</li>");
				isError = true;
			}else {
				nameCheck = name;
			}
			if (gender.isEmpty()) {
				result.append("<li>The 'gender' is empty.</li>");
				isError = true;
			}else {
				if(gender.equals("male")) {
					genderMale = CHECKED;
				}
				if(gender.equals("female")) {
					genderFemale = CHECKED;
				}
			}
			if (address.isEmpty()) {
				result.append("<li>The 'address' is empty.</li>");
				isError = true;
			}else {
				if(address.equals("lnr")) {
					addressLnr = SELECTED;
				}
				if(address.equals("dnr")) {
					addressDnr = SELECTED;
				}
				if(address.equals("crimea")) {
					addressCrimea = SELECTED;
				}
			}
			if (comment.isEmpty()) {
				result.append("<li>The 'comment' is empty.</li>");
				isError = true;
			}else {
				commentCheck = comment;
			}
			if (agree == null) {
				result.append("<li>The 'agree' is empty.</li>");
				isError = true;
			}
			result.append("</ul>");

			if (isError) {
				doGet(req, resp);
				
			}else {
				result.delete(0, result.length());
				result.append(HTML_START);
				result.append("<br>Registration successfull!");
				result.append(HTML_END);				
			}
			out.write(result.toString());
		}
	}
}
