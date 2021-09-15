<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
int num1 = 1;
int num2 = 100;
int sum = getSum(num1, num2);
%>

<%!
public int getSum(int num1, int num2){
	int sum = 0;
	for(int i = num1; i <= num2; i++){
		sum += i;
	}
	return sum;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP01</title>
</head>
<body>
<%-- JSP 주석 --%>
<!-- html 주석 -->
첫 번째 정수 : <%=num1 %><br/>
두 번째 정수 : <%=num2 %><br/>
누적합 : <%=sum %>
</body>
</html>
