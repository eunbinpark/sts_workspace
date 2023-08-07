<%@page import="bitedu.bipa.tiles.vo.BookCopy"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="bitedu.bipa.tiles.utils.DateService"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Item</title>
<script type="text/javascript">
	function goURL(type){
		//alert(type);
		let form = document.getElementById("frm");
		form.action = "./list.do";
		if(type==1){
			form.action = "./viewUpdateForm.do"
		} 
		form.submit();
	}
</script>
</head>
<body>
<h3>게시글 작성</h3>
<%
BookCopy temp = (BookCopy)request.getAttribute("board");
%>
<form action="./list.do" method="post" id="frm">
	<input type="hidden" name="seq" value="${board.seq}">
	<table>
		<tr><td>제목</td><td><input type="text" name="title" value="${board.title}" readonly="readonly"></td><td></td></tr> <!-- text -->
		<tr><td>내용</td>
			<td><textarea cols="80" rows="5" name="content" id="content" readonly="readonly">${board.content}</textarea></td>
		<td></td></tr> <!-- textarea -->
		<tr><td>작성자</td><td><input type="text" name="writer" value="${board.writer}" readonly="readonly"></td><td></td></tr><!-- text -->
		<tr><td>조회수</td><td><input type="text" name="readCount" value="${board.readCount}" readonly="readonly"></td><td></td></tr><!-- text -->
		<tr><td>작성일자</td>
			<td><input type="text" name="createDate" value="${board.createDate}" readonly="readonly"></td>
		<%-- <tr><td>이미지첨부</td><td><img src="/images/${board.attatchImg}"/></td><td></td></tr> --%><!-- text -->
		<!----><tr><td>데이터첨부</td><td>
		 <a href='./download.do?fileName=<%=URLEncoder.encode(temp.getAttatchData()==null?"":temp.getAttatchData(), "UTF-8")%>'>${board.attatchData}</a></td><td></td></tr><!-- text --> <%----%>
		<td></td></tr> 
		
		<tr>
			<td><input type="submit" value="확인" onclick="goURL(0)"></td>
		    <td><input type="submit" value="수정" onclick="goURL(1)"></td><td></td>
		</tr><!-- submit -->
	</table>
</form>

</body>
</html>





