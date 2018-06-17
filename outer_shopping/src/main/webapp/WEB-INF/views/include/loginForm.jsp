<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<style type="text/css">
form{
	display:inline
}
</style>
<script type="text/javascript">
//login submit 
function loginCheck(){
	
	var error = document.getElementById('msg').value;
	var id = document.getElementById('id').value;
	var pw = document.getElementById('pw').value;

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

//logout submit 
function logoutCheck(){
	if(confirm('로그아웃을 하시겠습니까?')){
        $("#logoutForm").submit();
    }
};

</script>
</head>
<body>
	<%
		String mg = (String)request.getAttribute("msg");
		System.out.println(mg);
	%>

<!-- 비로그인일 경우 -->
<sec:authorize access="!isAuthenticated()">
<c:if test="${!empty requestScope.error}">

		<script>
			var msg = request.getAttribute("msg");	
			alert(msg);
		</script>
</c:if>
<form id="loginForm" name="loginForm" action="${pageContext.request.contextPath}/loginForm.do" method="post">
	아이디 : 	<input type="text" id="id" name="id">
	패스워드 : <input type="text" id="pw" name="pw">
	<input type="submit" id="login" name="login" value="로그인" onclick="loginCheck();" >
	<input type="button" value="회원가입" onclick="location='${pageContext.request.contextPath}/joinPage.do'">
</form>
</sec:authorize>

<!-- 회원로그인할 경우 -->
<sec:authorize access="hasRole('ROLE_USER')">
	<sec:authentication property="principal.id"/>님이 환영합니다.        
	<form id="logoutForm" name="logoutForm" action="${pageContext.request.contextPath}/member/logoutButton.do" method="post">
		<input type="submit" id="logout" name="logout" value="로그아웃" onclick="logoutCheck();" >
	</form>
	<form id="myPage" name="myPage" action="${pageContext.request.contextPath}/member/myPage.do" method="post">
		<input type="hidden" id="id" name="id" value="${sessionScope.loginId}">
		<input type="submit" value="마이페이지">
	</form>
	<input type="button" value="홈으로" onclick="location='${pageContext.request.contextPath}/.do'">
</sec:authorize>
</body>
</html>