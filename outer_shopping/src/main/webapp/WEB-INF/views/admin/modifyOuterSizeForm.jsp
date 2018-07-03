<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<table border="1" width="35%">
		<thead>
			<tr>
				<th>사이즈</th>
				<th>가슴</th>
				<th>소매</th>
				<th>어깨</th>
				<th>길이</th>
				<th>수량</th>
				<th>색상</th>
			</tr>
		</thead>
		<tbody id="sizeTable">
		<c:forEach var="sizeList" items="${outerVo.sizeList}" varStatus="st">
			<tr>
				<td>
					<select id ="type_${sizeList.sizeNo}" name="type">
						<option value="${sizeList.type}">${sizeList.type}</option>
						<option value="S">S</option>
						<option value="M">M</option>
						<option value="L">L</option>
						<option value="XL">XL</option>
						<option value="FREE">FREE</option>
					</select><br>
					<input type="hidden" id="typeHidden_${sizeList.sizeNo}" name="productSize" value="${sizeList.type}">
				</td>
				<td>
					<input type="number" id="chest${sizeList.sizeNo}" name="productSize" size="3" value="${sizeList.chest}">
				</td>
				<td>
					<input type="number" id="sleeve${sizeList.sizeNo}" name="productSize" size="3" value="${sizeList.sleeve}">
				</td>
				<td>
					<input type="number" id="shoulder${sizeList.sizeNo}" name="productSize" size="3" value="${sizeList.shoulder}">
				</td>
				<td>
					<input type="number" id="whole${sizeList.sizeNo}" name="productSize" size="3" value="${sizeList.whole}">
				</td>														
				<td>
					<input type="number" id="amount${sizeList.sizeNo}" name="productSize" value="${sizeList.amount}">
				</td>
				<td>
					<select id ="color_${sizeList.sizeNo}" name="color">
						<option value="${sizeList.color}">${sizeList.color}</option>
						<option style="background-color:black;color:white" value="블랙">블랙</option>
						<option style="background-color:white" value="화이트">화이트</option>
						<option style="background-color:red;color:white" value="레드">레드</option>
						<option style="background-color:#08088A;color:white" value="네이비">네이비</option>
						<option style="background-color:#2E2E2E;color:white" value="차콜">차콜</option>
					</select>
					<input type="hidden" id="colorHidden_${sizeList.sizeNo}" name="productSize" value="${sizeList.color}">
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>