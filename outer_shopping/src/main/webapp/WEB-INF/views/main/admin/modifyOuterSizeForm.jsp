<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
 $(document).ready(function() {
	 
	 	var tableSize = $('#sizeTable tbody tr').length;

		var index = parseInt(tableSize);
		$('#index').val(index);
		
		//상품size 추가
		$("#sizePlusButton").click(function() {			
			index++;
			var size = '<tr><td><select id ="type_'+index+'" name="productSize_type'+index+'"><option value="선택하세요">선택하세요</option><option value="S">S</option>'+
			'<option value="M">M</option><option value="L">L</option><option value="XL">XL</option><option value="FREE">FREE</option></select>'+
			'<td><input type="number" id="chest'+index+'" name="productSize_chest'+index+'" size="3"></td>'+
			'<td><input type="number" id="sleeve'+index+'" name="productSize_sleeve'+index+'" size="3"></td>'+
			'<td><input type="number" id="shoulder'+index+'" name="productSize_shoulder'+index+'" size="3"></td>'+
			'<td><input type="number" id="whole'+index+'" name="productSize_whole'+index+'" size="3"></td>'+											
			'<td><input type="number" id="amount'+index+'" name="productSize_amount'+index+'" value=""></td>'+
			'<td><select id ="color_'+index+'" name="productSize_color'+index+'"><option value="선택하세요">선택하세요</option>'+
			'<option style="background-color:black;color:white" value="블랙">블랙</option>'+
			'<option style="background-color:white" value="화이트">화이트</option>'+
			'<option style="background-color:red;color:white" value="레드">레드</option>'+
			'<option style="background-color:#08088A;color:white" value="네이비">네이비</option>'+
			'<option style="background-color:#2E2E2E;color:white" value="차콜">차콜</option>	</td></tr>'	

			
			$('#index').val(index);
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
				index--;
				$('#index').val(index);
				$("#sizeTable tr:last").remove();
			}
		});
		
		//상품size 등록
		$("#modifySizeButton").on('click',function() {				
			alert("전송");
			if(confirm('등록 하시겠습니까?')) { 
				$('#modifySizeForm').submit();
			}else{
				return;
			}
		});
 });
</script>
</head>
<body>
<form id="modifySizeForm" name="modifySizeForm"
		action="${pageContext.request.contextPath}/admin/ModefiyOuterSize.do" method="post">
<input type="text" id="outerNo" name="outerNo" value="${outerVo.outerNo }">
<input type="text" id="index" name="index" value="">
	<div>
		<input type="button" id="sizePlusButton" value="+">
		<input type="button" id="sizeMinusButton" value="-">
	</div>
<table id="sizeTable" border="1" width="35%">
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
		<c:forEach var="sizeList" items="${outerVo.sizeList}" varStatus="st">
			<tr>
				<td>
					<select id ="type_${sizeList.sizeNo}" name="productSize_type${st.count}">
						<option value="${sizeList.type}">${sizeList.type}</option>
						<option value="S">S</option>
						<option value="M">M</option>
						<option value="L">L</option>
						<option value="XL">XL</option>
						<option value="FREE">FREE</option>
					</select><br>
					<%-- <input type="hidden" id="chest${sizeList.sizeNo}" name="productSize_type${sizeList.sizeNo}" value="${sizeList.type}"> --%>
				</td>
				<td>
					<input type="number" id="chest${sizeList.sizeNo}" name="productSize_chest${st.count}" size="3" value="${sizeList.chest}">
				</td>
				<td>
					<input type="number" id="sleeve${sizeList.sizeNo}" name="productSize_sleeve${st.count}" size="3" value="${sizeList.sleeve}">
				</td>
				<td>
					<input type="number" id="shoulder${sizeList.sizeNo}" name="productSize_shoulder${st.count}" size="3" value="${sizeList.shoulder}">
				</td>
				<td>
					<input type="number" id="whole${sizeList.sizeNo}" name="productSize_whole${st.count}" size="3" value="${sizeList.whole}">
				</td>														
				<td>
					<input type="number" id="amount${sizeList.sizeNo}" name="productSize_amount${st.count}" value="${sizeList.amount}">
				</td>
				<td>
					<select id ="color_${sizeList.sizeNo}" name="productSize_color${st.count}">
						<option value="${sizeList.color}">${sizeList.color}</option>
						<option style="background-color:black;color:white" value="블랙">블랙</option>
						<option style="background-color:white" value="화이트">화이트</option>
						<option style="background-color:red;color:white" value="레드">레드</option>
						<option style="background-color:#08088A;color:white" value="네이비">네이비</option>
						<option style="background-color:#2E2E2E;color:white" value="차콜">차콜</option>
					</select>
					<%-- <input type="hidden" id="colorHidden_${sizeList.sizeNo}" name="productSize_color${sizeList.sizeNo}" value="${sizeList.color}"> --%>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<input type="button" id="modifySizeButton" name="modifySizeButton" value="등록">
</form>	
</body>
</html>