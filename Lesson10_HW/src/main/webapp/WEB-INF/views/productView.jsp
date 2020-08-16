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
	<td><a href="./prodInfo?itemId=${itms.id}"><div class="info">${itms.shortDescription}</div></a></td></tr>
	<tr><td><a href="./prodInfo?itemId=${itms.id}"><div class="price">${itms.price} грн.</div></a></td>
	<td>
	<form id="formPM" action="./cart" method="post">
		<input type="hidden" name="prodId" value="${itms.id}"/>
		<img id="imgMinus" src="./source/images/minus.png" width="25" height = "25" onclick="minus(${itms.id})"/>
		<input type="text" name = "amount" id="qnt${itms.id}" value="1" size="2" />
		<img id="imgPlus" src="./source/images/plus.png" width="25" height = "25" onclick="plus(${itms.id})"/>
		<input type="submit" class="buyButton" value="Buy" onclick="show(${itms.id})"/>
	</form>
	</td></tr>
	
	</table>
	<br/>
	<br/>
	
</c:forEach>
</center>
</body>

<%@include file="/source/includes/footer.jsp" %>


<script>
	function minus(numb){
		var qnt = document.getElementById("qnt"+numb);
		if(+qnt.value>=2){
			qnt.value = +qnt.value-1;
		}
	}
	
	function plus(numb){
		var qnt = document.getElementById("qnt"+numb);
		qnt.value = +qnt.value+1;
	}
	
	function show(numb){
		var qnt = document.getElementById("qnt"+numb);
		alert("id: "+numb+" quantity: "+qnt.value);
	}
</script>