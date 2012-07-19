package ru.home.guestbook.testUtils;

import java.util.Hashtable;

import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.ui.ModelMap;

//@Controller
//@RequestMapping("/Passwords")
public class PasswordEncoderController
{
	public String encodePasswords (ModelMap model)
	{
		String[] plainPasswords = {"admin", "user"};		
		int passwordsNumber = plainPasswords.length;
		Hashtable<String,String> plainToEncoded = new Hashtable<String,String>(passwordsNumber);
		
		for (String curPlain : plainPasswords)
		{
			String curEncoded = encodeOneString(curPlain);
			plainToEncoded.put(curPlain,curEncoded);			
		}
		
		model.put("plainToEncoded", plainToEncoded);
		return "passwords";
	}
	
	private String encodeOneString (String plainToEncode)
	{
		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
		String encoded = encoder.encode(plainToEncode);
		
		return encoded;
	}
}
