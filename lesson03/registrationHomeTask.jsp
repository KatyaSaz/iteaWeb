<%@ page import="java.util.regex.Matcher"%>
<%@ page import="java.util.regex.Pattern"%>

<%
boolean showForm = true;
boolean isError = false;
Pattern pattern = null;
Matcher matcher = null;
StringBuilder errorText = new StringBuilder();
errorText.append("<ul>");

String login = request.getParameter("login");
String password = request.getParameter("password");
String rePassword = request.getParameter("rePassword");
String name = request.getParameter("name");
String gender = request.getParameter("gender");
String address = request.getParameter("address");
String comment = request.getParameter("comment");
String agree = request.getParameter("agree");

if(login!=null){
	if(login.isEmpty()){
		errorText.append("<li>The 'login' is empty.</li>");
		isError = true;
	}else{
		pattern = Pattern.compile("^[\\w\\.-]+@[a-zA-Z0-9-]+\\.([a-z]{2}|com|org|net|edu|gov|info)$");
        matcher = pattern.matcher(login);
        if(!matcher.matches()){
			errorText.append("<li>The 'login' must be an email address.</li>");
			isError = true;
		}
	}
	if(password.isEmpty()){
		errorText.append("<li>The 'password' is empty.</li>");
		isError = true;
	}
	if(rePassword.isEmpty()){
		errorText.append("<li>The 'rePassword' is empty.</li>");
		isError = true;
	}else{
		if(!password.isEmpty()){
			if(!password.equals(rePassword)){
				errorText.append("<li>The 'password' and 'rePassword' must be the same.</li>");
				isError = true;
			}else{
				pattern = Pattern.compile("^(?=.*[A-Z])[a-zA-Z0-9]{8,}$");
				matcher = pattern.matcher(password);
				if(!matcher.matches()){
					errorText.append("<li>The 'password' must consist of numbers and letters<br>(at least one must be capital).<br>Length must be at least 8 characters long.</li>");
					isError = true;
				}
			}
		}
	}
	if(name.isEmpty()){
		errorText.append("<li>The 'name' is empty.</li>");
		isError = true;
	}
	if(gender.isEmpty()){
		errorText.append("<li>The 'gender' is empty.</li>");
		isError = true;
	}
	if(address.isEmpty()){
		errorText.append("<li>The 'address' is empty.</li>");
		isError = true;
	}
	if(comment.isEmpty()){
		errorText.append("<li>The 'comment' is empty.</li>");
		isError = true;
	}
	if(agree == null){
		errorText.append("<li>The 'agree' is empty.</li>");
		isError = true;
	}
	
	
	
	if(!isError){
	out.write("Registration sucsesfull!");
	showForm = false;
}
}
errorText.append("</ul>");

//out.write("login: "+login+"<br>"+"password: "+password+"<br>"+"rePassword: "+rePassword+"<br>"+"name: "+name+"<br>"+"gender: "+gender+"<br>"
//+"address: "+address+"<br>"+"comment: "+comment+"<br>"+"agree: "+agree+"<br>");

if(showForm){%>

<center>
<table>
<tr><td>
<form>
<table>
<tr><td>login: </td><td><input type="text" name="login" value="<%=(login!=null?login:"")%>"></td></tr>
<tr><td>password: </td><td><input type="password" name="password" value="<%=(password!=null?password:"")%>"></td></tr>
<tr><td>retype password: </td><td><input type="password" name="rePassword" value="<%=(rePassword!=null?rePassword:"")%>"></td></tr>
<tr><td>name: </td><td><input type="text" name="name" value="<%=(name!=null?name:"")%>"></td></tr>
<tr><td>gender: </td><td>M<input type="radio" name="gender" value="<%=(gender!=null && gender.equals("male")?"checked":"")%>">F<input type="radio" name="gender" value="<%=(gender!=null && gender.equals("female")?"checked":"")%>"></td></tr>
<tr><td>address: </td><td><select name ="address"><option value="<%=(address!=null && address.equals("lnr")?"selected":"")%>">LRN</option><option value="<%=(address!=null && address.equals("dnr")?"selected":"")%>">DNR</option><option value="<%=(address!=null && address.equals("crimea")?"selected":"")%>">Crimea</option></select></td></tr>
<tr><td>comment: </td><td><textarea name = "comment" cols = "15" rows="10" value="<%=(comment!=null?comment:"-")%>"></></textarea></td></tr>
<tr><td>I agree: </td><td><input type="checkbox" name = "agree"></td></tr>
<tr><td></td><td><input type="submit" value="send"></td></tr>
</table>
</form>
</td>
<td>
<%out.write(errorText.toString());%>
</td>
</tr>
</table>
<%}%>