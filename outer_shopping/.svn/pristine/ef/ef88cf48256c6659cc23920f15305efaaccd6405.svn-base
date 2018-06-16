<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.errMsg 
{ 
	font-size:1em; 
  	color:red;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수정하기</title>
</head>
<body>
<jsp:include page="../include/loginForm.jsp" flush="false"/><br>
		<form:form commandName="memberVo" id="modify" name="modify" method="post" action="${pageContext.request.contextPath}/member/modifyCheck.do">
			아이디 : 	<form:input id="id" name="id" path="id" size="25" readonly="true" value="${memberVo.id}" /><br>
			비밀번호 :  <form:password name="pw" path="pw" size="25" maxlength="20"/>
						<form:errors path="pw" cssClass="errMsg" /><br>
			이름 : 		<form:input name="name" path="name" size="25" maxlength="15" readonly="true" value="${memberVo.name}" />	
						<form:errors path="name" cssClass="errMsg" /><br>
			핸드폰번호 : <form:input name="phoneNum" path="phoneNum" size="25" maxlength="11" value="${memberVo.phoneNum}"/>
						<form:errors path="phoneNum" cssClass="errMsg"/><br>
			이메일 : 	<form:input name="email" path="email" size="25" value="${memberVo.email}"/>
						<form:errors name="email" path="email" cssClass="errMsg"/><br>
			주소 : 	<form:input id="zipcode" name="zipcode" path="zipcode" size="25" value="${memberVo.zipcode}"/>
					<form:input id="address" name="address" path="address" size="25" value="${memberVo.address}"/><br>	
			등급 : 	<form:input id="grade" name="grade" path="grade" size="25" readonly="true" value="${memberVo.grade}" />				
			<form:hidden id="sex" name="sex" path="sex" value="${memberVo.sex}"/>	
			<form:hidden id="enabled" name="enabled" path="enabled" value="1"/><br>	
		<input type="submit" id="modifyButton" name="modifyButton" value="수정">
		<input type="reset" id="reset" name="reset" value="초기화">
	</form:form>

</body>
</html>