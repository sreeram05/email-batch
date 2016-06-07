package com.friendsurance.processing;

import java.util.Iterator;

import com.friendsurance.mail.EmailRecipientInt;


/**
 * @author sree
 *
 * Implementation for the ItemReader Interface
 */
public class ItemReaderInt implements ItemReader<EmailRecipientInt>{

	/**
	 * Local Variable
	 */
	private Iterator<EmailRecipientInt> _iterator;	
	
	
	/**
	 * Constructor
	 * 
	 * @param _iterator		Iterator Object 
	 */
	public ItemReaderInt(Iterator<EmailRecipientInt> iterator) {
		super();
		this._iterator = iterator;
	}


	/* 
	 * Method to read the new Item for processing
	 * 
	 */
	public EmailRecipientInt read() {		
		if(_iterator.hasNext()){
			return _iterator.next();
		}
		else{
			return null;
		}
	}

}
