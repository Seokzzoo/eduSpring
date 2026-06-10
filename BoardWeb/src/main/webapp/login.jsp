<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>

<script type="text/javascript">
	// 폼이 제출(submit)될 때 실행될 함수
	function saveSession() {
		// 1. input 태그 중 name이 "id"인 요소의 입력값을 가져옵니다.
		var userId = document.getElementById("userId").value;
		
		// 2. 브라우저 세션 스토리지에 'userId'라는 키로 저장합니다.
		sessionStorage.setItem("userId", userId);
		
		// true를 반환해야 원래 목적인 login_proc.jsp로 데이터가 정상 전송됩니다.
		return true; 
	}
</script>
</head>
<body>
<center>
<h1>회원 로그인</h1>
<form action="login.do" method="post" onsubmit="return saveSession();">
<table border="1" cellpadding="0" cellspacing="0" width="300">
<tr>
	<td bgcolor="orange" width="100">아이디</td>
	<td><input name="id" id="userId" type="text"/></td>
</tr>
<tr>
	<td bgcolor="orange" width="100">비밀번호</td>
	<td><input name="password" type="password" value="test123"/></td>
</tr>
<tr>
	<td colspan="2" align="center"><input type="submit" value="로그인"/></td>
</tr>
</table>
</form>
</center>
</body>
</html>