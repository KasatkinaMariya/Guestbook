<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	
	<body>
	
		<sec:authorize access="isAuthenticated()">
			<% String guestName = request.getUserPrincipal().getName(); %>
			
			<p>
			You have logged as <i><%= guestName %></i>. 
			<a href="/guestbook/j_spring_security_logout">Logout</a>
			</p>
		</sec:authorize>
		
		<sec:authorize access="isAnonymous()">	
			<p>
			You are not authenticated. 
			<a href="/guestbook/spring_security_login">Login</a>
			</p>
		</sec:authorize>

	</body>
</html>
