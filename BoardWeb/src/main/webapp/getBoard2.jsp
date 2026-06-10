<%@page import="com.multicampus.biz.board.BoardDAOJdbc"%>
<%@page import="com.multicampus.biz.board.BoardDAO"%>
<%@page import="com.multicampus.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 1. 사용자 입력정보 추출
	// String seq = request.getParameter("seq");
	
	// 2. DB 연동 처리
	// BoardVO vo = new BoardVO();
	// vo.setSeq(Integer.parseInt(seq));
	
	// BoardDAO dao = new BoardDAOJdbc();
	// BoardVO board = dao.getBoard(vo);
	
	// 3. 응답 화면(View) 구성
	
	// 1. 세션에 등록된 검색 결과를 꺼낸다.
	BoardVO board = (BoardVO) session.getAttribute("board");
%>  
    
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
<input name="seq" type="hidden" value="<%= board.getSeq() %>"/>
<table border="1" cellpadding="0" cellspacing="0" width="500">
<tr>
	<td bgcolor="orange" width="100">제목</td>
	<td><input name="title" type="text" value="<%= board.getTitle() %>"/></td>
</tr>
<tr>
	<td bgcolor="orange" width="100">작성자</td>
	<td><input name="writer" type="text" value="<%= board.getWriter() %>" disabled="disabled"/></td>
</tr>
<tr>
	<td bgcolor="orange" width="100">내용</td>
	<td><textarea name="content" cols="50" rows="10"><%= board.getContent() %></textarea></td>
</tr>
<tr>
	<td bgcolor="orange" width="100">등록일</td>
	<td><input name="regDate" type="text" value="<%= board.getRegDate() %>" disabled="disabled"/></td>
</tr>
<tr>
	<td bgcolor="orange" width="100">조회수</td>
	<td><input name="cnt" type="text" value="<%= board.getCnt() %>" disabled="disabled"/></td>
</tr>
<tr>
	<td colspan="2" align="center"><input type="submit" value="글수정"/></td>
</tr>
</table>
</form>
<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp; <!-- 글등록 페이지만 조회하면 되니깐 -->
<a href="deleteBoard.do?seq=<%= board.getSeq() %>">글삭제</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.do">글목록</a>
</center>
</body>
</html>