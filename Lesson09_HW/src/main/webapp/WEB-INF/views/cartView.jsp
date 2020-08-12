<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="/source/includes/header.jsp" %>

<body>    
<center>
<c:set var="index" value="0"/>
	<c:forEach items="${sessionScope.cart}" var="itms">	
	
	<table id="cartInfo" border="0">
	<tr>
		<td width = "150"><a href="./prodInfo?itemId=${itms.id}"><img width="105" height = "200" src="./source/images/${itms.id}.jpg"></a></td>
		<td width = "350"><a href="./prodInfo?itemId=${itms.id}"><div class="info">${itms.name}</div></a></td>
		<td width = "150">
		<form action="#" method="post">
		<input type="hidden" name="deleteId" value="${index}"/>
		<input type="image" src="./source/images/delete.png" width="50" height = "50" alt="">
		</td>
		<c:set var="index" value="${index+1}"/>
	</form>
	</tr>
	</table>
	<br/>
	<br/>
	
</c:forEach>
</center>
</body>

<%@include file="/source/includes/footer.jsp" %>