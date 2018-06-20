<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty list}">
		<c:forEach var="wishList" items="${list}" varStatus="st">
			<c:forEach var="outerWishList" items="${wishList.list}" varStatus="st">
				<a href="${pageContext.request.contextPath}/outer/outerView.do?outerNo=${outerWishList.outerNo}">
					${outerWishList.name}
				</a> 
			</c:forEach>
		</c:forEach>
	</c:if>
</body>
</html>