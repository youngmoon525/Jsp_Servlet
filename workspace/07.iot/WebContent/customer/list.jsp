<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

.page_on, .page_off {
	display: inline-block;
	line-height: 30px;
	margin: 0;
	min-width: 22px;
	padding: 0 5px 2px;
}

.page_on {
	border: 1px solid gray;
	background: gray;
	color: #fff;
	font-weight: bold;
}

select {
	height: 32px;
}

ul {
	list-style: none;
	padding: 0;
}

#list-top {
	padding: 20px 10%;
	height: 36px;
}

#list-top ul {
	margin: 0;
	display: flex;
}

#list-top ul li:not (:first-child ){
	margin-left: 3px;
}

#list-top ul li * {
	vertical-align: middle;
}

#list-top ul:first-child {
	float: left;
}

#list-top ul:last-child {
	float: right;
}
</style>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<h3 style="text-align: center; margin: 10px auto;">고객 목록</h3>
	${fn:length(page.list) }
	<form action="list.cu" method="post">
		<input type="hidden" name="curPage" value="1">
		<div id='list-top'>
			<ul>
				<li><select name=search>
						<option value="all" ${page.search eq 'all' ? 'selected' : ''}>전체</option>
						<option value="title" ${page.search eq 'title' ? 'selected' : ''}>제목</option>
						<option value="content"
							${page.search eq 'content' ? 'selected' : ''}>내용</option>
						<option value="writer"
							${page.search eq 'writer' ? 'selected' : ''}>작성자</option>
				</select></li>
				<li><input value="${page.keyword }" type="text" name="keyword"></li>
				<li><a class="btn-fill" onclick="$('form').submit();">검색 </a></li>
			</ul>
		</div>
	</form>
	<table>
		<tr>
			<th>고객ID(고유번호)</th>
			<th>고객명</th>
			<th>이메일</th>
		</tr>
		<c:forEach items="${page.list}" var="vo">
			<tr>
				<td><a href="detail.cu?id=${vo.id}"> ${vo.id } </a></td>
				<td><a href="detail.cu?id=${vo.id}"> ${vo.name } </a></td>
				<td><a href="detail.cu?id=${vo.id}"> ${vo.email } </a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="btnSet" style="text-align: center; margin: 10px auto;">
		<a class="btn-fill" href="new.cu">신규고객 추가</a>
	</div>
		<jsp:include page="/include/page.jsp"/>
	<%@ include file="/include/footer.jsp"%>
</body>
</html>