package ru.home.guestbook.controllers;

import java.util.Hashtable;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ru.home.guestbook.database.DatabaseEngine;
import ru.home.guestbook.guestbookRecords.GuestbookRecord;

@Controller
@RequestMapping("*")
public class MainController
{	
	private static DatabaseEngine st_dbEngine = new DatabaseEngine();
	
	@RequestMapping("/Live")
	public String handleWithAjax ()
	{
		return "recordsListAjax";
	}
	
	@RequestMapping("*")
	public ModelAndView handle ()
	{		
		try
		{	
			Map<String,Object>	map = new Hashtable<String,Object>();
			map.put("recordsList",st_dbEngine.getAllRecordsByDatetime());
			map.put("record", new GuestbookRecord());
			
			ModelAndView mv = new ModelAndView("recordsList",map);
			return mv;
		}
		catch (Exception e)
		{
			return constructExceptionMV(e);
		}
	}
	
	@RequestMapping("head.jsp")
	public String drawHead ()
	{
		return "head";
	}
	
	private ModelAndView constructExceptionMV (Exception e)
	{
		Map<String,Object>	map = new Hashtable<String,Object>();
		map.put("message",e.getMessage());
		map.put("st",stToString(e));
		
		ModelAndView mv = new ModelAndView("error",map);
		return mv;
	}
	
	private String stToString (Exception e)
	{
		StackTraceElement[] stArray = e.getStackTrace();
		
		StringBuilder builder = new StringBuilder();
		for (int i=0; i < stArray.length; i++)
		{
			String curElement = stArray[i].toString();
			builder.append(curElement);
			builder.append("\r\n");
		}
		
		return builder.toString();
	}	
}