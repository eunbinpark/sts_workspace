<%@page import="bitedu.bipa.PEB.utils.DateService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Item</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#check').on('click',function(){
			let id = $('#title').val();
			alert(id);
			$.ajax({
				url : './checkID',
				type: 'post',
				data: {"id":id},
				success : function(data){
					alert(data);
					if(data=='false'){
						$('#message').text('사용할 수 있는 아이디입니다.')
					} else {
						$('#message').text('사용할 수 없는 아이디입니다.')
					}
					
				},
				error : function(){
					alert('fails');
				}
			});
		});
	});
</script>
</head>
<body>
<h3>게시글 작성</h3>

<form action="./write.do" method="post" enctype="application/x-www-form-urlencoded">
	<table>
		<tr><td>제목</td>
			<td>
				<input type="text" name="title" id="title">
				<!-- <input type="button" value="check" id="check"> -->
				<span id="message"></span>
			</td>
			<td></td></tr> <!-- text -->
		<tr><td>내용</td>
			<td><textarea cols="60" rows="5" name="content"></textarea></td>
		<td></td></tr> <!-- textarea -->
		<tr><td>작성자</td><td><input type="text" name="writer"></td><td></td></tr><!-- text -->
		<tr><td>작성일자</td>
			<td><input type="text" name="createDate" value="<%=DateService.getDateInfo(2)%>" readonly="readonly"></td>
		<td></td></tr><!-- text -->
		<!-- <tr><td>이미지첨부</td><td><input type="file" name="attacheImg"></td><td></td></tr> -->
		<!-- <tr><td>데이터첨부</td><td><input type="file" name="attacheData"></td><td></td></tr> -->
		<tr><td>비밀번호</td><td><input type="text" name="pass"></td><td></td></tr><!-- text -->
		<tr><td><input type="submit" value="작성"></td><td></td><td></td></tr><!-- submit -->
	</table>
</form>

</body>
</html>