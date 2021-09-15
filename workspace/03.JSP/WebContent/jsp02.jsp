<%@page import="com.hanul.study.SumMachine"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
SumMachine sm = new SumMachine();
int num1 = 1;
int num2 = 100;
int sum = sm.getSum(num1, num2);

pageContext.setAttribute("num1", num1);	//현재 페이지에서 사용할 바인딩(연결) 객체를 생성
pageContext.setAttribute("num2", num2);	//EL 문법(표현식)에서 사용
pageContext.setAttribute("sum", sum);	//Scope 설정 : 공유범위
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP02</title>
</head>
<body>
첫 번째 정수 : <%=num1 %><br/>
두 번째 정수 : <%=num2 %><br/>
누적합 : <%=sum %>
<br/><br/>

첫 번째 정수 : ${num1 }<br/>
두 번째 정수 : ${num2 }<br/>
누적합 : ${sum }
</body>
</html>