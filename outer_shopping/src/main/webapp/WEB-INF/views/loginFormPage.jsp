<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="loginForm" name="loginForm" action="${pageContext.request.contextPath}/loginForm.do" method="post">
		아이디 : <input type="text" id="id" name="id"><br>
		패스워드 : <input type="text" id="pw" name="pw"><br>
		<input type="submit" id="login" name="login" value="로그인" onclick="loginCheck();" >
		<input type="button" value="홈으로" onclick="location='${pageContext.request.contextPath}/.do'">
	</form>
</body>
</html>