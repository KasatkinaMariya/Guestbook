function getAndProcessJson (urlToJsonService,jsonHandler)
{
	var xmlhttp = getXmlHttp();
	
	xmlhttp.open("GET", urlToJsonService, true);
	xmlhttp.setRequestHeader('Accepts','application/json');
	
	xmlhttp.onreadystatechange=function() 
	{
		if ((xmlhttp.readyState == 4)
				&& (xmlhttp.status == 200))
		{				
			var json = xmlhttp.responseText;
			jsonHandler(json);
		}				
	};
	
	xmlhttp.send(null);
}

function getXmlHttp ()
{
	try
	{
		return new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try
		{
			return new ActiveXObject("Microsoft.XMLHTTP");
		} catch (e)	{
			try
			{
				return new XMLHttpRequest();
			} catch (e) {
				document.getElementById("Message").innerHTML="<h1>Bad XmlHttp</h1>";
			}
		}
	}
}