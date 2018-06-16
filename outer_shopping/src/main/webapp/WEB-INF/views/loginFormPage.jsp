<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="loginForm" name="loginForm" action="${pageContext.request.contextPath}/login.do" method="post">
		아이디 : <input type="text" id="id" name="id">
		패스워드 : <input type="text" id="pw" name="pw">
		<input type="submit" id="login" name="login" value="로그인" onclick="loginCheck();" >
	</form>
</body>
</html>