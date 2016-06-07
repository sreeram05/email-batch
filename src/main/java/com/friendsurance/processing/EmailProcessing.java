package com.friendsurance.processing;

import com.friendsurance.backend.User;
import com.friendsurance.mail.EmailRecipientInt;
import com.friendsurance.mail.EmailService;


/**
 * @author sree
 *
 * Implementation or Subclass for ItemProcessing 
 */
public class EmailProcessing extends ItemProcessing<EmailRecipientInt, EmailRecipientInt>{

	private EmailService.MailType _mailType;
	
	/**
	 * @param reader	ItemReader Object
	 * @param writer	ItemWriter Object
	 */
	public EmailProcessing(ItemReader<EmailRecipientInt> reader, ItemWriter<EmailRecipientInt> writer) {
		super(reader, writer);		
	}

	/* 
	 * Overridden Method from Abstract Class ItemProcessing
	 * to Process Email for batch
	 * 
	 */
	@Override
	protected EmailRecipientInt process(EmailRecipientInt mail) {

		if (null != mail){
			_mailType = this.getEmail(mail);
			mail.setEmailType(_mailType);			
		}
		return mail;
	}

	/**
	 * Method is to calculate Mail Priority or Type
	 *  
	 * @param email			Object of EmailRecipientInt Class
	 * @return _mailType	MailType Object
	 */
	private EmailService.MailType getEmail(EmailRecipientInt email) {
		User _user = email.getUser();
	
		if (null != _user){
			
			if (_user.hasContract() && _user.getFriendsNumber() > 4 && _user.getSentInvitationsNumber() > 3 ){
				email.setEmailType(EmailService.MailType.MAIL_TYPE_5);
				return email.getMailType();
			}			
			else if (_user.hasContract() && _user.getFriendsNumber() > 1 && _user.getSentInvitationsNumber() == 0){
				email.setEmailType(EmailService.MailType.MAIL_TYPE_4);
				return email.getMailType();
			}			
			else if ((_user.hasContract() && _user.getFriendsNumber() == 0 && _user.getSentInvitationsNumber() == 0)
					|| (_user.hasContract() && _user.getFriendsNumber() == 0 && _user.getSentInvitationsNumber() > 3)
					|| ((!_user.hasContract()) && _user.getFriendsNumber() < 3 && _user.getFriendsNumber() > 6)
					|| ((!_user.hasContract()) && _user.getFriendsNumber() > 1 && _user.getFriendsNumber() == 0)){
				email.setEmailType(EmailService.MailType.MAIL_TYPE_3);
				return email.getMailType();
			}			
			else if (((!_user.hasContract()) && _user.getFriendsNumber() == 0 && _user.getFriendsNumber() == 0)
					|| ((!_user.hasContract()) && _user.getFriendsNumber() < 3 && _user.getFriendsNumber() > 1)){
				email.setEmailType(EmailService.MailType.MAIL_TYPE_2);
				return email.getMailType();
			}			
			else if (!_user.hasContract() && _user.getFriendsNumber() > 3 && _user.getSentInvitationsNumber() > 1){
				email.setEmailType(EmailService.MailType.MAIL_TYPE_1);
				return email.getMailType();
			}
		}
		return null;
	}
}
