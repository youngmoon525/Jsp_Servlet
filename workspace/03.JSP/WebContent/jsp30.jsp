<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP30</title>
</head>
<body>
<%--
//JAVA 변수를 선언 및 초기화 한 후, jsp31.jsp 넘기자 : 동적페이지전환 → forward()
String code = "abc001";
String name = "컴퓨터";
int price = 500000;

request.setAttribute("code", code);		//바인딩(연결) 객체
request.setAttribute("name", name);
request.setAttribute("price", price);
RequestDispatcher rd = request.getRequestDispatcher("jsp31.jsp");	//페이지 호출
rd.forward(request, response);	//동적 페이지 전환
--%>

<%-- JSTL core 변수를 선언 및 초기한 후, jsp31.jsp 넘기자 --%>
<c:set var="code" value="abc001" scope="request"/>
<c:set var="name" value="컴퓨터" scope="request"/>
<c:set var="price" value="500000" scope="request"/>
<jsp:forward page="jsp31.jsp"/>
</body>
</html>








