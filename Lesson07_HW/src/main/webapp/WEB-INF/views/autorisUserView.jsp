<%@ page isELIgnored = "false" %>
Hello, ${userIn.name}!
<form action="./autorisation" method="post">
	<input type="hidden" name="logOut" value = "logOut"/>
	<input type="submit" value="Log Out"/>
</form>