/**
 * 
 */
package ml.bootcode.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import ml.bootcode.dtos.MessageDto;

/**
 * @author sunnyb
 *
 */
@Controller
public class MessageController {

	@MessageMapping("/send")
	@SendTo("/chat/recieve")
	public MessageDto relay(MessageDto message) {
		return message;
	}
}
