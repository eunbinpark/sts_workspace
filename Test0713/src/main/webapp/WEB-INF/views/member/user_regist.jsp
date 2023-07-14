<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		table, td, th {
			border: 1px solid black;
			border-collapse: collapse;
			margin: 20px auto;
		}
		
		td {
			width: 150px;
			height: 50px;
			padding: 5px;
			font-size: 20px;
			/* text-align: center; */
		}
		
		input, select {
			font-size: 20px;
		}
		
		.data_ui {
			/* width: 250px; */
			height: 50px;
		}
		
		button {
			font-size: 15px;
			margin: 5px;
		}
		
		#footer {
			text-align: center;
		}
		
		input.poster :disabled {
			background: gray;
		}
		
		#form {
			font-size: 30px;
		}
		
		#message1, #message2, #message3 {
			color: red;
		}
	</style>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
	
			$('#btn_check_id').on('click',function(e){
	            let user_id = $('#user_id').val();
	            let alphaNumericRegex = /^[a-z0-9]{5,8}$/;
	            let message = "";
	            if(alphaNumericRegex.test(user_id)){
	                alert(user_id);
	                $.ajax({
	                    url : "/Test0713/memberController?cmd=checkId",
	                    type : 'get',
	                    data : {'user_id':user_id},
	                    success : function(data){
	                        let flag = JSON.parse(data).result;
	                        if(flag){
	                            $('#message1').html('사용할 수 없는 아이디입니다.');
	                        } else {
	                            $('#message1').html('사용할 수 있는 아이디입니다.');
	                        }
	                        $('#flag').val("true");
	                    },
	                    error : function(){
	                        alert('error');
	                    },
			
			let checkId = function(){
				return $('#flag').val();
			}
			
			
			let validateData = function(){
				let flag = false;
				if(checkId()=='true'){
					flag = true;
				} else {
					$('#message1').html('id가 비어있거나 형식에 맞지 않습니다.');
				}
				return flag;
			};
			
			let confirm = () => {
				let result = false;
				let p1 = $('#pwd1').val();
				let p2 = $('#pwd2').val();
				
				if(p1!=''>0&&p1==p2){
					result = true;
				} else {
					if(p1==''||p2==''){
						$('#message2').html("비번이 비어있습니다.");
					} else {
						$('#message2').html("비번이 일치하지 않습니다.");
					}
				}
				return result;
			};
			let count = function(){
				result = false;
				let select_count = 0;
				let selects = $('input[name=interests]');
				for(let i=0;i<selects.length;i++){
					if(selects[i].checked){
						select_count += 1;
					}
				}
				if(select_count==2 || select_count == 3){
					result = true;
				} else {
					$('#message3').html("2~3를 선택해야 합니다.");
				}
				return result;
			};
			
			$('#sending').on('click',function(e){
				let result = validateData();
				result = confirm() && result;
				result = count() && result;
				if(!result){
					e.preventDefault();
				}
			});
		});
	</script>
</head>
<body>
	<form action="/QuizSample/memberController?cmd=go_book_list"
		method="post">
		<table>
			<tr>
				<th colspan="4" id="form">회원가입양식</th>
			</tr>
			<tr>
				<th>구분</th>
				<th class="data_ui" colspan="1">데이터입력</th>
				<th>유효성검사</th>
				<th>비고</th>
			</tr>
			<tr>
				<td>아이디</td>
				<td colspan="1"><input type="text" id="user_id" name="user_id">
					<button id="btn_check_id">아이디확인</button></td>
				<td>5자리이상 , 첫글자 영문소문자</td>
				<td id="message1"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td colspan="1"><input type="password" id="pwd1" name="pwd"></td>
				<td rowspan="1">비밀번호 일치</td>
				<td id="message2"></td>
			</tr>
			<tr>
				<td>비번확인</td>
				<td colspan="1"><input type="text" id="pwd2"></td>
				<td id=""></td>
				<td id=""></td>
			</tr>
			<tr>
				<td>성별</td>
				<td colspan="1"><input type="radio" name="gender" value="M">남
					<input type="radio" name="gender" value="F" checked>여</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>관심분야</td>
				<td colspan="1"><input type="checkbox" name="interests"
					value="0">문학 <input type="checkbox" name="interests"
					value="1">어학 <input type="checkbox" name="interests"
					value="2" checked>정보IT<br> <input type="checkbox"
					name="interests" value="3">과학 <input type="checkbox"
					name="interests" value="4">수학 <input type="checkbox"
					name="interests" value="5">예술</td>
				<td>2~3개 사이 선택</td>
				<td id="message3"></td>
			</tr>
			<tr>
				<td>자기소개</td>
				<td colspan="1"><textarea cols="50" rows="5" name="introduce"></textarea></td>
				<td></td>
				<td></td>
			</tr>
			<tr id="footer">
				<td colspan="4"><input type="submit" value="가입" id="sending">
					<input type="reset"></td>
			</tr>
		</table>
		<input type="hidden" id="flag" value="false">
	</form>
</body>
</html>