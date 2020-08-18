<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="/source/includes/header.jsp" %>
<script src="./source/scripts/jquery-3.5.1.js"></script>

<body>    
<center>
	<c:forEach items="${sessionScope.cart}" var="itms">	
	
	<table id="cartInfo" border="0">
	<tr>
		<td width = "150"><a href="./prodInfo?itemId=${itms.key.id}"><img width="105" height = "200" src="./source/images/${itms.key.id}.jpg"></a></td>
		<td width = "350"><a href="./prodInfo?itemId=${itms.key.id}"><div class="info">${itms.key.name}</div></a></td>
		<td width = "300">
		<div id="formPM">
			<img id="imgMinus" src="./source/images/minus.png" width="25" height = "25" onclick="minus(${itms.key.id})"/>
			<input type="text" name = "amount" id="qnt${itms.key.id}" value="${itms.value}" size="2" />
			<img id="imgPlus" src="./source/images/plus.png" width="25" height = "25" onclick="plus(${itms.key.id})"/>
		</div>
		</td>
		<td width = "150">
	<form action="./cart" method="post">
		<input type="hidden" name="deleteId" value="${itms.key.id}"/>
		<input type="image" src="./source/images/delete.png" width="50" height = "50" alt="">
	</form>
	</td>
	</tr>
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
		
		$.ajax({
		url: './cart',
		type: 'POST',  // http method
		data: {prodId: numb, amount: qnt.value},  // data to submit
		success: function (data) {
			document.getElementById("amountField").innerHTML = data;
		}
});
	}
</script>