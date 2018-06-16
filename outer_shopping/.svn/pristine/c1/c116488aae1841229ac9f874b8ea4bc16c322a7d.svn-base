<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${sessionScope.userName}님의 마이페이지</title>
<style type="text/css">
form{
	display:inline
}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	    $("#showButton").click(function(){
	        $("#showDiv").show();
	        $("#showButton").hide();
	    });
	});        
</script>
</head>
<body>
<jsp:include page="../include/loginForm.jsp" flush="false"/><br>

	아이디 : ${memberVo.id }
	이름 : ${memberVo.name }
	이메일 : ${memberVo.email }
	핸드폰번호 : ${memberVo.phoneNum }
	우편번호 : ${memberVo.zipcode }
	주소 : ${memberVo.address }
	성별 : ${memberVo.sex }
	등급 : ${memberVo.grade }<br>
	<form id="modifyForm" name="modifyForm" action="${pageContext.request.contextPath}/member/modifyPage.do" method="post">
		<input type="hidden" id="id" name="id" value="${memberVo.id}">
		<input type="submit" id="modify" name="modify" value="수정하기">
	</form>
	<input type="button" id="showButton" name="showButton" value="탈퇴하기">
	<div id="showDiv" name="showDiv" style="display: none">
		<input type="text" id="pw" name="pw">
		<input type="button" id="delete" name="delete" value="탈퇴하기" onclick="delete_member();">
	</div>
	
</body>
</html>