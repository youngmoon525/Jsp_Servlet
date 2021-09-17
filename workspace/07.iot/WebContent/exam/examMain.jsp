<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>시험 보기</h3>
	<form action="grading" method="post">
	<!--펑션으로 문제 건수를 미리 뽑아놓음. 채점할때 사용하기 위한 숫자  fn:length(list)==list.size()-->
		<input type="hidden" id="totalcnt" name="totalcnt" value="${fn:length(list)}"/>
		<c:forEach items="${list}" var="vo">
			<p> ${vo.no} .번 </p>
			<p> ${vo.content}</p>
		<c:if test="${vo.exam_cnt eq 0 }">
			<input type="text" name="${vo.no}" id="${vo.no}"/>
		</c:if>
		<c:if test="${vo.exam_cnt ne 0 }">
			<c:forEach var="i" begin="1" end="${vo.exam_cnt }">
				<a>${i}</a><input type="radio" name="${vo.no}" id="${vo.no}" value="${i}"/>
			</c:forEach>
		</c:if>
		</c:forEach>
		<input type="submit" value="시험 완료">
	</form>
</body>
</html>