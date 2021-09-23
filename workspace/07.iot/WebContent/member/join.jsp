<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		width: 80%;
		margin: 0 auto;
		border: 1px solid;
		border-collapse: collapse;
	}
	table th , table td{
		border: 1px solid;
		padding: 5px 10px;
	}
	a.btn-fill {
		text-align: center;
		padding: 3px 10px;
		border: 1px solid #3367d6;
		border-radius: 3px;
		box-shadow: 2px 2px 3px #022d72;
	}
	.valid, .invalid { font-size: 13px; font-weight: bold;}
	.valid {color: green;}
	.invalid {color: red;}
</style>
</head>
<body>
<%@ include file="/include/header.jsp" %>

	<h3>[회원가입 페이지]</h3>
	<table>
		<tr>
			<th> *성명</th>
			<td><input type="text" name='name' class="chk"></td>
		</tr>
		<tr>
			<th> *아이디</th>
			<td><input type="text" name='id' class="chk"
				onkeypress=" if (event.keyCode==13){ id_check(); } ">
				<a class="btn-fill" id='btn-id'>아이디 중복 확인</a>
				<div class="valid">아이디를 입력하세요(영문소문자,숫자만 가능)</div>
			</td>
		</tr>
		<tr>
			<th> *비밀번호</th>
			<td><input type="password" name='pw'>
				<div class="valid">비밀번호를 입력하세요(영문대/소문자,숫자를 모두 포함)</div>
			</td>
			
		</tr>
		<tr>
			<th> *비밀번호 확인</th>
			<td><input type="password" name='pw_chk'>
				<div class="valid">비밀번호를 다시 입력하세요</div>
			
			</td>
		</tr>
		<tr>
			<th> *성별</th>
			<td>
			<label><input type="radio" name='gender' value="남" checked="checked">남</label>
			<label><input type="radio" name='gender' value="여">여</label>
			</td>
		</tr>
		<tr>
			<th> *이메일</th>
			<td><input type="text" name='email'>
				<div class="valid">이메일을 다시 입력하세요</div>
			</td>
		</tr>
	</table>
	<div class="btn_set">
	<a class='btn-fill' onclick="go_join()">회원가입</a>
	<a class="btn-fill" href='<c:url value="/" />'>취소</a>
	</div>
<%@ include file="/include/footer.jsp" %>

<script type="text/javascript">
	function go_join() {
		if($('[name=name]').val() == ''){
			alert('성명을 입력하세요!');
			$('[name=name]').focus();
		}
		
	}//go_join


	$('#btn-id').on('click', function () {
		id_check();
	});
	function id_check() {
		/* id (inputType text name=id) 값을 가져옴. */
		var $id = $('[name=id]');
		/* ajax 비동기 처리를 위한 통신(페이지 새로고침 x) */
		$.ajax({
			type : 'post',
			url : 'id_check',
			data: { id: $('input[name=id]').val() },
			success: function ( data ) {
				if(data == 'true'){
					alert('아이디 사용 가능 함');
				}else{
					alert('아이디 사용 불가능함!!');
				}
			},error: function (req , text) {
				alert(text + ' : ' + req.status );
			}
		});//ajax
	}
	/*================================================================  */
	var join = {
			/*공통사용  */
			common: {
				space: {code:'invalid' , desc:'공백없이 입력하세요.'}
				,empty: {code:'invalid' , desc:'입력을 하세요.'}
				,max : {code:'invalid' , desc:'최대 10자까지 입력가능합니다.'}
				,min : {code: 'invalid' ,desc:'최소 5글자 이상 입력해야됩니다.'}
			},
			id : {
				valid : {code:'valid' , desc:'아이디 중복확인을 해주세요.'}
				,invalid : {code:'invalid' , desc:'영문소문자,숫자만 입력하세요'}
				,usable : {code:'valid' , desc:'사용가능한 아이디입니다.'}
				,unusable : {code:'invalid' , desc:'이미 사용중인 아이디 입니다.'}
			},
			id_usable: function ( data ) {
				if(data) return this.id.unusable;
				else return this.id.usable;
			}
	}
</script>
</body>
</html>