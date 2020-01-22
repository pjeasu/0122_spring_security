<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
	<head>
		<title>메인페이지</title>
	</head>
	
	<body>
		<h1>
			메인 페이지
		</h1>		
		
		<sec:authorize access="isAnonymous()"> <!-- 권한이 없다면, 무조건 로그인 화면으로 가도록  -->
			<p><a href = "<c:url value = "/login/loginForm"/>">로그인</a></p>			
		</sec:authorize>
		
		
		<sec:authorize access="isAuthenticated()"> 
			<form:form action = "${pageContext.request.contextPath}/logout" method = "POST"	>
				<input type = "submit" value = "로그아웃"/>
			</form:form>
			<p><a href = "<c:url value = "/loginInfo"/>">로그인 정보 확인 방법 3가지</a></p>		
		</sec:authorize>
		
		<h3>
			[<a href = "<c:url value = "/user/userHome"/>"> 유저 홈 </a>]
			[<a href = "<c:url value = "/admin/adminHome"/>"> 관리자 홈 </a>]
		</h3>
		
		
		
	</body>
</html>
