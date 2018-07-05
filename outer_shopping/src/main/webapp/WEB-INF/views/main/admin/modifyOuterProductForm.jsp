<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
.textTrans{
	background-color:transparent;
	border:0 solid black;
}
</style>
<script type="text/javascript">
$(document).ready(function() {
	//이미지 삭제
	$('#delImage').click(function() {		
		var file = '<input type="file" id="imageFile" name="imageFile" value="사진등록" accept=".jpg, .jpeg, .png"/>';
		
		$('#imageName').remove();
		$('#delImage').remove();
		$('#imageTd').append(file);
		$('#outerVo').attr("enctype","multipart/form-data");
	});
	
	$("#modifyButton").on('click',function() {
		
		if($('#name').val() == '' || $('#name').val() == null){
			alert("상품이름을 입력하시오");
			return false;
		}
		if($('#price').val() == '' || $('#price').val() == null || $('#price').val() == '0'){
			alert("상품가격을 입력하시오");
			return false;
		}
		
		if($('#imageName').val() == '' || $('#imageName').val() == null){
			if($('#imageFile').val() == '' || $('#imageFile').val() == null){
				alert("상품이미지를 등록하시오");
				return false;
			}
		}
		if($('#content').val() == '' || $('#content').val() == null){
			alert("상품설명을 입력하시오");
			return false;
		}
		$('#outerVo').submit();
		
	});
});
</script>
</head>
<body>
	<form:form modelAttribute="outerVo" id="outerVo" name="outerVo"
		action="${pageContext.request.contextPath}/admin/modifyOuterProduct.do" method="post">	
		<input type="hidden" name="outerNo" id="outerNo" value="${outerVo.outerNo}"/>
		<input type="hidden" name="insertDate" id="insertDate" value="${outerVo.insertDate}"/>
		<input type="hidden" name="thumbnailUrl" id="thumbnailUrl" value="${outerVo.thumbnailUrl}"/>
		
		<table id="outerAdd" border="1" width="50%">
			<tr>
				<th width="20%">종류</th>
				<td width="80%">
					<select id="type" name="type">
						<option value="${outerVo.type}">${outerVo.type}</option>
						<option value="코트">코트</option>
						<option value="자켓">자켓</option>
						<option value="조끼">조끼</option>
						<option value="패딩">패딩</option>
					</select>
				</td>
			</tr>
			<tr> 
				<th>상품이름</th>
				<td>
					<input type="text" name="name" id="name" value="${outerVo.name}"/>
				</td>
			</tr>
			<tr>
				<th>가격</th>
				<td>
					<input type="number" name="price" id="price" value="${outerVo.price}"/>
				</td>
			</tr>
			<tr>
				<th>사진</th>
				<td id="imageTd">
					<input type="text" name="imageName" id="imageName" value="${outerVo.imageName}" readonly="readonly"/>
					<input type="button" id="delImage" name="delImage" value="이미지 삭제">
				</td>
			</tr>
			<tr>
				<th>상품 소개</th>
				<td>
					<textarea name="content" id="content" cols="50" rows="5">${outerVo.content}</textarea>
				</td>
			</tr>
		</table>
		<input type="button" id="modifyButton" name="modifyButton" value="수정하기">
	</form:form>
</body>
</html>