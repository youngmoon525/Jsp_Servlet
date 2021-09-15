<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP23</title>
</head>
<body>
<form action="jsp24.jsp" method="post">
이름 : <input type="text" name="name" required="required"/><br/>
<br/>
다음 중 회원님께서 키우고 싶은 애완동물을 선택하세요.<br/>
<input type="checkbox" name="animal" value="고양이"/>고양이<br/>
<input type="checkbox" name="animal" value="강아지"/>강아지<br/>
<input type="checkbox" name="animal" value="수달"/>수달<br/>
<input type="checkbox" name="animal" value="곰"/>곰<br/>
<input type="checkbox" name="animal" value="호랑이"/>호랑이<br/>
<input type="submit" value="전송하기"/>
</form>
</body>
</html>