<%@ page isELIgnored = "false" %>
<%@include file="/source/includes/menu.jsp" %>

<body>
<form id="regForm" action="./reg" method="post">
<div class="field">
		<label>Login:</label>
		<div class="input"><input type="text" name="login" value="${user.login}" id="log" /></div>
</div>
<div class="field">
		<label>Password:</label>
		<div class="input"><input type="password" name="password" value="${user.password}" id="pass" /></div>
</div>
<div class="field">
		<label>Retype Password:</label>
		<div class="input"><input type="password" name="rePassword" value="${user.password}" id="rePass" /></div>
</div>
<div class="field">
		<label>Name:</label>
		<div class="input"><input type="text" name="name" value="${user.name}" id="name" /></div>
</div>
<div class="radio">
		<label>Gender:</label>
		<input type="radio" id="male" name="gender" value="male" ${user.cGenderMale} />Male
		<input type="radio" id="female" name="gender" value="female" ${user.cGenderFemale} />Female
		
</div>
<div class="select">
		<label>Address:</label>
		<select name="address" id="addr">
			<option value="lnr" ${user.cAddrLnr}>LRN</option>
			<option value="dnr" ${user.cAddrDnr}>DNR</option>
			<option value="crimea" ${user.cAddrCrimea}>Crimea</option>
		</select>
</div>
<div class="textarea">
		<label>Comment:</label>
		<textarea id="comment" name="comment" rows="5" cols="20" value="">${user.comment}
		</textarea>
</div>
<div class="submit">
		<button value="send" type="submit">Send</button>
		<label id="agree"><input name="agree" type="checkbox" value="" />I agree</label>
</div>
${errorText}
</form>
</body>
</html>