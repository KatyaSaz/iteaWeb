<%@include file="/source/includes/header.jsp" %>
<%@ page isELIgnored = "false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<body>
<c:choose>
	<c:when test = "${userIn==null}">
	<form id="loginForm" action="./autorisation" method="post">
	<div class="field">
			<label>Enter your login:</label>
			<div class="input"><input type="text" name="login" value="" id="login" /></div>
	</div>
	<div class="field">
			<a href="#" id="forgot">Forgot your password?</a>
			<label>Enter your password:</label>
			<div class="input"><input type="password" name="password" value="" id="pass" /></div>
	</div>
	<div class="submit">
			<button value="send" type="submit">Enter</button>
			<label id="remember"><input name="" type="checkbox" value="" /> Remember me</label>
	</div>
	<div class="error">${errorText}</div>
	</form>
	</c:when>
	<c:otherwise>
<form id="logOutForm" action="./autorisation" method="post">
	<input type="hidden" name="logOut" value = "logOut"/>
	<div class="submit"><button value="Log Out" type="submit">Log Out</button></div>
</form>
	</c:otherwise>
</c:choose>
	</body>
<%@include file="/source/includes/footer.jsp" %>