/**
 * 
 */
package ml.bootcode.services;

import javax.servlet.http.HttpServletRequest;

import ml.bootcode.dtos.ChatRoomDto;
import ml.bootcode.dtos.InviteDto;
import ml.bootcode.exceptions.ApiException;

/**
 * @author sunnyb
 *
 */
public interface ChatRoomService {

	ChatRoomDto addChatRoom(ChatRoomDto chatRoomDto);

	void invite(Long roomId, InviteDto inviteDto, HttpServletRequest request) throws ApiException;

	void joinRoom(InviteDto inviteDto);
}
