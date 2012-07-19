package ru.home.guestbook.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ru.home.guestbook.database.DatabaseEngine;
import ru.home.guestbook.guestbookRecords.GuestbookRecord;

@Controller
@RequestMapping("/NewMessage")
public class NewRecordFormController
{
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initModel (ModelMap model)
    {
    	GuestbookRecord record = new GuestbookRecord();
    	model.put("record",record);
    	
    	ModelAndView mv = new ModelAndView("newRecordForm", model);
    	return mv;
    }    
    
	@RequestMapping(method = RequestMethod.POST)
	public String processRecordAdding
		(@ModelAttribute("record") GuestbookRecord newRecord, HttpServletRequest request)
	{
		setActualGuestnameAndDatetimeToRecord(newRecord,request);
		
		DatabaseEngine dbEngine = new DatabaseEngine();
		try
		{
			dbEngine.addRecord(newRecord);
		}
		catch (Exception e)
		{
			return "newRecordFailure";
		}
		
		return "newRecordSuccess"; 
	}
	
	private void setActualGuestnameAndDatetimeToRecord
		(GuestbookRecord record, HttpServletRequest actualRequest)
	{
		record.setCurrentDatetime();
		setActualGuestnameToRecord(record,actualRequest);
	}
	
	private void setActualGuestnameToRecord
		(GuestbookRecord record,HttpServletRequest actualRequest)
	{
		String guestName = actualRequest.getUserPrincipal().getName();
		record.setGuestName(guestName);
	}
}
