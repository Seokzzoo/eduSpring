<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예외 1</title>
</head>
<body>
<center>
<hr>
<h1><font color="green">java.lang.ArithmeticException</font> 발생!!!</h1>
<hr>
<h3>발생된 예외의 메시지 : <%= exception.getMessage() %></h3>
<a href="/">Main</a>페이지로 이동
</center>
</body>
</html>