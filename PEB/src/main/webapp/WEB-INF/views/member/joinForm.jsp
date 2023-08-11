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
			url: "/tilesPEB/member/idCheck.do?id="+$('#id').val(),
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
	
	function register() {
        // ȸ������ ������ ������ ����
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
                        alert("ȸ�������� �Ϸ�Ǿ����ϴ�!");
                        // ȸ�������� �Ϸ�Ǿ����Ƿ� ���ϴ� �������� �̵��ϰų� �ʿ��� �۾��� ������ �� �ֽ��ϴ�.
                        // ���� ���, �α��� �������� �̵��ϰų� ���� �������� �����̷�Ʈ�� �� �ֽ��ϴ�.
                        window.location.href = "/tilesPEB";
                    } else {
                        alert("ȸ�����Կ� �����Ͽ����ϴ�. ��� ������ �� �������ּ���.");
                    }
    			}else{
    				alert("��� ������ �� �������ּ���.");
    			}
            },
            error: function() {
                alert("�������� ��ſ� �����Ͽ����ϴ�. �ٽ� �õ����ּ���.");
            }
        });
    }
</script>
</head>
<body>
	<form action="./viewRegist.do" method="get" id="frm">
		 <table border=1>
		 	<tr>
			 	<td>���̵�<input id="id"></td>
			 	<td><button type="button" id="id" onclick="buttonClick()">���̵�Ȯ��</button></td>
			 	<td><div id="idChecking"></div></td>
		 	</tr>
		 	<tr><td>���<input id="pass"></td><td></td><td></td></tr>
		 	<tr><td>��ȭ��ȣ<input id="phone" ></td><td></td><td></td></tr>
		 	<tr><td colspan="3"><input type="button" value="����" id="submitButton" onclick="register()"></td></tr></table>
		</form>
	</body>
</html>