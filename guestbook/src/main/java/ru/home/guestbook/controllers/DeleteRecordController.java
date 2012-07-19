package ru.home.guestbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ru.home.guestbook.database.DatabaseEngine;

@Controller
@RequestMapping("/DeleteMessage/*")
public class DeleteRecordController
{
	@RequestMapping(value="/{recordIdToDelete}", method = RequestMethod.GET)
	public ModelAndView processRecordDeletion (@PathVariable int recordIdToDelete)
	{			
		ModelMap model = new ModelMap();
    	model.put("recordId",recordIdToDelete);
		
		DatabaseEngine dbEngine = new DatabaseEngine();		
		try
		{
			dbEngine.deleteRecord(recordIdToDelete);
		}
		catch (Exception e)
		{
	    	ModelAndView mvFailure = new ModelAndView("deleteRecordFailure", model);
	    	return mvFailure;
		}
    	
    	ModelAndView mvSuccess = new ModelAndView("deleteRecordSuccess", model);
    	return mvSuccess;		
	}	
}