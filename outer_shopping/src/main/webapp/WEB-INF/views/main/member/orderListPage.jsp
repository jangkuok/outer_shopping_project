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
<!-- form -->
<script src="http://cdn.rawgit.com/jmnote/jquery.nonajaxform/33a7/jquery.nonajaxform.min.js"></script>
<script type="text/javascript">
//상품 선택하기
$(document).ready(function() {
	 // 게시글 팝업(modal) 보기
	 
	
	 
    $("input[id^=orderProductList_]").click(function (e) {
       
        var orderNo = e.target.id.substring(17); 
         
        $.ajax ({
            "url" : "${pageContext.request.contextPath}/member/productListSearch.do",
            "type" : "POST",
            "data":{ "orderNo" : orderNo},
            "dataType":"json",
            "success" : function (data) {
            	 $.each(data,function(index,item){
            		 var product = '<tr id="modalTr"><td>'+ item.outerNo + '</td>'+
            		 '<td>'+ item.productName + '</td>'+
            		 '<td>'+ item.productSize + '</td>'+
            		 '<td>'+ item.productColor + '</td>'+
            		 '<td>'+ item.productPrice + '</td></tr>'
            		 
            		 $('tbody#modalTbody').append(product);
            	 });
            }                  
        });
        
        $('input[id^=orderProductList_]').on('click',function(){
        	$('tr#modalTr').remove();
        });
    });
});
//결제하기
function payment(i){
	$(document).ready(function() {
     	if(confirm('결제를 하시겠습니까?')) { 
    		$.form({
				"action": "${pageContext.request.contextPath}/member/haningUpdateOrder.do",
				"type":"POST",
				"data": {"orderNo" : i, "handing" : $('#paymentHanding').val(), "memberId" : $('#id').val()},
				"dataType":"text"
			}).submit();
	    }else { 
	    	return;
	    }
	});
}


//주문취소
function handingOrder(i){
	$(document).ready(function() {
     	if(confirm('주문을 취소 하시겠습니까?')) { 
    		$.form({
				"action": "${pageContext.request.contextPath}/member/haningUpdateOrder.do",
				"type":"POST",
				"data": {"orderNo" : i, "handing" : $('#handing').val(), "memberId" : $('#id').val()},
				"dataType":"text"
			}).submit();
	    }else { 
	    	return;
	    }
	});
}
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
	          <table border="1">
				<thead>
				<tr>
					<th>상품번호</th>
					<th>상품이름</th>
					<th>사이즈</th>
					<th>색상</th>
					<th>가격</th>
				</tr>
				</thead>
				<tbody id="modalTbody">

				</tbody>
			</table>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>
    
<%-- <jsp:include page="../include/loginForm.jsp" flush="false"/><br> --%>
	<c:if test="${empty list}">
		<div>
			주문 내역이 없습니다.
		</div>
	</c:if>
	
	<c:if test="${not empty list}">		
		<table border="1">
			<thead>
			<tr>
				<th>주문번호</th>
				<th>입금액</th>
				<th>주문날짜</th>
				<th>진행상황</th>
				<th>상세보기</th>
				<th>주문관리</th>
				<th>결제하기</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="orderList" items="${list}" varStatus="st">
				<tr>
					<td>${orderList.orderNo}</td>
					<td>${orderList.totalPrice}</td>
					<td>${orderList.orderDate}</td>
					<td>${orderList.handing}</td>
					<td>
						<c:if test="${orderList.handing != '주문취소'}">
							<input type="button" id="orderProductList_${orderList.orderNo}" data-toggle="modal" data-target="#myModal" value="상세보기" >
						</c:if>
					</td>
					<td>
						<c:if test="${orderList.handing != '배송완료'}">
							<input type="hidden" id="handing" value="주문취소">
							<input type="button" id="hangingOrderB_${orderList.orderNo}" value="주문취소" onclick="handingOrder(${orderList.orderNo})">
						</c:if>
					</td>
					<td>
						<c:if test="${orderList.handing == '결제 대기중'}">
								<input type="hidden" id="paymentHanding" value="배송대기중">
								<input type="button" id="paymentB_${orderList.orderNo}" value="결제하기" onclick="payment(${orderList.orderNo})">
						</c:if>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:if>
	
	
	
	
	
	
	<%-- 	<c:forEach var="orderList" items="${list}" varStatus="st">
			<div>
				<div id="">
						주문번호 : ${orderList.orderNo } /
						입금액 : ${orderList.totalPrice } / 
						주문날짜 : ${orderList.orderDate } / 
						진행상황 : ${orderList.handing }
						<input type="hidden" id="orderNo_${orderList.orderNo}" name="orderNo" value="${orderList.orderNo}">
						<form id="cancel_${orderList.orderNo}" action="${pageContext.request.contextPath}/member/cancelOrder.do" method="post">
							<input type="hidden" id="memberId" value="${orderList.memberId}">
							<input type="button" value="주문취소" onclick="cancelOrderButton(${orderList.orderNo});">
						</form>	
						<input type="button"  id="orderProductList_${orderList.orderNo}" data-toggle="modal" data-target="#myModal" value="상세보기" >

				</div>
			</div>
		</c:forEach>
	</c:if>
 --%>
</body>
</html>