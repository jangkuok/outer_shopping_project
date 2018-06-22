<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>장바구니</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
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
</script>
</head>
<body>
<jsp:include page="include/loginForm.jsp" flush="false"/><br>
<input type="hidden" id="count" name="count" value="${sessionScope.size()}">
<c:if test="${not empty sessionScope.cart}">
	<div>
		<c:forEach var="cartList" items="${sessionScope.cart}" varStatus="st">
			<div>
					<div name="checkProduct${cartList.cartNo}">
						<input type="checkBox" id="" name="checkBox" value="${cartList.cartNo}">
						<input type="hidden" id="" name="" value="${cartList.productNo}">
						<input type="text" id="" name="" value="${cartList.productName}">
						<input type="text" id="" name="" value="${cartList.productSize}">
						<input type="text" id="" name="" value="${cartList.productColor}">
						<input type="text" id="" name="" value="${cartList.productPrice}">
					</div>
			</div>
		</c:forEach>
	</div>
</c:if>
	<input type="button" id="removeCart" name="removeCart" value="상품삭제">
	<input type="button" id="" name="" value="상품주문">
</body>
</html>