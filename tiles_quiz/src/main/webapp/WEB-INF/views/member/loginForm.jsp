<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginForm</title>
</head>
<body>
<c:if test="${data != null}">
	<script>alert("${data}");</script>
</c:if>
<form action="login.do" method="post">
	<input type="text" name="id">
	<input type="password" name="pass">
	<input type="submit" name="" value="Login">
</form>
</body>
</html>