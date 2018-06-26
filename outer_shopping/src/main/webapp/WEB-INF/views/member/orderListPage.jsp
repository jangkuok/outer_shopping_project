<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나의 주문 목록</title>
<!-- bootstrap CSS : 3.3.7 -->
<link rel="stylesheet" 
	  href="<c:url value='/js/bootstrap/3.3.7/css/bootstrap.min.css/' />">

<!-- jQuery : 3.2.1 -->
<script src="<c:url value='/js/jQuery/3.2.1/jquery-3.2.1.min.js' />"></script>

<!-- bootstrap JS : 3.3.7 -->
<script src="<c:url value='/js/bootstrap/3.3.7/js/bootstrap.min.js' />"></script>


<script type="text/javascript">
//상품 선택하기
$(document).ready(function() {
	 // 게시글 팝업(modal) 보기
	 
	
	 
    $("input[id^=productList_]").click(function (e) {
       
        var orderNo = e.target.id.substring(12); 
         
        $.ajax ({
            "url" : "${pageContext.request.contextPath}/member/productListSearch.do",
            "type" : "POST",
            "data":{ "orderNo" : orderNo},
            "dataType":"json",
            "success" : function (data) {
            	 $.each(data,function(index,item){
            		 var product = '<li name="productList">'+
            			'<input type="hidden" value="'+ item.outerNo +'" readonly="">'+
            			'<input type="text" value="'+ item.productName +'" readonly="">'+
            			'<input type="text" value="'+ item.productSize +'" readonly="">'+
            			'<input type="text" value="'+ item.productColor +'" readonly="">'+
            			'<input type="text" value="'+ item.productPrice +'" readonly="">'+
            			'</li>';            			
            		 $('ul#selectProduct').append(product);
            	 });
            }                  
        });
        
        $('input[id^=productList_').on('click',function(){
        	$('li[name="productList"]').remove();
        });
       
    });
});
</script>
</head>
<body>
    <div class="modal fade" id="myModal" role="dialog">
      <div class="modal-dialog">
     
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">주문 상세보기</h4>
          </div>
         
          <div id="article_content" class="modal-body">
          		<ul id = "selectProduct">
		
				</ul>
          </div>
         
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>
    
<jsp:include page="../include/loginForm.jsp" flush="false"/><br>
	<c:if test="${empty list}">
		<div>
			주문 내역이 없습니다.
		</div>
	</c:if>
	
	<c:if test="${not empty list}">
	<div id ="checkList">
		<c:forEach var="orderList" items="${list}" varStatus="st">
			<div>
				<div id="">
					<input type="checkBox" id="check" name="checkBox" value="">
						주문번호 : ${orderList.orderNo } /
						입금액 : ${orderList.totalPrice } / 
						주문날짜 : ${orderList.orderDate } / 
						진행상황 : ${orderList.handing }
						<input type="hidden" id="orderNo_${orderList.orderNo}" name="orderNo" value="${orderList.orderNo}">
						<%-- <button id="productList_${orderList.orderNo}" data-toggle="modal" data-target="#myModal">상세보기</button> --%>
						<input type="button"  id="productList_${orderList.orderNo}" data-toggle="modal" data-target="#myModal" value="상세보기" >
						<input type="button" id="" name="" value="주문취소">
				</div>
			</div>
		</c:forEach>
	</div>
	</c:if>

</body>
</html>