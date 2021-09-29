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
</style>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<h3 style="text-align: center; margin: 10px auto;">게시판</h3>
	${fn:length(page.list) }
	<!-- form태그를 이용해서 검색조건과 검색어를 전송할수있는처리.  -->
	<form action="list.bo" method="post">
		<input type="hidden" name="curPage" value="1">
	</form>
	<c:if test="${page eq null }">
		<!-- ==  -->
		<a>비어있음</a>
	</c:if>
	<c:if test="${page ne null }">
		<!-- !=  -->
		<a>안비어있음</a>
	</c:if>

	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
		</tr>
		<c:forEach items="${page.list}" var="vo">
			<tr>
				<td>${vo.no }</td>
				<td>${vo.title}</td>
				<!--title누르면 a href=> detail  -->
				<td>${vo.writer}</td>
				<!-- vo에 필드 name을 추가하고 db에서 jsp_member join  -->
				<td>${vo.writedate }</td>
			</tr>
		</c:forEach>
	</table>
	<!--공통으로 사용할수있음 pageVO (common)   -->
	<!-- 글건수가많으면 처음 또는 블럭의 이전 처리를 기능  -->
	<div class="page_list" style="text-align: center;">
		<c:forEach begin="${page.beginPage}" end="${page.endPage}" var="no">
			<c:if test="${no eq page.curPage}">
				<span class="page_on">${no}</span>
			</c:if>
			<c:if test="${no ne page.curPage}">
				<span class="page_off" onclick="go_page(${no})">${no}</span>
			</c:if>
		</c:forEach>
	</div>
	<script type="text/javascript">
	function go_page(page) {
		$('[name=curPage]').val (page);
		$('form').submit();
	};
	</script>

	<!-- 글건수가많으면 마지막 또는 블럭의 다음 처리를 기능  -->

	<%@ include file="/include/footer.jsp"%>
</body>
</html>