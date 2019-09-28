package ml.bootcode.services.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import ml.bootcode.dtos.ChatRoomDto;
import ml.bootcode.dtos.InviteDto;
import ml.bootcode.exceptions.ApiException;
import ml.bootcode.models.ChatRoom;
import ml.bootcode.models.User;
import ml.bootcode.repositories.ChatRoomRepository;
import ml.bootcode.repositories.UserRepository;
import ml.bootcode.services.ChatRoomService;
import ml.bootcode.utils.EmailSender;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {

	private ChatRoomRepository chatRoomRepository;
	private UserRepository userRepository;
	private EmailSender emailSender;

	/**
	 * @param chatRoomRepository
	 * @param userRepository
	 * @param emailSender
	 */
	public ChatRoomServiceImpl(ChatRoomRepository chatRoomRepository, UserRepository userRepository,
			EmailSender emailSender) {
		this.chatRoomRepository = chatRoomRepository;
		this.userRepository = userRepository;
		this.emailSender = emailSender;
	}

	@Override
	public ChatRoomDto addChatRoom(ChatRoomDto chatRoomDto) {

		ChatRoom chatRoom = new ChatRoom();

		chatRoom.setName(chatRoomDto.getName());
		chatRoom.setOwner(chatRoomDto.getOwner());

		chatRoom.setMembers(new HashSet<>(Arrays.asList(chatRoom.getOwner())));

		chatRoomRepository.save(chatRoom);

		return chatRoomDto;
	}

	@Override
	public void invite(Long roomId, InviteDto inviteDto, HttpServletRequest request) throws ApiException {

		// Validate room Id.
		ChatRoom room = validate(roomId);

		// Get the user if exists.
		Optional<User> userOptional = userRepository.findByEmail(inviteDto.getEmail());

		// If user exists check if its already a member.
		if (userOptional.isPresent()) {
			User user = userOptional.get();

			// User is already a member.
			if (room.getMembers().contains(user)) {
				throw new ApiException("User is already a member of this room");
			}
		}

		// Get the chat room join URL.
		String joinUrl = request.getRequestURL().toString();
		joinUrl = StringUtils.replace(joinUrl, "invite", "join");

		// Send invite email.
		emailSender.send(inviteDto.getEmail(), "Join the meeting",
				"Please join the meeting by clicking <a href='" + joinUrl + ">hear</a>");
	}

	@Override
	public void joinRoom(InviteDto inviteDto) {
		// TODO Auto-generated method stub

	}

	public ChatRoom validate(Long id) throws ApiException {

		Optional<ChatRoom> chatRoomOptional = chatRoomRepository.findById(id);

		if (!chatRoomOptional.isPresent()) {
			throw new ApiException("Room not found");
		}

		return chatRoomOptional.get();
	}

}
