/**
 * 
 */
package ml.bootcode.controllers;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import ml.bootcode.dtos.MessageDto;

/**
 * @author sunnyb
 *
 */
@Controller
public class MessageController {

	@MessageMapping("/send/{id}")
	@SendTo("/chat/recieve/{id}")
	public MessageDto relay(@DestinationVariable String id, MessageDto message) {
		return message;
	}

	@SubscribeMapping("/direct")
	public MessageDto direct() {
		MessageDto message = new MessageDto();
		message.setContent("Welcome");
		return message;
	}
}
