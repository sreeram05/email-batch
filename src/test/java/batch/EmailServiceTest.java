/**
 * 
 */
package batch;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.friendsurance.backend.User;
import com.friendsurance.mail.EmailRecipient;
import com.friendsurance.mail.EmailRecipientInt;
import com.friendsurance.mail.EmailService;
import com.friendsurance.processing.EmailProcessing;
import com.friendsurance.processing.ItemReaderInt;
import com.friendsurance.processing.ItemWriterInt;

/**
 * @author sree
 *
 *Junit Test case to test the Email Service or Batch
 *
 */
public class EmailServiceTest {

	class TestService implements EmailService {  
	       private List<String> emails = new ArrayList<String>();  
	       
	       public void sendMail(EmailRecipient recipient, MailType mailType) {  
			   emails.add(recipient.getEmail() + "_" + String.valueOf(mailType));  
	       }  
	   }  

	   ArrayList<EmailRecipientInt> users = new ArrayList<EmailRecipientInt>();  
	   TestService _testService = new TestService();  
	   ItemWriterInt _ItemWriterInt = new ItemWriterInt(_testService);  

	  @Test  
	  public void testEmails(){  
	   users.add(new EmailRecipientInt(new User("123@abc.com", true, 0, 0)));
	   users.add(new EmailRecipientInt(new User("456@abc.com", true, 0, 4)));
	   users.add(new EmailRecipientInt(new User("789@abc.com", false, 0, 0)));
	   users.add(new EmailRecipientInt(new User("0123@abc.com", true, 2, 0)));
	   users.add(new EmailRecipientInt(new User("475@abc.com", true, 5, 6)));
	   users.add(new EmailRecipientInt(new User("6748@abc.com", false, 5, 2)));
	   ItemReaderInt _ItemReaderInt = new ItemReaderInt(users.iterator());
	   EmailProcessing _EmailProcessing = new EmailProcessing(_ItemReaderInt, _ItemWriterInt);
	   
	   _EmailProcessing.doProcessing();
	   //assertTrue(_testService.emails.get(0).equals(_testService.emails.get(0)));
	   assertEquals("Mail Type 3", _testService.emails.get(0).toString(), "123@abc.com_MAIL_TYPE_3");
	   assertEquals("Mail Type 3", _testService.emails.get(1).toString(), "456@abc.com_MAIL_TYPE_3");
	   assertEquals("Mail Type 2", _testService.emails.get(2).toString(), "789@abc.com_MAIL_TYPE_2");
	   assertEquals("Mail Type 4", _testService.emails.get(3).toString(), "0123@abc.com_MAIL_TYPE_4");
	   assertEquals("Mail Type 5", _testService.emails.get(4).toString(), "475@abc.com_MAIL_TYPE_5");
	   assertEquals("Mail Type 1", _testService.emails.get(5).toString(), "6748@abc.com_MAIL_TYPE_1");
	   }
}
