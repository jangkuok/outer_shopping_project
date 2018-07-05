<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
//login submit 
function loginCheck(){
	
	var error = document.getElementById('msg').value;
	var id = document.getElementById('loginId').value;
	var pw = document.getElementById('loginPw').value;

	if(id == ""){
        alert("아이디를 입력하세요.");
        $("#id").focus(); 
        return false; 
    }
    if(pw == ""){
        alert("비밀번호 입력하세요.");
        $("#id").focus();
        return false;
    }
    $("#loginForm").submit();
};
</script>
<body>
<c:if test="${!empty requestScope.error}">

		<script>
			var msg = request.getAttribute("msg");	
			alert(msg);
		</script>
</c:if>
	<form id="loginForm" name="loginForm" action="${pageContext.request.contextPath}/loginForm.do" method="post">
		아이디 : <input type="text" id="loginId" name="loginId"><br>
		패스워드 : <input type="password" id="loginPw" name="loginPw"><br>
		<input type="submit" id="login" name="login" value="로그인" onclick="loginCheck();" >
		<input type="button" value="홈으로" onclick="location='${pageContext.request.contextPath}/.do'">
	</form>
</body>
</html>