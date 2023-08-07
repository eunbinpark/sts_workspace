<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입</title>
<style type="text/css">
	.memberForm{
		text-align: center;
	}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	let idCheckPass = false;
	
	function buttonClick(){
		$.ajax({
			url: "/tiles_final/id/idCheck.do?id="+$('#id').val(),
			method: 'get',
			success: function(data){
				console.log(data);
				if(data == "true"){
					$('#idChecking').text("중복 아이디가 존재합니다.");
					idCheckPass = false;
				}else{
					$('#idChecking').text("사용 가능한 아이디입니다.");
					idCheckPass = true;
				}
			}
		});
	}
	
	window.onload = function(){
		$('#submitButton').on('click', function(){
			if(idCheckPass && $('#id') && $('#name') && $('#pwd')){
				alert("회원가입이 완료되었습니다!");
				$('#frm').submit();
			}else{
				alert("모든 정보를 다 기입해주세요.");
			}
		});
	}
</script>
</head>
<body>
	<form action="./viewLogin.do" method="get" id="frm">
		 <table border=1>
		 	<tr><td>이름<input id="name" ></td><td></td><td></td></tr>
		 	<tr>
			 	<td>아이디<input id="id"></td>
			 	<td><button type="button" id="id" onclick="buttonClick()">아이디확인</button></td>
			 	<td><div id="idChecking"></div></td>
		 	</tr>
		 	<tr><td>비번<input id="pwd"></td><td></td><td></td></tr>
		 	<tr><td colspan="3"><input type="button" value="제출" id="submitButton"></td></tr></table>
		</form>
	</body>
</html>