<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������</title>
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
					$('#idChecking').text("�ߺ� ���̵� �����մϴ�.");
					idCheckPass = false;
				}else{
					$('#idChecking').text("��� ������ ���̵��Դϴ�.");
					idCheckPass = true;
				}
			}
		});
	}
	
	window.onload = function(){
		$('#submitButton').on('click', function(){
			if(idCheckPass && $('#id') && $('#name') && $('#pwd')){
				alert("ȸ�������� �Ϸ�Ǿ����ϴ�!");
				$('#frm').submit();
			}else{
				alert("��� ������ �� �������ּ���.");
			}
		});
	}
</script>
</head>
<body>
	<form action="./viewLogin.do" method="get" id="frm">
		 <table border=1>
		 	<tr><td>�̸�<input id="name" ></td><td></td><td></td></tr>
		 	<tr>
			 	<td>���̵�<input id="id"></td>
			 	<td><button type="button" id="id" onclick="buttonClick()">���̵�Ȯ��</button></td>
			 	<td><div id="idChecking"></div></td>
		 	</tr>
		 	<tr><td>���<input id="pwd"></td><td></td><td></td></tr>
		 	<tr><td colspan="3"><input type="button" value="����" id="submitButton"></td></tr></table>
		</form>
	</body>
</html>