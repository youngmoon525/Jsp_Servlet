<%@page import="com.hanul.study.CalcDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");	//인코딩 설정
CalcDTO dto = (CalcDTO) request.getAttribute("dto");	//바인딩(연결) 객체를 받는다
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result JSP</title>
</head>
<body>
첫 번째 정수 : <%= dto.getNum1() %><br/>
두 번째 정수 : <%= dto.getNum2() %><br/>
누적합 : <%= dto.getSum() %>
</body>
</html>