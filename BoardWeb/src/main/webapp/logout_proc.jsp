<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	System.out.println("session : " + session);

	// 로그아웃을 요청한 브라우저와 매핑된 세션을 강제 종료한다
	session.invalidate();
	
	// 메인 페이지(index.jsp)로 이동한다.
	response.sendRedirect("/");
%>