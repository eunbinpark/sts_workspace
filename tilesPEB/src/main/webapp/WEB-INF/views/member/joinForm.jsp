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
			url: "/tilesPEB/member/idCheck.do?id="+$('#id').val(),
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
	
	function register() {
        // 회원가입 정보를 서버로 전송
        $.ajax({
            url: "/tilesPEB/member/register.do",
            method: 'get',
            data: {
                id: $('#id').val(),
                pass: $('#pass').val(),
                phone: $('#phone').val()
            },
            success: function(data) {
            	if(idCheckPass && $('#id') && $('#pass') && $('#phone')){
                    if (data === "true") {
                        alert("회원가입이 완료되었습니다!");
                        // 회원가입이 완료되었으므로 원하는 페이지로 이동하거나 필요한 작업을 수행할 수 있습니다.
                        // 예를 들어, 로그인 페이지로 이동하거나 메인 페이지로 리다이렉트할 수 있습니다.
                        window.location.href = "/tilesPEB";
                    } else {
                        alert("회원가입에 실패하였습니다. 모든 정보를 다 기입해주세요.");
                    }
    			}else{
    				alert("모든 정보를 다 기입해주세요.");
    			}
            },
            error: function() {
                alert("서버와의 통신에 실패하였습니다. 다시 시도해주세요.");
            }
        });
    }
</script>
</head>
<body>
	<form action="./viewRegist.do" method="get" id="frm">
		 <table border=1>
		 	<tr>
			 	<td>아이디<input id="id"></td>
			 	<td><button type="button" id="id" onclick="buttonClick()">아이디확인</button></td>
			 	<td><div id="idChecking"></div></td>
		 	</tr>
		 	<tr><td>비번<input id="pass"></td><td></td><td></td></tr>
		 	<tr><td>전화번호<input id="phone" ></td><td></td><td></td></tr>
		 	<tr><td colspan="3"><input type="button" value="제출" id="submitButton" onclick="register()"></td></tr></table>
		</form>
	</body>
</html>