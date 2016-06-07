package com.friendsurance.processing;

//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;

import com.friendsurance.mail.EmailRecipientInt;
import com.friendsurance.mail.EmailService;

/**
 * @author sree
 *
 * Implementation for the ItemWriter Interface
 */
public class ItemWriterInt implements ItemWriter<EmailRecipientInt>{
	
	EmailService _emailSerice;

	/**
	 * Constructor
	 * 
	 * @param _emailSericeInt		EmailServiceInt Object
	 */
	public ItemWriterInt(EmailService emailSerice) {
		super();
		this._emailSerice = emailSerice;
	}

	
	/* 
	 *	Method to write the mail in file and to send email
	 * @param email		EmailRecipientInt Object
	 */
	public void write(EmailRecipientInt email) {
		
		
//	      try {
//	    	  File file = new File("Email.txt");
//		      // creates the file
//			file.createNewFile();
//			 // creates a FileWriter Object
//		      FileWriter writer = new FileWriter(file); 
//		      // Writes the content to the file
//		      writer.write("Email");
//		      writer.write(email.getEmail());
//		      writer.write(email.getMailType().toString());
//		      writer.flush();
//		      writer.close();
//		} catch (IOException ioExp) {
//			ioExp.printStackTrace();
//		}

		_emailSerice.sendMail(email, email.getMailType());		
	}

}
