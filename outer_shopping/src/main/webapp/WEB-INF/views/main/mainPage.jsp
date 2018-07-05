<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <!-- 사이드 화면 -->
    <div class="container">
      <div class="row">
        <!-- 신상품 3품목 소개 -->
        <div class="col-lg-9">
          <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
              <div class="carousel-item active">
                <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="First slide">
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Second slide">
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Third slide">
              </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>

		  <!-- 품목 소개 -->
		  <c:forEach var="outer" items="${list}" varStatus="st">
	          <div class="row">			
	            <div class="col-lg-4 col-md-6 mb-4">
	              <div class="card h-100">
	                <a href="${pageContext.request.contextPath}/outer/outerView.do?outerNo=${outer.outerNo}">
	                	<img class="card-img-top" src="<c:url value='/image/${outer.imageName}'/>" alt="">
	                </a>
	                <div class="card-body">
	                  <h4 class="card-title">
	                    <a href="${pageContext.request.contextPath}/outer/outerView.do?outerNo=${outer.outerNo}">${outer.name}</a>
	                  </h4>
	                  <h5><fmt:formatNumber value="${outer.price}" pattern="#,###.##"/> won</h5>
	                </div>
	              </div>
	            </div>
	          </div>
          </c:forEach>
           <!-- /품목 소개 -->      
      </div>
      <!-- /신상품 3품목 소개 -->
	</div>
	<!-- 메인화면 -->
	</div>
