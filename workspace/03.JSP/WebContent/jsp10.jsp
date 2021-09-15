<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="dto" class="com.hanul.study.MemberDTO">
	<jsp:setProperty property="*" name="dto"/>
</jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP10</title>
</head>
<body>
<h3>[JAVA 코드를 이용한 출력]</h3>
이름 : <%=dto.getName() %><br/>
아이디 : <%=dto.getId() %><br/>
주소 : <%=dto.getAddr() %><br/>

<h3>[Action Tag를 이용한 출력]</h3>
이름 : <jsp:getProperty property="name" name="dto"/><br/>
아이디 : <jsp:getProperty property="id" name="dto"/><br/>
주소 : <jsp:getProperty property="addr" name="dto"/><br/>

<h3>[EL(Expression Language)을 이용한 출력]</h3>
이름 : ${dto.name }<br/>
아이디 : ${dto.id }<br/>
주소 : ${dto.addr }
</body>
</html>
