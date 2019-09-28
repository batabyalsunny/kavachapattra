/**
 * 
 */
package ml.bootcode.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ml.bootcode.dtos.ChatRoomDto;
import ml.bootcode.dtos.InviteDto;
import ml.bootcode.exceptions.ApiException;
import ml.bootcode.services.ChatRoomService;

/**
 * @author sunnyb
 *
 */
@RestController
@RequestMapping("rooms")
public class ChatRoomController {

	private ChatRoomService chatRoomService;

	/**
	 * @param chatRoomService
	 */
	public ChatRoomController(ChatRoomService chatRoomService) {
		this.chatRoomService = chatRoomService;
	}

	@PostMapping
	public ChatRoomDto addRoom(@RequestBody ChatRoomDto chatRoomDto) {
		return chatRoomService.addChatRoom(chatRoomDto);
	}

	@PostMapping("{id}/invite")
	public void invite(@PathVariable Long id, @RequestBody InviteDto inviteDto, HttpServletRequest request)
			throws ApiException {
		chatRoomService.invite(id, inviteDto, request);
	}
}
