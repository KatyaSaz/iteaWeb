
<%
String rowStr = request.getParameter("row");
String colStr = request.getParameter("col");
StringBuilder sbTable =new StringBuilder();
int numberOfCell = 1;
int row = 0;
int col = 0;
boolean isCorrect = true;
if(rowStr!=null && colStr!=null){
	
	try{
		row = Integer.valueOf(rowStr);
		col = Integer.valueOf(colStr);
	}catch(NumberFormatException e){
		sbTable.append("The input values must be numbers!<br>");
		isCorrect=false;
	}
	
	if(isCorrect){
		sbTable.append("<table border='1'>");
		for(int i=0; i<row; i++){
			sbTable.append("<tr>");
			for(int j=0; j<col; j++){
				if(i==j){
					sbTable.append("<td style='background:#00CED1; padding: 5px; text-align:center'>");
				}else{
					sbTable.append("<td style='padding: 5px; text-align:center'>");
				}
				sbTable.append(numberOfCell);
				numberOfCell++;
				sbTable.append("</td>");
			}
			sbTable.append("</tr>");
		}
		sbTable.append("</table>");
	}
}
%>
<center>
<form action="">
<table border="0">
	<tr><td>rows</td><td><input name="row" type="text"/></td></tr>
	<tr><td>columns</td><td><input name="col" type="text"/></td></tr>
	<tr><td></td><td align="right"><input value="build" type="submit"/></td></tr>
</table>
</form>
<%out.write(sbTable.toString());%>