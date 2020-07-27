<%@ page import="java.util.regex.Matcher"%>
<%@ page import="java.util.regex.Pattern"%>
<%@ page import="itea_lesson04_web.DBwork"%>
<%@include file="includes/menu.jsp" %>
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
	out.write("<br>Registration sucsesfull!");
	DBwork dbWork = new DBwork();
	dbWork.addNewUser(login, password, name, gender, address, comment);
	showForm = false;
}
}
errorText.append("</ul>");

//out.write("login: "+login+"<br>"+"password: "+password+"<br>"+"rePassword: "+rePassword+"<br>"+"name: "+name+"<br>"+"gender: "+gender+"<br>"
//+"address: "+address+"<br>"+"comment: "+comment+"<br>"+"agree: "+agree+"<br>");

if(showForm){%>
<body>
<form id="regForm" action="" method="post">
<div class="field">
		<label>Login:</label>
		<div class="input"><input type="text" name="login" value="<%=(login!=null?login:"")%>" id="log" /></div>
</div>
<div class="field">
		<label>Password:</label>
		<div class="input"><input type="password" name="password" value="<%=(password!=null?password:"")%>" id="pass" /></div>
</div>
<div class="field">
		<label>Retype Password:</label>
		<div class="input"><input type="password" name="rePassword" value="<%=(rePassword!=null?rePassword:"")%>" id="rePass" /></div>
</div>
<div class="field">
		<label>Name:</label>
		<div class="input"><input type="text" name="name" value="<%=(name!=null?name:"")%>" id="name" /></div>
</div>
<div class="radio">
		<label>Gender:</label>
		<input type="radio" id="male" name="gender" value="male"<%=(gender!=null && gender.equals("male")?"checked":"")%> />Male
		<input type="radio" id="female" name="gender" value="female"<%=(gender!=null && gender.equals("female")?"checked":"")%> />Female
		
</div>
<div class="select">
		<label>Address:</label>
		<select name="address" id="addr">
			<option value="lnr"<%=(address!=null && address.equals("lnr")?"selected":"")%>>LRN</option>
			<option value="dnr"<%=(address!=null && address.equals("dnr")?"selected":"")%>>DNR</option>
			<option value="crimea"<%=(address!=null && address.equals("crimea")?"selected":"")%>>Crimea</option>
		</select>
</div>
<div class="textarea">
		<label>Comment:</label>
		<textarea id="comment" name="comment" rows="5" cols="20" value="<%=(comment!=null?comment:"-")%>">
		</textarea>
</div>
<div class="submit">
		<button value="send" type="submit">Send</button>
		<label id="agree"><input name="agree" type="checkbox" value="" />I agree</label>
</div>
</form>
</body>
</html>
<%
out.write(errorText.toString());
}%>