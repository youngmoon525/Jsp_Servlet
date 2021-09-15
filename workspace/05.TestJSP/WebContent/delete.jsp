<%@page import="com.hanul.study.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String isbn = request.getParameter("isbn");
BookDAO dao = new BookDAO();
int succ = dao.deleteBook(isbn);

if(succ > 0){
	out.println("<script>alert('도서정보 삭제성공!');");
	out.println("location.href='getAllList.jsp';</script>");
}else{
	out.println("<script>alert('도서정보 삭제실패!');");
	out.println("location.href='getAllList.jsp';</script>");
}
%>
