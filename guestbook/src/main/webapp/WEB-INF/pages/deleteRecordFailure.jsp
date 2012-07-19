<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="ru.home.guestbook.guestbookRecords.GuestbookRecord" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Failed deletion</title>
	</head>
	
	<body>
		
		<jsp:include page="/head.jsp"/>
		
		<p>
		Message ${recordId} hasn't been deleted.
		<a href="/guestbook/DeleteMessage/${recordId}">Try again</a>
		</p>
		
		<a href="/guestbook/">Back to main page</a>
		
	</body>
</html>