<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Guestbook AJAX</title>
		
		<script src="/guestbook/js/recordsToHtmlUtils.js"></script>
		<script src="/guestbook/js/ajaxUtils.js"></script>
		<script src="/guestbook/js/jquery-1.7.2.js"></script>
	</head>
	
	<body>
	
		<div id="Records"></div>	
		
		<script>
			
			window.setInterval(function()
						{
							getAndProcessJson("/guestbook/RecordsJson",
												parseRecordsJsonAndPrint);
						},
			1000);
			
			function parseRecordsJsonAndPrint (recordsArrayJson)
			{
				var recordsArray = $.parseJSON(recordsArrayJson);
				var html = recordsArrayToHtml(recordsArray);
				document.getElementById("Records").innerHTML=html;
			}
			
		</script>
	</body>
</html>