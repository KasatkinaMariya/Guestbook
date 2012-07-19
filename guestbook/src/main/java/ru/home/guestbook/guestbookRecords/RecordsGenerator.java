package ru.home.guestbook.guestbookRecords;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class RecordsGenerator
{
	private static Calendar st_periodStart = new GregorianCalendar(2012,1,1);	
	
	private final static String[] GUEST_NAMES = {"Petya", "Vasya", "Natasha", "Angry", "Pusechka", "Programmer"};
	private final static String[] MESSAGES = {"Hello!",
												"Very nice site! I like it!",
												"Good morning, people! Content is wonderful. Admin has being chosen it queasily for 2 years. Thank you!",
												"The most detestable site I have ever seen. Everything is bad. We are all dead.",
												"Hi, friends! What about swimming and massage this weekend?",
												"When are you going to release a special version for the Bada OS?",
												"See my report from Alps. Many amazing photos in my blog!",
												"I have eaten bit of paper with my password. I can't enter with my login 'Forgetful'. Help me, please."
												};
	
	public List<GuestbookRecord> generateSortedByDate (int recordsNumberToGenerate)
	{		
		List<GuestbookRecord> records = new ArrayList<GuestbookRecord>(recordsNumberToGenerate);

		Random random = new Random();
		for (int i=0; i < recordsNumberToGenerate; i++)
		{
			GuestbookRecord curRecord = generateOneRecord(random);
			records.add(curRecord);
		}
		
		Comparator<GuestbookRecord> cmpByDate = new RecordComparatorByDate();
		Collections.sort(records,cmpByDate);
		
		return records;
	}
	
	private GuestbookRecord generateOneRecord (Random random)
	{
		String guestName = GUEST_NAMES[random.nextInt(GUEST_NAMES.length)];
		String message = MESSAGES[random.nextInt(MESSAGES.length)];		
		Calendar date = generateOneDate(random);
		
		GuestbookRecord record = new GuestbookRecord(guestName,date,message);
		return record;
	}
	
	private static Calendar generateOneDate (Random random)
	{
		long millisAfterStart = random.nextInt() * random.nextInt();	
		long millis = st_periodStart.getTimeInMillis() + millisAfterStart;
		
		Calendar date = new GregorianCalendar();
		date.setTimeInMillis(millis);
		
		return date;
	}
}