<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
<h1>Update</h1>
<form action="./update.do" method="post">
	<input type="hidden" name="seq" value="${board.seq}">
	<table>
		<tr><td>제목</td><td><input type="text" name="title" value="${board.title}"></td><td></td></tr> <!-- text -->
		<tr><td>내용</td>
			<td><textarea cols="80" rows="5" name="content" id="content">${board.content}</textarea></td>
		<td></td></tr> <!-- textarea -->
		<tr><td>작성자</td><td><input type="text" name="writer" value="${board.writer}" readonly="readonly"></td><td></td></tr><!-- text -->
		<tr><td>작성일자</td>
			<td><input type="text" name="createDate" value="${board.createDate}" readonly="readonly"></td>
		<td></td></tr><!-- text -->
		<tr>
			<td></td>
		    <td><input type="submit" value="수정"></td><td></td>
		</tr><!-- submit -->
	</table>
</form>
</body>
</html>