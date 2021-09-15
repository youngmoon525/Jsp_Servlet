<%@page import="com.hanul.study.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
//System.out.println("ID : " + id);

MemberDAO dao = new MemberDAO();
int succ = dao.memberDelete(id);

if(succ > 0){
	out.println("<script>alert('삭제성공!');");
	out.println("location.href='jsp06.jsp';</script>");
}else{
	out.println("<script>alert('삭제실패!');");
	out.println("location.href='jsp06.jsp';</script>");
}
%>
