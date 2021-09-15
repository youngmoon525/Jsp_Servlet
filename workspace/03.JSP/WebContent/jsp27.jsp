<%@page import="com.hanul.study.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//study[] 배열을 초기화 → 바인딩(연결) 객체 → jsp28.jsp 출력
String[] study = {"JAVA", "View", "SQL", "Servlet/JSP", "Android", "SPRING", "IoT", "Project"};
request.setAttribute("study", study);

//ArrayList<> 배열을 생성하고 초기화 → 바인딩(연결) 객체 → jsp28.jsp 출력
ArrayList<String> list = new ArrayList<>();
list.add("배");
list.add("사과");
list.add("딸기");
list.add("복숭아");
list.add("멜론");
list.add("체리");
list.add("자두");
request.setAttribute("list", list);

//MemberDTO 객체를 생성하고 초기화 → 바인딩(연결) 객체 → jsp28.jsp 출력
MemberDTO dto = new MemberDTO();
dto.setName("한울");
dto.setId("hanul");
dto.setPw("1234");
dto.setAge(33);
dto.setAddr("광주시 서구 경열로3");
dto.setTel("062-362-7797");
request.setAttribute("dto", dto);

//ArrayList<> 구조에 MemberDTO 객체배열을 생성 → 바인딩(연결) 객체 → jsp28.jsp 출력
ArrayList<MemberDTO> mlist = new ArrayList<>();
mlist.add(new MemberDTO("홍길동", "hong", "1234", 11 ,"광주시", "010-1111-1111"));
mlist.add(new MemberDTO("홍길동", "hong", "1234", 22 ,"광주시", "010-1111-1111"));
mlist.add(new MemberDTO("홍길동", "hong", "1234", 33 ,"광주시", "010-1111-1111"));
mlist.add(new MemberDTO("홍길동", "hong", "1234", 44 ,"광주시", "010-1111-1111"));
mlist.add(new MemberDTO("홍길동", "hong", "1234", 55 ,"광주시", "010-1111-1111"));
request.setAttribute("mlist", mlist);

//RequestDispatcher rd = request.getRequestDispatcher("jsp28.jsp");	//페이지 호출
//rd.forward(request, response);	//동적 페이지 전환
%>

<jsp:forward page="jsp28.jsp"/>
