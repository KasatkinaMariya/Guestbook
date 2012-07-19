package ru.home.guestbook.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ru.home.guestbook.guestbookRecords.GuestbookRecord;
import ru.home.guestbook.guestbookRecords.RecordsGenerator;

public class DatabaseEngine
{
	private static final int INITIAL_RECORDS_NUMBER = 20;
	private static EntityManagerFactory st_factory = Persistence.createEntityManagerFactory("pUnit");

	public DatabaseEngine ()
	{
		if ( isEmpty() )
		{
			persistInitialRecords();
		}
	}
	
	public void addRecord (GuestbookRecord recordToAdd)
	{
		persistOneRecord(recordToAdd);
	}
	
	public void deleteRecord (int idToDelete)
		throws IllegalArgumentException
	{
		EntityManager manager = st_factory.createEntityManager();
		
		GuestbookRecord recordToDelete = manager.find(GuestbookRecord.class, idToDelete);

		try
		{
			EntityTransaction tr = manager.getTransaction();		
			tr.begin();
			manager.remove(recordToDelete);
			tr.commit();
		}
		finally
		{
			manager.close();
		}
	}
	
	public List<GuestbookRecord> getAllRecordsByDatetime ()
	{
		EntityManager manager = st_factory.createEntityManager();
		Query allByDatetimeQuery = manager.createNamedQuery("getAllRecordsByDatetime");
		List<GuestbookRecord> recordsByDatetime = allByDatetimeQuery.getResultList();
		manager.close();
		
		return recordsByDatetime;
	}
	
	public void persistInitialRecords ()
	{
		List<GuestbookRecord> initialRecords = getInitialRecords();
		persistRecords(initialRecords);
	}
	
	private List<GuestbookRecord> getInitialRecords ()
	{
		RecordsGenerator recordsGen = new RecordsGenerator(); 
		List<GuestbookRecord> initialRecords = recordsGen.generateSortedByDate(INITIAL_RECORDS_NUMBER);
		
		return initialRecords;
	}
	
	private void persistRecords (List<GuestbookRecord> recordsToPersist)
	{
		EntityManager manager = st_factory.createEntityManager();
		EntityTransaction tr = manager.getTransaction();		
		tr.begin();
		
		for (GuestbookRecord curRecord : recordsToPersist)
		{
			manager.persist(curRecord);
		}
		
		tr.commit();
		manager.close();
	}
	
	private void persistOneRecord (GuestbookRecord recordToPersist)
	{
		EntityManager manager = st_factory.createEntityManager();
		EntityTransaction tr = manager.getTransaction();		
		tr.begin();
		
		manager.persist(recordToPersist);
		
		tr.commit();
		manager.close();
	}
	
	private boolean isEmpty ()
	{
		return getAllRecordsByDatetime().isEmpty();
	}
}
