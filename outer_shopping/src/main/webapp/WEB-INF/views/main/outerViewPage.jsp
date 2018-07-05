<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://cdn.rawgit.com/jmnote/jquery.nonajaxform/33a7/jquery.nonajaxform.min.js"></script>
<style>
.textTrans{
	background-color:transparent;
	border:0 solid black;
}
</style>
<script type="text/javascript">
//상품 선택하기
$(document).ready(function() {
	
	$("#outerViewInfo").hide();
	
	$("#sizeSelect").change(function() {
		
		$("#colorSelect").find("option").remove();
		$("#colorSelect").append($("<option value"+'선택하세요'+">선택하세요</option>"));
		$.ajax
		({		
			"url":"${pageContext.request.contextPath}/outer/outerSizeCheck.do", 
			"type":"POST",
			"data":{"outerNo":$("#outerNo").val(),"type":$("#sizeSelect").val()},
			"dataType":"json",
			"success":function(data)
			{
				if(data.length == 0){
					alert("상품이 없습니다.");
				}
				$.each(data, function(){
					$("#colorSelect").append($("<option value"+this.color+">"+this.color+"</option>"));
					$("#sizeType").val(this.type);
					
				});
			}			
		});
	});
	
	var index = parseInt("1");
	
	
	$(document).on('change','#colorSelect',function() {
		
		var size = $("#sizeSelect").val();
		var color = $("#colorSelect").val();
		var no = $("#outerNo").val();
		var name = $("#outerName").val();
		var price = $("#outerPrice").val();
		var selectPrice = $("#totalPrice").val();
		
		//선택한 상품 추가
		var product = '<tr name="trProduct"><td id="selectProductItems'+index+'" name="selectProductItems">'+
		'<input class="textTrans" type="hidden" id="productNo'+index+'" name="productNo" value="'+ no +'" readonly="">'+
		'<input class="textTrans" type="text" id="productName'+index+'" name="productName" size="15" value="'+ name +'" readonly="">'+
		'<input class="textTrans" type="text" id="productSize'+index+'" name="productSize" size="4" value="'+ size +'" readonly="">'+
		'<input class="textTrans" type="text" id="productColor'+index+'" name="productColor" size="5" value="'+ color +'" readonly="">'+
		'<input class="textTrans" type="text" id="productPrice'+index+'" name="productPrice" size="7" value="'+ price +'" readonly="">'+
		'<input type="button" id="close'+index+'" name="close" value="X">'+
		'</td></tr>';

		var error = "선택하세요";
		
		if(color != error){
			$("#outerViewInfo").show();	
			$('#productTbody').append(product);
			index++;	
			selectPrice = parseInt(selectPrice) +  parseInt(price);
			$("#totalPrice").val(selectPrice);
		}
	});

/* 	
	$(document).on('click','input[name="minus"]',function(){
	
    	var num = $(this).closest('li').find('#count[1]');
        var count = parseInt(num.val());
        count--;
        
        $('#count[1]').val(count);
        
    	if(num.val() < 2){
    		alert('더이상 줄일 수 없습니다.');
    		$('input[id="count[]"]').val('1'); 
    	}
	});
	
	$(document).on('click','input[id="plus[]"]',function(){
    	var num = $(this).closest('li').find('input[id="count[]"]');
        var count = parseInt(num.val());
        count++;
        
        $('input[id="count[]"]').val(count);
	}); 
*/	
	//관심상품 등록
	$("#wishB").click(function() {
		
		$.ajax
		({		
			"url":"${pageContext.request.contextPath}/outer/createWishList.do", 
			"type":"POST",
			"data":{"outerNo":$("#outerNo").val(),"id":$("#id").val()},
			"dataType":"json",
			"success":function(data)
			{
				if(data == "존재"){
					alert("이미 등록한 상품입니다.");
				}
				
				if(data == "등록완료" ){
					alert("관심상품이 등록 되었습니다.");	
				}
			}			
		});
	});
	
	//선택상품 삭제	
	$(document).on('click','input[id^=close]',function(e) {
		var selectPrice = $("#totalPrice").val();
		var price = $("#outerPrice").val();
		
		var no = e.target.id.substring(5);
		
		$("#selectProductItems"+no).remove();
		index--;
		
		if(index == 1){
			$("#outerViewInfo").hide();
		}
		
		selectPrice = parseInt(selectPrice) - parseInt(price);
		$("#totalPrice").val(selectPrice);
	});
	
	//상품 주문 
	$("#buyB").on('click',function(e) {
		var loginId = $('#id').val();
		
		if(index == 1){
			alert("선택한 상품이 없습니다.");
			return;
		}
		else if(loginId == null){
			if(confirm('로그인 하시겠습니까?')) { 
				location.href="${pageContext.request.contextPath}/member/orderPage.do"
		    }else { 
		    	return;
		   	}		
		}else{
			var productArr = []; 

		    $("td[name='selectProductItems']").children().each(function(i){
		    	productArr.push($(this).val());
		    });
		    
			$.form({
				"action": "${pageContext.request.contextPath}/member/orderPage.do",
				"type":"POST",
				"data": {"productList" : productArr, "loginId" : loginId},
				"dataType":"text"
			}).submit();
		}
	});
	
	
	//카트 등록 
	$("#cartB").on('click',function(e) {
		if(index == 1){
			alert("선택한 상품이 없습니다.");
			return;
		}
		var productArr = []; 

	    $("td[name='selectProductItems']").children().each(function(i){
	    	productArr.push($(this).val());
	    });
	    	    
		$.form({
			"action": "${pageContext.request.contextPath}/outer/addCart.do",
			"type":"GET",
			"data": {"productList" : productArr, "outerNo" : $('#outerNo').val()},
			"dataType":"text"
		}).submit();
	});
	
});
</script>
</head>
<body>
	<!-- 장바구니에 상품이 있을 경우 -->
	<c:if test="${not empty param.addNo}">
		<script>
			alert("이미 추가한 상품입니다.");
		</script>
	</c:if>
	
	<%-- <jsp:include page="include/loginForm.jsp" flush="false"/><br> --%>
	
	
	<!-- 관리자 로그인 할 경우 -->
	<sec:authorize access="hasRole('ROLE_ADMIN')">   
		<form id="updateProductForm" name="updateProductForm" action="${pageContext.request.contextPath}/admin/modifyOuterPage.do" method="post">
			<input type="hidden" id="outerNo" name="outerNo" value="${outer.outerNo}">
			<input type="hidden" id="modify" name="modify" value="상품">	
			<input type="submit" id="updateProduct" name="updateProduct" value="상품 수정">
		</form>
		<form id="updateSizeForm" name="updateSizeForm" action="${pageContext.request.contextPath}/admin/modifyOuterPage.do" method="post">
			<input type="hidden" id="outerNo" name="outerNo" value="${outer.outerNo}">
			<input type="hidden" id="modify" name="modify" value="사이즈">		
			<input type="submit" id="updateSize" name="updateSize" value="사이즈 수정">
		</form>
		<form id="updateImagesForm" name="updateImagesForm" action="${pageContext.request.contextPath}/admin/modifyOuterPage.do" method="post">
			<input type="hidden" id="outerNo" name="outerNo" value="${outer.outerNo}">	
			<input type="hidden" id="modify" name="modify" value="이미지">	
			<input type="submit" id="updateImages" name="updateImages" value="이미지 수정">
		</form>
	</sec:authorize>
	
	
	<div style="text-align: center;">
		<input type="hidden" id="outerNo" value="${outer.outerNo}">	
		<img style="float:left;" src="<c:url value='/image/${outer.imageName}'/>" width="300" height="300"/>
		<div style="text-align:left;">
			<table border="0">
				<tr>
					<td>
						<input class="textTrans" type="text" id="outerName" value="${outer.name}" readOnly="readOnly">
					</td>
				</tr>
				<tr>
					<td>
						<input class="textTrans" type="text" id="outerPrice" value="${outer.price}" readOnly="readOnly">
					</td>
				</tr>
				<tr>
					<td>
						<input type="hidden" id="sizeNo" value="">
							[필수]사이즈 선택<br>
							<select id ="sizeSelect" name="sizeSelect">
								<option value="선택하세요">선택하세요</option>
								<option value="S">S</option>
								<option value="M">M</option>
								<option value="L">L</option>
								<option value="XL">XL</option>
								<option value="FREE">FREE</option>
							</select><br>
							[필수]색상 선택<br> 
							<select id ="colorSelect" name="colorSelect">
							<option value="선택하세요">선택하세요</option>
								<table id="outerViewInfo" border="1">
									<tbody id="productTbody"></tbody>		
								</table>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						TOTAL &nbsp; <input class="textTrans" type="text" id="totalPrice" value="0" readOnly="readOnly"><br>
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" id="buyB" name="buyB" value="Buy Now"><br>
						<sec:authorize access="hasRole('ROLE_USER')">
							<input type="button" id="wishB" name="wishB" value="Wish List"><br>
						</sec:authorize>				
						<input type="button" id="cartB" name="cartB" value="Add To Cart">
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div style="text-align: center;">
		<c:forEach var="imageList" items="${outer.imageList}" varStatus="st">
			<img src="<c:url value='/image/${imageList.pictureName}'/>" width="650"/><br>
		</c:forEach>
	</div>
</body>
</html>
