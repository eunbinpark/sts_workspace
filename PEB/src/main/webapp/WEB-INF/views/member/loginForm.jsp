<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginForm</title>
<%
	// 로그인 실패 시에만 해당 메시지를 띄우도록 처리
	String message = (String) request.getAttribute("message");
	if (message != null && !message.isEmpty()) {
		out.println("<script>alert('" + message + "');</script>");
	}
%>
</head>
<body>
	<form action="login.do" method="post">
		<input type="text" name="id"> 
		<input type="password" name="pass"> 
		<input type="submit" name="" value="Login">
	</form>
</body>
</html>