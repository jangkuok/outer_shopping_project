<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${memberVo.name}님의 마이페이지</title>
<style type="text/css">
form{
	display:inline
}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
//삭제버튼(보이기.숨기기) jquery
$(document).ready(function(){
    $("#showButton").click(function(){
        $("#showDiv").show();
        $("#showButton").hide();
        $("#pw2").focus();
    });
});  

//새로고침 뒤로가기 방지 javascript
document.onkeydown = function(e){
    key = (e) ? e.keyCode : event.keyCode;
    if(key==8 || key==116){
       if(e){
          e.preventDefault();
       }
       else{
          event.keyCode = 0;
          event.returnValue = false;
       }
    }
};

//삭제 버튼 submit 
function delete_member(){
	if(confirm('회원탈퇴를 하시겠습니까?')){
    	$("#deleteForm").submit();
    }
};
</script>
</head>
<body>
<%-- <jsp:include page="../include/loginForm.jsp" flush="false"/><br> --%>
<c:if test="${msg == 'deleteError'}">
	<script>
		alert("비밀번호가 일치하지 않습니다.");
	</script>
</c:if>

	아이디 : ${memberVo.id }<br>
	이름 : ${memberVo.name }<br>
	이메일 : ${memberVo.email }<br>
	핸드폰번호 : ${memberVo.phoneNum }<br>
	주소 : ${memberVo.zipcode})${memberVo.address} ${memberVo.address2 }<br>
	등급 : ${memberVo.grade }<br>
	
	<form id="wishListForm" name="wishListForm" action="${pageContext.request.contextPath}/member/wishListSearch.do" method="post">
		<input type="hidden" id="id" name="id" value="${memberVo.id}">
		<input type="submit" id="wish" name="wish" value="관심상품">
	</form>
	<form id="orderListForm" name="orderListForm" action="${pageContext.request.contextPath}/member/orderListSearch.do" method="post">
		<input type="hidden" id="id" name="id" value="${memberVo.id}">
		<input type="submit" id="order" name="order" value="주문목록">
	</form>	
	<form id="modifyForm" name="modifyForm" action="${pageContext.request.contextPath}/member/modifyPage.do" method="post">
		<input type="hidden" id="id" name="id" value="${memberVo.id}">
		<input type="submit" id="modify" name="modify" value="수정하기">
	</form>
	<input type="button" id="showButton" name="showButton" value="탈퇴하기">
	<div id="showDiv" name="showDiv" style="display: none">
		<form id="deleteForm" name="deleteForm" action="${pageContext.request.contextPath}/member/deleteMember.do" method="post">
			<input type="hidden" id="id" name="id" value="${memberVo.id}">
			<input type="hidden" id="pw" name="pw" value="${memberVo.pw}">
			<input type="text" id="pw2" name="pw2">
			<input type="button" id="deleteButton" name="deleteButton" value="탈퇴하기" onclick="delete_member();">
		</form>
	</div>
</body>
</html>