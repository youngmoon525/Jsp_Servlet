<%@page import="com.hanul.study.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
BookDAO dao = new BookDAO();
String json = dao.getBookListJson();
%>
<%=json %>