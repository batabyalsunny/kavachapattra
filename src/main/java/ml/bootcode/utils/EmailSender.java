/**
 * 
 */
package ml.bootcode.utils;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author sunnyb
 *
 */
@Component
public class EmailSender {

	private MailSender mailSender;

	/**
	 * @param mailSender
	 */
	public EmailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Async
	public void send(String to, String subject, String body) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);

		mailSender.send(message);
	}
}
