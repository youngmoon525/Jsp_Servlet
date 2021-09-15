<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP14</title>
</head>
<body>
<div align="center">
<table border="1">
	<tr align="center">
		<td colspan="2" height="100">회사로고/네이게이션 메뉴</td>
	</tr>
	<tr align="center">
		<td height="300" width="30%">로그인이 들어갈 부분</td>
		<td>본문영역(Content)이 들어갈 부분</td>
	</tr>
	<tr align="center">
		<td colspan="2">
			<!-- 회사주소가 들어갈 부분(jsp13.jsp) -->
			<%@ include file="jsp13.jsp" %>
			<br/>
			<jsp:include page="jsp13.jsp"/>
		</td>
	</tr>
</table>
</div>
</body>
</html>