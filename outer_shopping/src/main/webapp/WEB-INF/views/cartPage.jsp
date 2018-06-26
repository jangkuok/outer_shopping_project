<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>장바구니</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://cdn.rawgit.com/jmnote/jquery.nonajaxform/33a7/jquery.nonajaxform.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#removeCart").click(function() {
		if ( $("input[name='checkBox']:checked").size() == 0) {
		      alert("삭제할 상품을 선택하세요.");
		      return;
		}
		else{
			var checkArr = []; 
			
		    $("input[name='checkBox']:checked").each(function(i){   			    	
		    	var check = $("input[name='checkBox']:checked").val();
		    	checkArr.push(check);
		    }) ;
  			
		    $.ajax
			({		
				"url":"${pageContext.request.contextPath}/outer/deleteCart.do", 
				"type":"POST",
				"data":{ "checkList" : checkArr},
				"dataType":"text",
				"success":function(data)
				{
					$("input[name='checkBox']:checked").each(function(i){
						 var no = $(this).val();
						 $("div[name='checkProduct"+no+"']").remove();
					}) ;
					
					alert("장바구니를 삭제하였습니다.");
					location.reload();
				}
			});
			
		} 
	});
});

//상품 주문 
function orderProduct(){
	$(document).ready(function(){
		
		var loginId = $('#id').val();
		
		if ( $("input[name='checkBox']:checked").size() == 0) {
		      alert("주문할 상품을 선택하세요.");
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
			
			$("input[name='checkBox']:checked").each(function(){
				var no = $(this).val();
			    $("#checkProduct"+no).children().each(function(){
			    	productArr.push($(this).val());
			    });    
			});	
			$.form({
				"action": "${pageContext.request.contextPath}/member/orderPages.do",
				"type":"POST",
				"data": {"productList" : productArr, "loginId" : loginId},
				"dataType":"text"
			}).submit();
		}
	});
};

</script>
</head>
<body>
<jsp:include page="include/loginForm.jsp" flush="false"/><br>
<input type="hidden" id="count" name="count" value="${sessionScope.size()}">
<c:if test="${not empty sessionScope.cart}">
	<div>
		<c:forEach var="cartList" items="${sessionScope.cart}" varStatus="st">
			<div>
					<div id="checkProduct${cartList.cartNo}" name="checkProduct">
						<input type="checkBox" id="checkBox" name="checkBox" value="${cartList.cartNo}">
						<input type="hidden" id="" name="product" value="${cartList.productNo}">
						<input type="text" id="" name="product" value="${cartList.productName}">
						<input type="text" id="" name="product" value="${cartList.productColor}">
						<input type="text" id="" name="product" value="${cartList.productSize}">
						<input type="text" id="" name="product" value="${cartList.productPrice}">
					</div>
			</div>
		</c:forEach>
	</div>
</c:if>
	<input type="button" id="removeCart" name="removeCart" value="상품삭제">
	<input type="button" id="buyB" name="buyB" value="상품주문" onclick="orderProduct();">
</body>
</html>