<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
ArrayList<String> list = new ArrayList<>();
list.add("배");
list.add("딸기");
list.add("체리");
list.add("복숭아");
list.add("멜론");
list.add("바나나");

//현재 페이지에서만 사용할 바인딩(연결) 객체 : EL 문법(표현식)에서 사용
pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP36</title>
</head>
<body>
○ JAVA 단순 for<br/>
<ul>
	<%
		for(int i = 0; i < list.size(); i++){
			out.println("<li>" + list.get(i) + "</li>");
		}
	%>
</ul>

○ JAVA 향상된 for<br/>
<ul>
	<%
		for(String str : list){
			out.println("<li>" + str + "</li>");
		}	
	%>	
</ul>

○ EL 문법(표현식)<br/>
<ul>
	<li>${list[0]}</li>
	<li>${list[1]}</li>
	<li>${list[2]}</li>
	<li>${list[3]}</li>
	<li>${list[4]}</li>
	<li>${list[5]}</li>
</ul>

○ JSTL core<br/>
<ul>
	<c:forEach var="i" items="${list}">
		<li>${i}</li>
	</c:forEach>
</ul>
</body>
</html>