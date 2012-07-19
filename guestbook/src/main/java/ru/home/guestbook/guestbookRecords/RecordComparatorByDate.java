package ru.home.guestbook.guestbookRecords;

import java.util.Calendar;
import java.util.Comparator;

public class RecordComparatorByDate
	implements Comparator<GuestbookRecord>
{
	public int compare (GuestbookRecord record1, GuestbookRecord record2)
	{
		Calendar date1 = record1.getRecordDatetime();
		Calendar date2 = record2.getRecordDatetime();	
		
		long millis1 = date1.getTimeInMillis();
		long millis2 = date2.getTimeInMillis();
		
		int sign = (int)Math.signum(millis1 - millis2);
		return sign;
	}
}
