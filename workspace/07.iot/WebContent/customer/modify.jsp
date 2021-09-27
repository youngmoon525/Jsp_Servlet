<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 80%;
	margin: 0 auto;
	border: 1px solid;
	border-collapse: collapse;
}

table th, table td {
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
	<%@ include file="/include/header.jsp"%>
	<h3 style="text-align: center; margin: 10px auto;">[${vo.name }] 고객 정보 수정</h3>
	<form action="update.cu" method="post">
	<input type="hidden" name='id' value="${vo.id}">
		<table>
			<tr>
				<th>성명</th>
				<td><input type="text" name="name" value="${vo.name}"/></td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<label><input type="radio" ${vo.gender eq '남' ? 'checked' : '' }  name='gender' value="남"/>남 </label>
					<label><input type="radio" ${vo.gender eq '여' ? 'checked' : '' }   name='gender' value="여"/>여 </label>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email" value="${vo.email}"/></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="phone" value="${vo.phone}"/></td>
			</tr>
		</table>
	</form>
	<div class="btnSet" style="text-align: center; margin: 10px auto;" >
		<a class="btn-fill" onclick='$("form").submit()'>저장</a>
		<a class="btn-fill" href="list.cu">취소</a>
	</div>
	<%@ include file="/include/footer.jsp"%>
</body>
</html>