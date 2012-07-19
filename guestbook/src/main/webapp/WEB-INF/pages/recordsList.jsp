<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ page import="ru.home.guestbook.guestbookRecords.GuestbookRecord" %>
<%@ page import="java.util.List" %>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Guestbook</title>
	</head>
	
	<body>	
		<jsp:include page="/head.jsp"/>

		<a href="/guestbook/NewMessage/">Add message</a> <br>

		<%
			List<GuestbookRecord> records = (List<GuestbookRecord>)request.getAttribute("recordsList");

			for (GuestbookRecord curRecord : records)
			{
				String messageTitle = curRecord.getGuestName() + " on " + curRecord.dateToString() + ":";
				String messageContent = curRecord.getMessage();
				%>
				
				<p>	<b> <%= messageTitle %> </b>
				
				<sec:authorize access="hasRole('admin')">
					<% int recordId = curRecord.getId(); %>	
					<a href="/guestbook/DeleteMessage/<%=recordId%>">delete</a>		
				</sec:authorize>
		
				<br>
				<%= messageContent %> </p>
				<%
			}
		%>

	</body>
</html>
