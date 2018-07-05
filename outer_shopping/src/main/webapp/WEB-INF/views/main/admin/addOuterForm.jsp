<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html lang="ko-kr">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
 $(document).ready(function() {
	$('div[name="sizeTable"]').hide();
	$('#imageAddTable').hide();
	//상품등록
	$("#addButton").click(function() {
		
			var outerVo = new FormData($("#outerVo")[0]);
			
			$.ajax
			({		
				"url":"${pageContext.request.contextPath}/admin/addOuterProduct.do", 
				"type":"POST",
				"data": outerVo,
				"contentType": false,
				"processData": false,
				"beforeSend":function()
				{
					
					if($('#type').val() == '선택하세요'){
						alert("상품종류를 선택하시오");
						return false;
					}
					if($('#name').val() == '' || $('#name').val() == null){
						alert("상품이름을 입력하시오");
						return false;
					}
					if($('#price').val() == '' || $('#price').val() == null || $('#price').val() == '0'){
						alert("상품가격을 입력하시오");
						return false;
					}
					if($('#imageFile').val() == '' || $('#imageFile').val() == null){
						alert("상품이미지를 등록하시오");
						return false;
					}
					if($('#content').val() == '' || $('#content').val() == null){
						alert("상품설명을 입력하시오");
						return false;
					}
				},
				"success":function(data)
				{
					if(confirm('등록 하시겠습니까?')) { 
						$('div[name="sizeTable"]').show();
						$('#sizeMinusButton').hide();
						$('#outerAdd').find('input').attr("readonly","readonly");
						$('#outerAdd').find('textArea').attr("readonly","readonly");
						$('#addB').hide();
						$('input[name="outerNo"]').val(data);
				    }else { 
				    	return;
				   	}
				}
			});
	});
	
	var index = 2;
	
	//상품size 추가
	$("#sizePlusButton").click(function() {
		var size = '<tr><td><select id ="type_'+index+'" name="type"><option value="선택하세요">선택하세요</option><option value="S">S</option>'+
		'<option value="M">M</option><option value="L">L</option><option value="XL">XL</option><option value="FREE">FREE</option></select>'+
		'<input type="hidden" id="typeHidden_'+index+'" name="productSize" value=""></td>'+
		'<td><input type="number" id="chest'+index+'" name="productSize" size="3"></td>'+
		'<td><input type="number" id="sleeve'+index+'" name="productSize" size="3"></td>'+
		'<td><input type="number" id="shoulder'+index+'" name="productSize" size="3"></td>'+
		'<td><input type="number" id="whole'+index+'" name="productSize" size="3"></td>'+											
		'<td><input type="number" id="amount'+index+'" name="productSize" value=""></td>'+
		'<td><select id ="color_'+index+'" name="color"><option value="선택하세요">선택하세요</option>'+
		'<option style="background-color:black;color:white" value="블랙">블랙</option>'+
		'<option style="background-color:white" value="화이트">화이트</option>'+
		'<option style="background-color:red;color:white" value="레드">레드</option>'+
		'<option style="background-color:#08088A;color:white" value="네이비">네이비</option>'+
		'<option style="background-color:#2E2E2E;color:white" value="차콜">차콜</option>'+
		'<input type="hidden" id="colorHidden_'+index+'" name="productSize" value=""></select></td></tr>'	
		
		index++;
		
		$('#sizeMinusButton').show();
		$('#sizeTable tbody').append(size);	
	});
	
	//사이즈 이벤트
	$(document).on('change','select[id^=type_]',function(e) {
		
		var no = e.target.id.substring(5);
		
		$('#typeHidden_'+no).val($(this).val());
		
		if($('#type_'+no).val() == "S"){			
			$('#chest'+no).val('53');
			$('#sleeve'+no).val('20');
			$('#shoulder'+no).val('44');
			$('#whole'+no).val('67');
		}
		if($('#type_'+no).val() == "M"){
			$('#chest'+no).val('55');
			$('#sleeve'+no).val('22');
			$('#shoulder'+no).val('46');
			$('#whole'+no).val('69');
		}
		if($('#type_'+no).val() == "L"){
			$('#chest'+no).val('57');
			$('#sleeve'+no).val('24');
			$('#shoulder'+no).val('48');
			$('#whole'+no).val('71');
		}
		if($('#type_'+no).val() == "XL"){
			$('#chest'+no).val('61');
			$('#sleeve'+no).val('28');
			$('#shoulder'+no).val('52');
			$('#whole'+no).val('75');
		}
		if($(this).val() == "FREE"){
			$('#chest'+no).val('64');
			$('#sleeve'+no).val('55');
			$('#shoulder'+no).val('60');
			$('#whole'+no).val('74');
		}
	});
	
	//색상 이벤트
	
	$(document).on('change','select[id^=color_]',function(e) {
		var no = e.target.id.substring(6);
		$('#colorHidden_'+no).val($(this).val());
	});
	
	
	//상품size 삭제
	$("#sizeMinusButton").on('click',function() {	
		if($('#sizeTable tbody tr').length == 1){
			$('#sizeMinusButton').hide();
		}else{
			$("#sizeTable tr:last").remove();		
		}
		
	});
	
	//상품size 등록
	$("#addSizeButton").on('click',function() {	
		var sizeArr = []; 
		
		//테이블 행의 모든 값 가져오기
		$('input[name="productSize"]').each(function(){   	
 			var s = $(this).val();
			sizeArr.push(s);
		});	
		alert(sizeArr);
 		
		$.ajax
		({		
			"url":"${pageContext.request.contextPath}/admin/addOuterSize.do", 
			"type":"POST",
			"data": {"sizeList": sizeArr, "outerNo": $('#outerNo').val()},
			"dataType":"text",
			"beforeSend":function()
			{
				$('input[name="productSize"]').each(function(){   	
		 			if($(this).val() == "" || $(this).val() == null || $(this).val() == '0' || $(this).val() == '선택하세요'){
		 				alert("사이즈 입력을 해주세요");
		 				return false;
		 			};
					
				});	
			},
			"success":function(data)
			{
				if(confirm('등록 하시겠습니까?')) { 
					$('#imageAddTable').show();
					$('#imageMinusButton').hide();
			    }else { 
			    	return;
			   	}
			}
		});
		
	});
	
	var count = 1;
	
	//이미지 추가
	$("#imagePlusButton").click(function() {
		var image = '<tr><td><input type="file" name="imageFiles['+count+']" value="사진등록" accept=".jpg, .jpeg, .png"/>'+
		'</td></tr>';	
		$('#imageTable tbody').append(image);
		count++;
		$('#imageMinusButton').show();
	});
	
	//이미지 삭제
	$("#imageMinusButton").on('click',function() {	
		if($('#imageTable tbody tr').length == 2){
			$('#imageMinusButton').hide();
		}else{
			$("#imageTable tr:last").remove();	
			count--;
		}
	});
	
	$("#addPicture").on('click',function() {
		
		$('input[name="imageFiles"]').each(function(){
			if($(this).val() == '' || $(this).val() == null){
				alert("상품이미지를 등록하시오");
				return false;
			}
		});
		
		if(confirm('등록 하시겠습니까?')) { 
			$('#outerPictureVo').submit();
	    }else { 
	    	return;
	   	}
	});
	
});
</script>
</head>
<body>
<div>
<form id="outerVo" name="outerVo" enctype="multipart/form-data">

	<table id="outerAdd" border="1" width="50%">
		<tr>
			<th width="20%">종류</th>
			<td width="80%">
				<select id="type" name="type">
					<option value="선택하세요">선택하세요</option>
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
			<th>사진 등록</th>
			<td>
				<input type="file" id="imageFile" name="imageFile" value="사진등록" accept=".jpg, .jpeg, .png"/>
			</td>
		</tr>
		<tr>
			<th>상품 소개</th>
			<td>
				<textarea name="content" id="content" cols="50" rows="5"></textarea>
			</td>
		</tr>
	</table>
	<div id="addB">	
		<input type="button" id="addButton" name="addButton" value="등록">
		<input type="reset" id="reset" name="reset" value="초기화">
	</div>
</form>
</div>	
<div id="sizeTable" name="sizeTable">
<input type="text" id="outerNo" name="outerNo" value="">
	<div style="">
		<input type="button" id="sizePlusButton" value="+">
		<input type="button" id="sizeMinusButton" value="-">
	</div>
	<table border="1" width="35%">
		<thead>
			<tr>
				<th>사이즈</th>
				<th>가슴</th>
				<th>소매</th>
				<th>어깨</th>
				<th>길이</th>
				<th>수량</th>
				<th>색상</th>
			</tr>
		</thead>
		<tbody id="sizeTable">
			<tr>
				<td>
					<select id ="type_1" name="type">
						<option value="선택하세요">선택하세요</option>
						<option value="S">S</option>
						<option value="M">M</option>
						<option value="L">L</option>
						<option value="XL">XL</option>
						<option value="FREE">FREE</option>
					</select><br>
					<input type="hidden" id="typeHidden_1" name="productSize" value="">
				</td>
				<td>
					<input type="number" id="chest1" name="productSize" size="3">
				</td>
				<td>
					<input type="number" id="sleeve1" name="productSize" size="3">
				</td>
				<td>
					<input type="number" id="shoulder1" name="productSize" size="3">
				</td>
				<td>
					<input type="number" id="whole1" name="productSize" size="3">
				</td>														
				<td>
					<input type="number" id="amount1" name="productSize" value="${outerVo.price}">
				</td>
				<td>
					<select id ="color_1" name="color">
						<option value="선택하세요">선택하세요</option>
						<option style="background-color:black;color:white" value="블랙">블랙</option>
						<option style="background-color:white" value="화이트">화이트</option>
						<option style="background-color:red;color:white" value="레드">레드</option>
						<option style="background-color:#08088A;color:white" value="네이비">네이비</option>
						<option style="background-color:#2E2E2E;color:white" value="차콜">차콜</option>
					</select>
					<input type="hidden" id="colorHidden_1" name="productSize" value="">
				</td>
			</tr>
		</tbody>
	</table>
	<input type="button" id="addSizeButton" name="addSizeButton" value="등록">
</div>

	<div id="imageAddTable" name="imageTable">
		<form:form modelAttribute="outerPictureVo" id="outerPictureVo" name="outerPictureVo" 
			action="${pageContext.request.contextPath}/admin/addOuterPicture.do" method="post" enctype="multipart/form-data">
			<form:input path="outerNo" name="outerNo" value=""/>
			
				<table id="imageTable" border="1" width="35%">
					<div>
						<input type="button" id="imagePlusButton" value="+">
						<input type="button" id="imageMinusButton" value="-">
					</div>
					<tbody id="imageTbody">
						<tr>
							<td>
								상품 이미지 등록
							</td>
						</tr>
						<tr>
							<td>
								<input type="file" name="imageFiles[0]" value="사진등록" accept=".jpg, .jpeg, .png"/>
							</td>
						</tr>
					</tbody>
				</table>
				<input type="button" id="addPicture" name="addPicture" value="등록">
		</form:form>
	</div>

</body>
</html>