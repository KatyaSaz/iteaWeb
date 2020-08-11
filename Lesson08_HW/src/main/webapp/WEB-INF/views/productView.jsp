<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="/source/includes/header.jsp" %>

<body>    
<center>
	<c:forEach items="${products}" var="itms">	
	<table id="productInfo" border="0">
	<tr><td width="210"><div class="title">${itms.name}</div></td><td width="150"></td></tr>
	<tr><td><img width="210" height = "400" src="./source/images/${itms.id}.jpg"></td><td><div class="info">${itms.description}</div></td></tr>
	<tr><td><div class="price">${itms.price} грн.</div></td><td>
	<form action="./cart" method="post">
		<input type="hidden" name="id" value="${itms.id}"/>
		<input type="submit" class="buyButton" value="Buy"/>
	</form>
	</td></tr>
	
	</table>
	<br/>
	<br/>
	
</c:forEach>
</center>
</body>

<%@include file="/source/includes/footer.jsp" %>