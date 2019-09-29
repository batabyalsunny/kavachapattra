/**
 * 
 */
package ml.bootcode.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import ml.bootcode.dtos.InitAckDto;
import ml.bootcode.dtos.MessageDto;
import ml.bootcode.services.MessageService;

/**
 * @author sunnyb
 *
 */
@Controller
public class MessageController {

	private MessageService messageService;

	/**
	 * @param messageService
	 */
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}

	@MessageMapping("/init")
	@SendTo("/queue/init/ack")
	public InitAckDto init(InitAckDto message) {
		return messageService.initChat(message);
	}

	@MessageMapping("/send/{id}")
	@SendTo("/queue/recieve/{id}")
	public MessageDto send(MessageDto message) {
		return message;
	}

	@SubscribeMapping("/direct")
	public MessageDto direct() {
		MessageDto message = new MessageDto();
		message.setContent("Welcome");
		return message;
	}
}
