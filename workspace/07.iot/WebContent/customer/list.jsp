<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

table{
		width: 80%;
		margin: 0 auto;
		border: 1px solid;
		border-collapse: collapse;
	}
	table th , table td{
		border: 1px solid;
		padding: 5px 10px;
	}
	a.btn-fill {
		text-align: center;
		padding: 3px 10px;
		border: 1px solid #3367d6;
		border-radius: 3px;
		box-shadow: 2px 2px 3px #022d72;
	}
</style>
</head>
<body>
<%@ include file="/include/header.jsp" %>
	<h3 style="text-align: center; margin: 10px auto;">고객 목록</h3>
	<table>
		<tr>
			<th>고객ID(고유번호)</th>
			<th>고객명</th>
			<th>이메일</th>
		</tr>
			<c:forEach items="${list}" var="vo">
		<tr>
			<td><a href="detail.cu?id=${vo.id}"> ${vo.id } </a></td>		
			<td><a href="detail.cu?id=${vo.id}"> ${vo.name } </a></td>		
			<td><a href="detail.cu?id=${vo.id}"> ${vo.email } </a></td>		
		</tr>
			</c:forEach>
	</table>
	<div class="btnSet" style="text-align: center; margin: 10px auto;" >
		<a class="btn-fill" href="new.cu">신규고객 추가</a>
	</div>
<%@ include file="/include/footer.jsp" %>
</body>
</html>