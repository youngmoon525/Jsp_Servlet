<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP04</title>
</head>
<body>
<%
//jsp03.jsp에서 넘겨준 바인딩(연결) 객체를 받는다 : request.getAttribute() ▶ 클래스 타입, Casting
Integer num1 = (Integer) request.getAttribute("num1");
Integer num2 = (Integer) request.getAttribute("num2");
Integer sum = (Integer) request.getAttribute("sum");
%>
첫 번째 정수 : <%=num1 %><br/>
두 번째 정수 : <%=num2 %><br/>
누적합 : <%=sum %>
</body>
</html>