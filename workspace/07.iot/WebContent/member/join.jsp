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
	<form action="iotjoin" method="post">
	<table>
		<tr>
			<th> *성명</th>
			<td><input type="text" name='name' ></td>
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
			<td><input type="password" name='pw' class="chk" >
				<div class="valid">비밀번호를 입력하세요(영문대/소문자,숫자를 모두 포함)</div>
			</td>
			
		</tr>
		<tr>
			<th> *비밀번호 확인</th>
			<td><input type="password" name='pw_chk' class="chk">
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
			<td><input type="text" name='email' class="chk">
				<div class="valid">이메일을 다시 입력하세요</div>
			</td>
		</tr>
	</table>
	</form>
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
		//중복확인 한 경우 : chked라는 클래스가 있음
		if( $ ('[name=id]').hasClass('chked')  ){
			if ( $('[name=id]').siblings('div').hasClass('invalid') ){
				alert('회원가입 불가!\n ' + join.id.unusable.desc );
				$('[name=id]').focus();
				return;
			}
		}else{
			//중복 확인을 하지 않은 경우
			if ( ! item_check ( $('[name=id]') )) return;
			else{
				alert ( join.id.valid.desc );
				$('[name=id]').focus();
				return;
			}
		}
		
		if ( ! item_check ( $('[name=pw]') )) return;
		if ( ! item_check ( $('[name=pw_chk]') )) return;
		if ( ! item_check ( $('[name=email]') )) return;
		
		//alert('회원가입이 가능한 상태가 되었다.');//===> submit;
		$('form').submit();
	}//go_join
	
	function item_check(tag) {
		var result = join.tag_status(tag);
		if ( result.code == 'invalid'){
			alert('회원가입 불가!\n' + result.desc);
			tag.focus();
			return false;
		}else{
			return true;
		}
		
	}
	
	$('.chk').on('keyup' , function (e) {
		if( $(this).attr('name') == 'id'){
			if(e.keyCode==13){
				id_check();
				return;
			}else{
				$(this).removeClass('chked');
			}
		}//if 아이디를 입력했을때 따로처리
			validate( $(this) );
		
	});
	
	
	$('#btn-id').on('click', function () {
		id_check();
	});
	function id_check() {
		/* id (inputType text name=id) 값을 가져옴. */
		var $id = $('[name=id]');
		if($id.hasClass('chked'))return;
		/* ajax 비동기 처리를 위한 통신(페이지 새로고침 x) */
		$.ajax({
			type : 'post',
			url : 'id_check',
			data: { id: $('input[name=id]').val() },
			success: function ( data ) {
				var bool = false;
				if(data == 'true'){
					data = join.id_usable(true);
					bool = true;
					/* display.status div를 이용해서 사용자가 상태를 볼수있는 펑션추가 */
				}else{
					data = join.id_usable(false);
					bool = false;
				}
				
				display_status($id.siblings('div') , data );
				$id.addClass('chked');
			},error: function (req , text) {
				alert(text + ' : ' + req.status );
			}
		});//ajax
	}
	
	/* 사용자가 상태를 볼수있게 하는 function  */
	function display_status(div , data) {
		div.text(data.desc);
		div.removeClass();
		div.addClass(data.code);
	}
	
	function validate( tag ) {
		var data = join.tag_status( tag );
		tag.siblings('div').text ( data.desc );
		tag.siblings('div').removeClass();
		tag.siblings('div').addClass(data.code);
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
			
			email:{
				valid: {code:'valid' , desc:'사용가능한 이메일입니다'}
				, invalid: {code:'invalid', desc:'사용 불가능한 이메일입니다.'}
			},
			
			pw:{
				valid: {code:'valid' , desc:'사용가능한 비밀번호'}
			,	invalid : {code:'invalid' , desc:'비밀번호는 영문 대/소문자,숫자만 입력가능'}
			,   lack    : {code: 'invalid' , desc:'비밀번호는 영문 대/소문자,숫자를 모두 포함 해야됩니다.' }
			,   equl    : {code: 'valid' , desc:'비밀번호가 일치 합니다.'}
			,  notequl  : {code: 'invalid' , desc:'비밀번호가 일치 하지 않습니다.'}
			},
			
			id_usable: function ( data ) {
				if(data) return this.id.usable;
				else return this.id.unusable;
			},
			tag_status: function ( tag ) {
				var data = tag.val();
				tag = tag.attr('name');
				if(tag == 'id'){
					return this.id_status ( data );/* id_status라는 function만들어서 그결과를 리턴만함  */
				}else if(tag == 'pw'){
					return this.pw_status ( data );
				}else if(tag == 'pw_chk'){
					return this.pw_chk_status(data);
				}else if(tag == 'email'){
					return this.email_status(data);
				}
			},
			id_status: function ( id ) {
				var reg = /[^a-z0-9]/g;	
				if ( id =='') return this.common.empty;
				else if ( id.match(space) ) return this.common.space;
				else if ( reg.test(id) ) return this.id.invalid;
				else if ( id.length < 5) return this.common.min;
				else if ( id.length > 10) return this.common.max;
				else return this.id.valid;
			},
			pw_status: function ( pw ) {
				var reg = /[^a-zA-Z0-9]/g;
				var upper = /[A-Z]/g , lower = /[a-z]/g , digit = /[0-9]/g;
				/*  사용자에게 어떤 값이 빠졌는지 알려주기 위한 변수 */
				if ( pw == '') return this.common.empty;
				else if ( pw.match(space) ) return this.common.space;
				else if ( reg.test(pw) ) return this.pw.invalid;
				else if ( pw.length < 5) return this.common.min;
				else if ( pw.length > 10) return this.common.max;
				else if (!upper.test(pw) || !lower.test(pw) || !digit.test(pw))
					return this.pw.lack;
				else
					return this.pw.valid;
			},
			pw_chk_status: function ( pw_chk ) {
				if ( pw_chk == '') return this.empty;
				else if ( pw_chk == $('[name=pw]').val() ) return this.pw.equl;
				else return this.pw.notequl;
			},
			email_status: function ( email ) {
				var reg = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
				if ( email == '') return this.common.empty;
				else if ( reg.test(email)) return this.email.valid;
				else return this.email.invalid;
			}
			
	}
	var space = /\s/g;
</script>
</body>
</html>