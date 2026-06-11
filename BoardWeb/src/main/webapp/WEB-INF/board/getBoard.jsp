<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
	EL(Expression Language)이란?
	JSP 내장객(request, session)에 등록된 데이터에 접근하기위한 표현 언어
-->
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글등록</title>
</head>
<body>
<center>
<h1>게시글 등록</h1>
<form action="updateBoard.do" method="post">

<input name="seq" type="hidden" value="${board.seq }"/>

<table border="1" cellpadding="0" cellspacing="0" width="500">
<tr>
	<td bgcolor="orange" width="100">제목</td>
	<td><input name="title" type="text" value="${board.title }"/></td>
</tr>
<tr>
	<td bgcolor="orange" width="100">작성자</td>
	<td><input name="writer" type="text" value="${board.writer }" disabled="disabled"/></td>
</tr>
<tr>
	<td bgcolor="orange" width="100">내용</td>
	<td><textarea name="content" cols="50" rows="10">${board.content }</textarea></td>
</tr>
<tr>
	<td bgcolor="orange" width="100">등록일</td>
	<td><input name="regDate" type="text" value="${board.regDate }" disabled="disabled"/></td>
</tr>
<tr>
	<td bgcolor="orange" width="100">조회수</td>
	<td><input name="cnt" type="text" value="${board.cnt }" disabled="disabled"/></td>
</tr>
<tr>
	<td colspan="2" align="center"><input type="submit" value="글수정"/></td>
</tr>
</table>
</form>
<a href="insertBoardView.do">글등록</a>&nbsp;&nbsp;&nbsp;
<a href="deleteBoard.do?seq=${board.seq }">글삭제</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardListVi	ew.do">글목록</a>
</center>
</body>
</html>






