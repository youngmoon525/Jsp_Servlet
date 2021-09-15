<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//jsp21.jsp에서 넘겨준 바인딩 객체(sum)를 받는다 : getAttribute();
//int sum = (int) request.getAttribute("sum");

//바인딩(연결) 객체는 Object Type → Class Type으로 받는다, Casting 필수
Integer sum = (Integer) request.getAttribute("sum");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP22</title>
</head>
<body>
○ JAVA 누적값 출력 : <%= sum %><br/>
○ EL 누적값 출력 : ${sum} 
</body>
</html>