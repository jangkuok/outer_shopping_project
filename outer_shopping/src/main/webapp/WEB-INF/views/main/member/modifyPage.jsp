<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- daum 우편번호 서비스 외장 JS(Javascript) 파일 링크 -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
// 도로명 주소 검색
    function getPostcodeAddress() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
 
                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수
 
                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;
 
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }
 
                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }
               
               // 주소 정보 전체 필드 및 내용 확인 : javateacher
               /*  var output = '';
                for (var key in data) {
                    output += key + ":" +  data[key]+"\n";
                }
               
                alert(output); */
 
                // 3단계 : 해당 필드들에 정보 입력
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('address').value = fullAddr;
 
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('address2').focus();
            }
        }).open();
    }
</script>    
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
<%-- <jsp:include page="../include/loginForm.jsp" flush="false"/><br> --%>
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
			우편번호 : 	<form:input id="zipcode" name="zipcode" path="zipcode" size="25" readonly="true" value="${memberVo.zipcode}"/>
			       		<input type="button" value="주소 검색" onClick="getPostcodeAddress()"><br>
			주소 :		<form:input id="address" name="address" path="address" size="25" readonly="true" value="${memberVo.address}"/><br>
			상세주소 :	<form:input id="address2" name="address2" path="address2" size="25" value="${memberVo.address2}"/><br>	
			등급 : 	<form:input id="grade" name="grade" path="grade" size="25" readonly="true" value="${memberVo.grade}" />				
			<form:hidden id="sex" name="sex" path="sex" value="${memberVo.sex}"/>	
			<form:hidden id="enabled" name="enabled" path="enabled" value="1"/><br>	
		<input type="submit" id="modifyButton" name="modifyButton" value="수정">
		<input type="reset" id="reset" name="reset" value="초기화">
	</form:form>

</body>
</html>