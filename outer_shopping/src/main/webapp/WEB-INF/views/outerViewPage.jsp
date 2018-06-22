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
<script type="text/javascript">
//상품 선택하기
$(document).ready(function() {
	
	$("#selectProduct").hide();
	
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
				$.each(data, function(){
					$("#colorSelect").append($("<option value"+this.color+">"+this.color+"</option>"));
					$("#sizeType").val(this.type);
					
				});

			}			
		});
	});
	
	var index = parseInt("1");
	
	
	$("#colorSelect").change(function() {
		
		
		var size = $("#sizeSelect").val();
		var color = $("#colorSelect").val();
		var no = $("#outerNo").val();
		var name = $("#outerName").val();
		var price = $("#outerPrice").val();
		var selectPrice = $("#totalPrice").val();
		
		
/* 		var product = '<li><input type="text" id="productName['+index+']" name="productName" value="'+ name +'" readonly="">'+
		'<input type="text" id="productSize['+index+']" name="productSize" value="'+ size +'" readonly="">'+
		'<input type="text" id="productColor['+index+']" name="productColor" value="'+ color +'" readonly="">'+
		'<input type="text" id="productPrice['+index+']" name="productPrice" value="'+ price +'" readonly="">'+
		'<input type="button" id="minus['+index+']" name="minus" value="-">'+
		'<input type="text" id="count['+index+']" name="count" value="1" size="5" readonly="" >'+
		'<input type="button" id="plus['+index+']" name="plus" value="+" >'+
		'<input type="button" id="close['+index+']" name="close" value="X">'+
		'<input type="text" id="price['+index+']" name="price" value="'+price+'"></li>'; */
		
		var product = '<li id="selectProductItems'+index+'" name="selectProductItems">'+
		'<input type="hidden" id="productNo'+index+'" name="productNo" value="'+ no +'" readonly="">'+
		'<input type="text" id="productName'+index+'" name="productName" value="'+ name +'" readonly="">'+
		'<input type="text" id="productSize'+index+'" name="productSize" value="'+ size +'" readonly="">'+
		'<input type="text" id="productColor'+index+'" name="productColor" value="'+ color +'" readonly="">'+
		'<input type="text" id="productPrice'+index+'" name="productPrice" value="'+ price +'" readonly="">'+
		'<input type="button" id="close'+index+'" name="close" value="X" onclick="closeProduct('+index+');">'+
		'</li>';
		
		var error = "선택하세요";
		
		$("#selectProduct").show();

		if(color != error){
			$('ul#selectProduct').append(product);
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
				
				if(data == "등록완료"){
					alert("관심상품이 등록 되었습니다.");	
				}
			}			
		});
	});
	
 	$('#cartB').on('click',function(){
	
 		
 		var childrens = $("li[name='selectProductItems']").children();
 		
 		var test = $('#productName').val();
 		
 		
		if(test == null){
			
			alert("선택한 상품이 없습니다.");
			return;
			
		}else{
			
			var productArr = []; 

		    $("li[name='selectProductItems']").children().each(function(i){
		    	productArr.push($(this).val());
		    });
		    
			$.form({
				"action": "${pageContext.request.contextPath}/outer/addCart.do",
				"type":"GET",
				"data": {"productList" : productArr},
				"dataType":"text"
			}).submit(); 
		}
	}); 
	
/* 	$("#cartB").click(function(){
		
		if(!$("ul[name='selectProduct']").children().val()){
			alert("선택한 상품이 없습니다.");
			return;
		}
		
		var productArr = []; 

	    $("li[name='selectProductItems']").children().each(function(i){
	    	productArr.push($(this).val());
	    });
	    
		$.form({
			"action": "${pageContext.request.contextPath}/outer/addCart.do",
			"data": {"productList" : productArr},
			"dataType":"text"
		}).submit(); 
	}); */

});

//선택상품 삭제
function closeProduct(index){
	
	var selectPrice = $("#totalPrice").val();
	var price = $("#outerPrice").val();
	
	$(document).ready(function(e){
		var id = 'selectProductItems'+index+'';
		
		$("#"+id).remove();
		
		selectPrice = parseInt(selectPrice) - parseInt(price);
		$("#totalPrice").val(selectPrice); 
	});
};
/* 
function addCart(){
	$(document).ready(function(){
		$('#cartB').click(function(){
			
			if(!($("ul[name='selectProduct']").children().val())){
				alert("선택한 상품이 없습니다.");
				return;
			}else{
				var productArr = []; 

			    $("li[name='selectProductItems']").children().each(function(i){
			    	productArr.push($(this).val());
			    });
			    
				$.form({
					"action": "${pageContext.request.contextPath}/outer/addCart.do",
					"data": {"productList" : productArr},
					"dataType":"text"
				}).submit(); 
			}
		});
	});	
}; */


</script>

</head>
<body>
<c:if test="${not empty param.addNo}">
	<script>
		alert("이미 추가한 상품입니다.");
	</script>
</c:if>
	<jsp:include page="include/loginForm.jsp" flush="false"/><br>
	<input type="text" id="outerNo" value="${outer.outerNo}" readOnly=""><br>
	<input type="text" id="content" value="${outer.content}" readOnly=""><br>
	<input type="text" id="outerName" value="${outer.name}" readOnly=""><br>
	<input type="text" id="outerPrice" value="${outer.price}" readOnly=""><br>

	
	<input type="hidden" id="sizeNo" value="">
	사이즈 : 
	<select id ="sizeSelect" name="sizeSelect">
		<option value="선택하세요">선택하세요</option>
		<option value="S">S</option>
		<option value="M">M</option>
		<option value="L">L</option>
	</select><br>
		
	
	색상 : 
	
	<select id ="colorSelect" name="colorSelect">
		<option value="선택하세요">선택하세요</option>
	</select>
	
	<ul id = "selectProduct">
		
	</ul>
	<br><input type="text" id="totalPrice" value="0">
	
	<br>
	<input type="button" id="buyB" name="buyB" value="Buy Now">
	
	<sec:authorize access="hasRole('ROLE_USER')">
		<input type="hidden" id="id" value="<sec:authentication property="principal.id"/>">
		<input type="button" id="wishB" name="wishB" value="Wish List">	
	</sec:authorize>	

	<input type="button" id="cartB" name="cartB" value="Add To Cart">

	
	
</body>
</html>