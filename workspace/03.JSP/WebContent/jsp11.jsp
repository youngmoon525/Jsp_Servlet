<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="dto" class="com.hanul.study.MemberDTO">
	<jsp:setProperty property="*" name="dto"/>	
</jsp:useBean>

<%-- dto 객체를 jsp12.jsp로 넘겨서 출력 : 동적페이지 전환 ▶ forward() --%>
<%
String ip = request.getRemoteHost();	//클라이언트의 IP주소를 가져온다.
request.setAttribute("dto", dto);	//바인딩(연결) 객체
//RequestDispatcher rd = request.getRequestDispatcher("jsp12.jsp");	//페이지 호출
//rd.forward(request, response);		//페이지 전환
%>

<jsp:forward page="jsp12.jsp">
	<jsp:param value="<%=ip %>" name="ip"/>
</jsp:forward>

