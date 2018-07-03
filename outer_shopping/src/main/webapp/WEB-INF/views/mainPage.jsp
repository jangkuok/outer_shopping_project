<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OUTER_SHOPPING_MALL</title>
</head>
<body>
<jsp:include page="include/loginForm.jsp" flush="false"/><br>
	<c:if test="${not empty list}">
			<table border="1">
			<c:forEach var="outer" items="${list}" varStatus="st">
				<tr>
					<td>
						<a href="${pageContext.request.contextPath}/outer/outerView.do?outerNo=${outer.outerNo}">
							<img src="<c:url value='/image/${outer.imageName}'/>" width="200" height="200"/>
						</a>
						
					</td>
				</tr>
				<tr>
					<td>
						<a href="${pageContext.request.contextPath}/outer/outerView.do?outerNo=${outer.outerNo}">
							${outer.name}
						</a>
					</td>
					
				</tr>
				<tr>
					<td>${outer.price} won</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>