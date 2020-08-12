<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="/source/includes/header.jsp" %>

<body>    
<center>
	<c:forEach items="${products}" var="itms">	
	<table id="productInfo" border="0">
	<tr><td width="210"><a href="./prodInfo?itemId=${itms.id}"><div class="title">${itms.name}</div></td><td width="150"></a></td></tr>
	<tr><td><a href="./prodInfo?itemId=${itms.id}"><img width="210" height = "400" src="./source/images/${itms.id}.jpg"></a></td>
	<td><a href="./prodInfo?itemId=${itms.id}"><div class="info">${itms.description}</div></a></td></tr>
	<tr><td><a href="./prodInfo?itemId=${itms.id}"><div class="price">${itms.price} грн.</div></a></td><td>
	<form action="./cart" method="post">
		<input type="hidden" name="prodId" value="${itms.id}"/>
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