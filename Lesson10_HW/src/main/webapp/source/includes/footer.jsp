<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
</div>
            
				<div id="sidebar">
					<table border=1>
                    <tr>
                    <td width="252" align="left">
                    <font color=white>
                    Вы авторизировались как 
<c:choose>
<c:when test = "${userIn!=null}">
					${userIn.name}
</c:when>
<c:otherwise>Guest</c:otherwise>
</c:choose>
					<br />
                    В вашей корзине ${fn:length(sessionScope.cart)} товаров.
                    </font>
                    </td>
                    </tr>
                    </table>
                    <h2>Боковое меню</h2>
					<ul>
						<li><a href="./products?catId=1">Детективы</a></li>
						<li><a href="./products?catId=2">Приключения</a></li>
						<li><a href="./products?catId=3">Фэнтези</a></li>
						<li><a href="./registration">Регистрация</a></li>
						<li><a href="./autorisation">Вход</a></li>
						<li><a href="./cart">Корзина</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="footer">
	<p>Copyright (c) by Сазонова Катерина</p>
</div>
<!-- end #footer -->
</body>
</html>
