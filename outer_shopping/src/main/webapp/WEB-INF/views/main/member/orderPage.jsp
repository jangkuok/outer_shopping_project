<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 주문</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://cdn.rawgit.com/jmnote/jquery.nonajaxform/33a7/jquery.nonajaxform.min.js">
<!-- daum 우편번호 서비스 외장 JS(Javascript) 파일 링크 -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var price = 0;
	
	//상품금액
	$('td[name="tdPrice"]').each(function(){
		var no = $(this).text();  
		price = parseInt(price) + parseInt(no);
		//상품가격
		$("input[name='productPrice']").val(price);
	});
	
	//배송비 가격
	var productPrice = $('#productPrice').val();

	if(parseInt(productPrice) >= parseInt("50000")){
		$('#deliveryPrice').val("0");
	}
	if(parseInt(productPrice) < parseInt("50000")){
		$('#deliveryPrice').val("2500");
	}
	
	
	//총가격
	var deliveryPrice = $('#deliveryPrice').val();
	
	var total = parseInt(productPrice) + parseInt(deliveryPrice);
	
	$("#totalPrice1").val(total);
	$("#totalPrice2").val(total);
	
	$("#removeProduct").click(function() {
		$("input[name='checkBox']:checked").each(function(){
			 var no = $(this).val();		
			 
			 var price = $('#tdPrice'+no).text();
			 
			 //총 상품 가격
			 var productPrice = $('#productPrice').val();
			 
			 $('#productPrice').val(parseInt(productPrice) - parseInt(price));

			 
			 //배송비 가격
			 var cpp = $('#productPrice').val();
			 
			 if(cpp == parseInt("0") || cpp >= parseInt("50000")){
				 $('#deliveryPrice').val("0");
			 }
			 
			 if(cpp < parseInt("50000") && cpp > parseInt("0")){
				 $('#deliveryPrice').val("2500");
			 }
			 //상품 + 배송비 가격
			 var deliveryPrice = $('#deliveryPrice').val();
			 
			 var total = parseInt(cpp) - parseInt(deliveryPrice);
			 
			 $("#totalPrice1").val(total);
			 $("#totalPrice2").val(total);
			 
			 //해당 상품 삭제
			 $("#trProduct"+no).remove();
		}) ;	
	});

	//배송지 선택
	if($('input[name="orderCheck"]:checked').val() == '새로운'){
		alert('sdfsdfsdf');

	}

	//상품 주문
	$('#buyB').on('click',function(){
		
/* 		var productArr = []; 
		
		$("input[name='product']").each(function(){
	    	productArr.push($(this).val());
	    });
*/

		//상품정보 배열에 넣기
		var rowData = [];
		var productArr = []; 
		

		//테이블 행의 모든 값 가져오기
		$('#tbodyProduct tr').each(function(i){   			    	
	    	var tr = $('#tbodyProduct tr').eq(i);
	    	

		    var td = tr.children();
		    rowData.push(tr.text());
		    
		    var cartNo = td.eq(1).text();
	        var productNo = td.eq(2).text();
	        var productName = td.eq(3).text();
	        var productColor = td.eq(4).text();
	        var productSize = td.eq(5).text();
	        var productPrice = td.eq(6).text();
	        
	        productArr.push(cartNo);
	        productArr.push(productNo);
	        productArr.push(productName);
	        productArr.push(productColor);
	        productArr.push(productSize);
	        productArr.push(productPrice);

		});
		//주문 정보 배열에 넣기
		var deliveryInfoArr = []; 
		
		$("input[name='deliveryInfo']").each(function(){
			var arr = $(this).val();
			deliveryInfoArr.push(arr);
		});	
		
		//메시지값 배열에 넣기
		deliveryInfoArr.push($('#message').val());

  		if(confirm('주문 하시겠습니까?')) { 
			$.form({
				"action": "${pageContext.request.contextPath}/member/orderProduct.do",
				"type":"POST",
				"data": {"productList" : productArr, "deliveryInfoList" : deliveryInfoArr, "loginId" : $('#id').val(), "orderNo" : $('#orderNo').val()},
				"dataType":"text"
			}).submit();
	    }else { 
	    	return;
	   	}
	});
	
});
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
.textTrans{
	background-color:transparent;
	border:0 solid black;
	text-align:right;
}
</style>
   
</head>
<body>
<%-- <jsp:include page="../include/loginForm.jsp" flush="false"/><br> --%>
주문내역
	<div>
		<table id="orderProduct" border="1" width="70%">
			<thead>
			<tr>
				<th></th>
				<th>번호</th>
				<th>상품 번호</th>
				<th>상품 이름</th>
				<th>색상</th>
				<th>사이즈</th>
				<th>가격</th>
			</tr>
			</thead>
			<tbody id="tbodyProduct">
				<c:forEach var="orderList" items="${orderList}" varStatus="st">
					<tr id="trProduct${orderList.cartNo}">
						<td>
							<input type="checkBox" id="checkBox" name="checkBox" value="${orderList.cartNo}">
						</td>
						<td>${orderList.cartNo}</td>
						<td>${orderList.productNo}</td>
						<td>${orderList.productName}</td>
						<td>${orderList.productColor}</td>
						<td>${orderList.productSize}</td>
						<td id="tdPrice${orderList.cartNo}" name="tdPrice">${orderList.productPrice}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<table border="1" width="70%">
				<tr>
					<td colspan="7" >
								상품금액<input class="textTrans" type="text" id="productPrice" name="productPrice" size="6" value="0"> +
								배송비<input class="textTrans" type="text" id="deliveryPrice" name="deliveryPrice" size="6" value="0"> = 
								합계 : <input class="textTrans" type="text" id="totalPrice1" name="totalPrice" size="8" value="0"><br>
					</td>
				</tr>
			</table>
		</div>
	</div>
<input type="button" id="removeProduct" name="removeProduct" value="상품삭제">
<hr>	
	<div>
		주문정보
		<table border="1" width="70%">
			<tr>
				<th width="20%">주문자*</th>
				<td width="80%">
					<input type="text" id="" name="" value="${memberVo.name}">
				</td>
			</tr>
			<tr>
				<th>주소*</th>
				<td>
					<input type="text" id="" name="" value="${memberVo.zipcode}" size="4"><br>
					<input type="text" id="" name="" value="${memberVo.address}" size="70">  기본주소<br>
					<input type="text" id="" name="" value="${memberVo.address2}" size="70"> 나머지주소
				</td>
			</tr>
			<tr>
				<th>휴대전화*</th>
				<td>
					<input type="text" id="" name="" value="${memberVo.phoneNum}">
				</td>
			</tr>
			<tr>
				<th>이메일*</th>
				<td>
					<input type="text" id="" name="" value="${memberVo.email}">
				</td>
			</tr>
		</table>
	</div>
<hr>	
	<div>
		배송정보
		<input type="hidden" id="orderNo" name="orderNo" value="${orderNo}">
		<table border="1" width="70%">
			<tr>
				<th width="20%">배송지 선택</th>
				<td width="80%">
					<input type="radio" id="existSelect" name="orderCheck" checked="checked" value="주문자" /> 주문자 정보와 동일
					<input type="radio" id="newSelect" name="orderCheck" value="새로운" /> 새로운 배송지
				</td>
			</tr>
			<tr>
				<th>주문자*</th>
				<td>
					<input type="text" id="name" name="name" value="${memberVo.name}">
				</td>
			</tr>
			<tr>
				<th>주소*</th>
				<td>
					<input type="text" id="zipcode" name="deliveryInfo" value="${memberVo.zipcode}" size="4">
					<input type="button" value="주소 검색" onClick="getPostcodeAddress()"><br>
					<input type="text" id="address" name="deliveryInfo" value="${memberVo.address}" size="70"> 기본주소<br>
					<input type="text" id="address2" name="deliveryInfo" value="${memberVo.address2}" size="70"> 나머지주소
				</td>
			</tr>
			<tr>
				<th>휴대전화*</th>
				<td>
					<input type="text" id="phoneNum" name="deliveryInfo" value="${memberVo.phoneNum}">
				</td>
			</tr>
			<tr>
				<th>이메일*</th>
				<td>
					<input type="text" id="email" name="deliveryInfo" value="${memberVo.email}">
				</td>
			</tr>
			<tr>
				<th>배송메세지</th>
				<td>
					<textarea id="message"></textarea>
				</td>
			</tr>
		</table>
	</div>
	<div>
		<table border="1" width="50%">
			<tr>
				<th>결제 예정 금액</th>
				<td>
					<input class="textTrans" type="text" id="totalPrice2" name="deliveryInfo" value="0">
				</td>
			</tr>
		</table>
	</div>
<hr>	
결제 수단<br>
<input type="radio" name="" value="" /> 카드 결제
<input type="radio" name="" value="" /> 무통장 입금
<input type="radio" name="" value="" /> 핸드폰 결제<br>
<input type="button" id="buyB" value="결제하기">
</body>
</html>