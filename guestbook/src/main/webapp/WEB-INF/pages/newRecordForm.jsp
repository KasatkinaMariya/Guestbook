<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ page import="ru.home.guestbook.guestbookRecords.GuestbookRecord" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Compose your message</title>
	</head>
	
	<body>
		<jsp:include page="/head.jsp"/>
	
		<form:form method="POST" action="/guestbook/NewMessage/" commandName="record">
				
			<p>
			<b>Message:</b> <br>			
			<form:textarea path="message" rows="3" cols="40" /> <br>
			</p>			
			
			<p>	
			<input type="submit" value="Send" />
			</p>
			
		</form:form>		
	</body>
</html>