<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
      th, td {
      	text-align : center;
      }
      
    </style>
<title>Board List</title>
</head>
<body>
	<h1>Board List</h1>
	<a href="./viewWriteForm.do">게시물 작성</a>
	<input type="text" name="검색어" placeholder="검색어를 입력하세요">
	<a href="./searching.do"><input type="submit" value="검색" name=search></a>
        
	<br>
	<br>
	<br>
	<c:if test="${fn:length(list)>0}">
		<table>
			<tr>
				<th>순번</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>조회수</th>
				<!-- <th>이미지첨부</th> -->
				<!-- <th>데이터첨부</th> -->
				<th>삭제</th>
			</tr>
			<c:forEach var="board" items="${list}">
				<%----%>
				<c:if test="${board.seq < 25 or board.seq > 99}">
					<tr>
						<td>${board.seq}</td>
						<td><a href="./search.do?seq=${board.seq}">${board.title}</a></td>
						<td>${board.writer}</td>
						<td>${board.createDate}</td>
						<td>${board.readCount}</td><td><a href="./delete.do?seq=${board.seq}">삭제</a></td>
					</tr>
					<%-- --%>
				</c:if>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${fn:length(list)==0}">
	게시 정보가 없습니다.
</c:if>
</body>
</html>