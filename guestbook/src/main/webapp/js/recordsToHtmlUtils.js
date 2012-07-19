function recordsArrayToHtml (recordsArray)
{
	var htmlAccumulator = "";
	
	for(var i=0; i<recordsArray.length; i++)
	{
		var curRecord = recordsArray[i];
		var curRecordHtml = oneRecordToHtml(curRecord);
		
		htmlAccumulator += curRecordHtml;
	}
	
	return htmlAccumulator;
}

function oneRecordToHtml (record)
{
	var guestname = record.guestName;
	var datetimeMillis = record.recordDatetime;
	var message = record.message;
	
	var date = millisToDate(datetimeMillis);
	var title = guestname + " on " + date;
	var html = "<p><b>" + title + ":</b><br>" + message + "</p>";
	
	return html;
}

function millisToDate (millis)
{
	var datetimeObj = new Date(millis);
	var date = datetimeObj.getFullYear() + "."
				+ datetimeObj.getMonth() + "."
				+ datetimeObj.getDate();
	
	return date;
}