<%@page import="com.hanul.study.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
MemberDTO dto = (MemberDTO) request.getAttribute("dto");
%>

<%-- dto 객체를 jsp19.jsp로 넘기자 : 동적페이지 전환 --%>
<%
request.setAttribute("dto", dto);
%>
<jsp:forward page="jsp19.jsp"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP18</title>
</head>
<body>
○ 이름 : <%=dto.getName() %>
</body>
</html>