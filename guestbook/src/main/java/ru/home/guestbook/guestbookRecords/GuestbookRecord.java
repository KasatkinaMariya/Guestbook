package ru.home.guestbook.guestbookRecords;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="getAllRecordsByDatetime",
			query="Select record From GuestbookRecord record Order by recordDatetime Desc")
public class GuestbookRecord
{
	@Id
	@GeneratedValue
	private int id;
	
	private String guestName;
	private Calendar recordDatetime;
	private String message;
	
	public GuestbookRecord (String guestName, Calendar recordDatetime, String message)
	{
		this.guestName = guestName;
		this.recordDatetime = recordDatetime;
		this.message = message;
	}
	
	public GuestbookRecord ()
	{
	}	
	
	public void setCurrentDatetime ()
	{
		Calendar currentDatetime = Calendar.getInstance();
		recordDatetime = currentDatetime;
	}
	
	public String dateToString ()
	{
		String year = Integer.toString(recordDatetime.get(Calendar.YEAR));
		String month = Integer.toString(recordDatetime.get(Calendar.MONTH)+1);
		String day = Integer.toString(recordDatetime.get(Calendar.DATE));
		
		String strForm = year + "." + month + "." + day;
		return strForm;
	}
	
	public String toString ()
	{
		return "#" + id + " '" + guestName + "' at " + recordDatetime.getTimeInMillis() + ": '" + message + "'\r\n";
	}
	
	public String getGuestName ()
	{
		return guestName;
	}
	
	public String getMessage ()
	{
		return message;
	}
	
	public Calendar getRecordDatetime ()
	{
		return recordDatetime;
	}

	public int getId ()
	{
		return id;
	}

	public void setGuestName (String guestName)
	{
		this.guestName = guestName;
	}

	public void setRecordDatetime (Calendar recordDatetime)
	{
		this.recordDatetime = recordDatetime;
	}

	public void setMessage (String message)
	{
		this.message = message;
	}
	
	
}
