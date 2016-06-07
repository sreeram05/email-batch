package com.friendsurance.mail;

import com.friendsurance.backend.User;

/**
 * @author sree
 *
 * Implementation Class for the EmailRecipient Interface
 */
public class EmailRecipientInt implements EmailRecipient{
	
	/**
	 * Local variables
	 */
	private User _user;
	private EmailService.MailType _mailtype;

	/**
	 * Constructor
	 * 
	 * @param user		User Object
	 */
	public EmailRecipientInt(User user) {
		super();
		this._user = user;
	}
	
	/* 
	 * Method to get Email
	 */
	public String getEmail() {		
		return _user.getEmail();
	}
	
	/* 
	 * Method to get EmailType
	 */
	public EmailService.MailType getMailType()
	{
		return _mailtype;
	}
	
	/* 
	 * Method to get User
	 */
	public User getUser() {
		return _user;
	}

	/* 
	 * Method to set Email
	 * 
	 * @param mailType		MailType Object/variable
	 */
	public void setEmailType(EmailService.MailType mailType)
	{
		this._mailtype = mailType;
	}

}
