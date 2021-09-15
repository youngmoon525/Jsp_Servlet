<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%--
○ scope.jsp 페이지에서 생성한 바인딩(연결) 객체를 scopeUse.jsp 넘기자 : 공유범위 설정(Scope)
	- scope 내장객체(pageContext, request, session, application)를 이용하여 바인딩(연결) 객체를 생성
	- 형식 : 내장객체.setAttribute(name, value); → request.setAttribute();
	- name : 문자열(식별자), value : 공유객체(값) ▶ request.setAttribute("dto", dto);
--%>

<%
//바인딩(연결) 객체 생성 : setAttribute();
pageContext.setAttribute("pageContextName", "홍길동");
request.setAttribute("requestName", "JAVA");
session.setAttribute("sessionName", "Servlet/JSP");
application.setAttribute("applicationName", "Android");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scope JSP</title>
</head>
<body>
<%
//바인딩(연결) 객체를 받자 : getAttribute(); → Class Type, Casting
String pageContextName = (String) pageContext.getAttribute("pageContextName");
String requestName = (String) request.getAttribute("requestName");
String sessionName = (String) session.getAttribute("sessionName");
String applicationName = (String) application.getAttribute("applicationName");
%>
<ul>
	<li>pageContext : <%= pageContextName %></li>
	<li>request : <%= requestName %></li>
	<li>session : <%= sessionName %></li>
	<li>application : <%= applicationName %></li>
</ul>
<br/><br/>
<a href="scopeUse.jsp">Scope Use 페이지로 이동</a>
</body>
</html>
