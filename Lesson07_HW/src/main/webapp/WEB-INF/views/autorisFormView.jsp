<%@ page isELIgnored = "false" %>
<%@include file="/source/includes/menu.jsp" %>

<body>
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
${errorText}
	</form>
	</body>
	</html>