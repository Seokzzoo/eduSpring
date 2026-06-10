<%@page import="com.multicampus.biz.user.UserDAOJdbc"%>
<%@page import="com.multicampus.biz.user.UserDAO"%>
<%@page import="com.multicampus.biz.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 사용자 입력정보(id, password) 추출
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	// 2. DB 연동 처리
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO dao = new UserDAOJdbc();
	UserVO user = dao.getUser(vo);
	
	// 3. 화면 이동
	if (user != null) {
		System.out.println("로그인 성공!");
		response.sendRedirect("getBoardList.jsp");
	} else {
		System.out.println("로그인 실패!");
		response.sendRedirect("login.jsp");
	}
%>