<%@page import="com.hanul.study.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

//바인딩(연결) 객체를 받는다 : request.getAttribute() → Class Type, Casting
MemberDTO dto = (MemberDTO) request.getAttribute("dto");

//매개변수를 받는다 : request.getParameter() → PDT(기본데이터 타입), String Type
String ip = request.getParameter("ip");
%>

<jsp:useBean id="actionDTO" class="com.hanul.study.MemberDTO">
	<jsp:setProperty property="*" name="actionDTO"/>
</jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP12</title>
</head>
<body>
<h3>[JSP12]</h3>
<%-- getProperty Action Tag는 반드시 useBean Action Tag로 객체가 생성되어야만 사용 가능 --%>
이름(JAVA) : <%= dto.getName() %><br/>
이름(Action Tag) : <jsp:getProperty property="name" name="actionDTO"/><br/>
이름(Action Tag JAVA) : <%= actionDTO.getName() %><br/>
이름(EL) : ${dto.name }<br/>
이름(Action Tag EL) : ${actionDTO.name }<br/>
<br/><br/>
IP 주소(JAVA) : <%=ip %><br/>
IP 주소(EL) : ${param.ip }
</body>
</html>
