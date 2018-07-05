<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나의 WishList</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
//상품 선택하기
$(document).ready(function() {
	$("#deleteWishList").click(function() {
		if ( $("input[name='checkBox']:checked").size() == 0) {
		      alert("삭제할 상품을 선택하세요.");
		      return;
		}
		else{
			var checkArr = []; 

		    $("input[name='checkBox']:checked").each(function(i){
		    	checkArr.push($(this).val());
		    }) ;
		    
		 
			$.ajax
			({		
				"url":"${pageContext.request.contextPath}/member/deleteWishList.do", 
				"type":"POST",
				"data":{ "checkList" : checkArr},
				"dataType":"text",
				"success":function(data)
				{
					 $("input[name='checkBox']:checked").each(function(i){
						 var no = $(this).val();
						 $("#checkList"+ no).remove();
					 }) ;
					
					alert("관심상품을 삭제하였습니다.");
				}
			});
		} 
	});
});
</script>
</head>
<body>
<%-- <jsp:include page="../include/loginForm.jsp" flush="false"/><br> --%>
	<c:if test="${empty list}">
		<div>
			관심상품 내역이 없습니다.
		</div>
	</c:if>	
	<c:if test="${not empty list}">
			<table border="1">
			<thead>
			<tr>
				<th></th>
				<th>이미지</th>
				<th>상품 이름</th>
				<th>가격</th>
			</tr>
			</thead>
			<tbody>
			<tr>
			<c:forEach var="wishList" items="${list}" varStatus="st">
				<div>
					<c:forEach var="outerWishList" items="${wishList.list}" varStatus="st">					
						<td>
							<input type="checkBox" id="check${wishList.wishNo}" name="checkBox" value="${wishList.wishNo}">
						</td>
						<td>						
							<img src="<c:url value='/image/thumbnail/${outerWishList.thumbnailName}'/>"/>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/outer/outerView.do?outerNo=${outerWishList.outerNo}">
								${outerWishList.name}
							</a>
						</td>
						<td>
							${outerWishList.price}
						</td>
					</c:forEach>
				</div>
			</c:forEach>
			</tr>
			</tbody>
		</table>
		<input type="button" id="deleteWishList" name="deleteWishList" value="상품삭제">
		<input type="button" id="" name="" value="장바구니 담기">
	
	
	
	
<%-- 	<div id ="checkList">
		<c:forEach var="wishList" items="${list}" varStatus="st">
			<div>
				<c:forEach var="outerWishList" items="${wishList.list}" varStatus="st">
					<div id="checkList${wishList.wishNo}">
						<input type="checkBox" id="check${wishList.wishNo}" name="checkBox" value="${wishList.wishNo}">
						<a href="${pageContext.request.contextPath}/outer/outerView.do?outerNo=${outerWishList.outerNo}">
							${outerWishList.name}
						</a>
					</div>
				</c:forEach>
			</div>
		</c:forEach>
	</div> --%>
	</c:if>

	
	
</body>
</html>