<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/.do">OUTSHOP</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="${pageContext.request.contextPath}/.do">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>

			<!-- 비로그인일 경우 -->
			<sec:authorize access="!isAuthenticated()">	
				<li class="nav-item">
	              <a class="nav-link" href="${pageContext.request.contextPath}/loginFormPage.do">로그인</a>
	            </li>				
				<li class="nav-item">
	              <a class="nav-link" href="${pageContext.request.contextPath}/joinPage.do">회원가입</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="${pageContext.request.contextPath}/outer/cartPage.do">장바구니</a>
	            </li>	
	            <li class="nav-item">
	              <a class="nav-link" href="#">리뷰 게시판</a>
	            </li>
			</sec:authorize>
			
            <!-- 회원 로그인 할 경우 -->
			<sec:authorize access="hasRole('ROLE_USER')">
				<input type="hidden" id="id" name="id" value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.id}">
            	<li class="nav-item">
	              <a class="nav-link" href="${pageContext.request.contextPath}/member/myPage.do?id=${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.id}">MyPage</a>
	            </li>				            
	            <li class="nav-item">
	              <a class="nav-link" href="${pageContext.request.contextPath}/outer/cartPage.do">장바구니</a>
	            </li>	
	            <li class="nav-item">
	              <a class="nav-link" href="#">리뷰 게시판</a>
	            </li>		            
	            <li class="nav-item">
	              <a class="nav-link" href="${pageContext.request.contextPath}/logoutButton.do">로그아웃</a>
	            </li>	            
            </sec:authorize>
            
            <!-- 관리자 로그인 할 경우 -->
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li class="nav-item">
	               <a class="nav-link" href="${pageContext.request.contextPath}/admin/outerForm.do">상품등록</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="#">게시판 관리</a>
	            </li>			
				<li class="nav-item">
	               <a class="nav-link" href="${pageContext.request.contextPath}/logoutButton.do">로그아웃</a>
	            </li>
			</sec:authorize>
          </ul>
        </div>
      </div>
    </nav>
