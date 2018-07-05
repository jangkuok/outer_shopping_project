<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="ko-kr">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
<title>OUTSHOP</title>
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/shop-homepage.css" rel="stylesheet">
</head>
<body>
	<tiles:insertAttribute name="header" />
<%-- 	
	<table border="0">
		<tr>
			<td width="20%" valign="top">
				<tiles:insertAttribute name="side" />
			</td>
			<td>
				<tiles:insertAttribute name="content"/>
			</td>
		</tr>
	</table>
--%>	
		<div class="row">
			<div class="col-lg-3">
				<tiles:insertAttribute name="side" />
			</div>
			<div class="col-lg-8">
				<tiles:insertAttribute name="content"/>
			</div>
		</div>
		
<%-- 	<div class="container">
    	<tiles:insertAttribute name="side" />
    	<tiles:insertAttribute name="content"/>
    </div> 
--%>	
    <tiles:insertAttribute name="footer" />
	<!-- Bootstrap core JavaScript --> 
	<script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>