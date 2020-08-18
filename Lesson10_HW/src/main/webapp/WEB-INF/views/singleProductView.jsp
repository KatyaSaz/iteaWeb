<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="/source/includes/header.jsp" %>
<script src="./source/scripts/jquery-3.5.1.js"></script>

<body>    
<center>
	<table id="productInfo" border="0">
	<tr><td width="210"><div class="title">${product.name}</div></td><td width="150"></td></tr>
	<tr><td><img width="210" height = "400" src="./source/images/${product.id}.jpg"></td><td><div class="info">${product.description}</div></td></tr>
	<tr><td><div class="price">${product.price} грн.</div></td><td>
	<div id="formPM">
		<input type="hidden" name="prodId" value="${product.id}"/>
			<img id="imgMinus" src="./source/images/minus.png" width="25" height = "25" onclick="minus(${product.id})"/>
			<input type="text" name = "amount" id="qnt${product.id}" value="1" size="2" />
			<img id="imgPlus" src="./source/images/plus.png" width="25" height = "25" onclick="plus(${product.id})"/>
		<input type="button" class="buyButton" value="Buy" onclick="show(${product.id})"/>
	</div>
	</td></tr>
	
	</table>
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