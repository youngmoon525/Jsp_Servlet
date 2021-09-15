<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gugudan02 JSP</title>
</head>
<body>
<div align="center">
<h3>[구구단 출력2]</h3>
<table border="1">
	<tr style="background-color: silver">
		<%for(int i = 2; i <= 9; i++){ %>
			<th><font color="red"><%=i%>단</font></th>
		<%} %>
	</tr>
	
	<%for(int i = 1; i <= 9; i++){ %>
		<%if(i % 2 == 0){ %>
			<tr align="center" style="background-color: pink">
		<%}else{ %>
			<tr align="center" style="background-color: yellow">		
		<%}//if %>
		
		<%for(int j = 2; j <= 9; j++){ %>
			<td>
				<%if(i * j < 10){ %>
					<%=j %> X <%=i %> = 0<%=i * j %>
				<%}else{ %>
					<%=j %> X <%=i %> = <%=i * j %>
				<%}//if %>
			</td>
		<%}//for j %>		
		</tr>
	<%}//for i %>
	
</table>
</div>
</body>
</html>