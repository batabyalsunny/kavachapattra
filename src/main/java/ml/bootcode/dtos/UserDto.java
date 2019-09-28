/**
 * 
 */
package ml.bootcode.dtos;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author sunnyb
 *
 */
public class UserDto {

	private String email;
	private Set<ChatRoomDto> myRooms;
	@JsonIgnore
	private Set<ChatRoomDto> memberOfRooms;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the myRooms
	 */
	public Set<ChatRoomDto> getMyRooms() {
		return myRooms;
	}

	/**
	 * @param myRooms the myRooms to set
	 */
	public void setMyRooms(Set<ChatRoomDto> myRooms) {
		this.myRooms = myRooms;
	}

	/**
	 * @return the memberOfRooms
	 */
	public Set<ChatRoomDto> getMemberOfRooms() {
		return memberOfRooms;
	}

	/**
	 * @param memberOfRooms the memberOfRooms to set
	 */
	public void setMemberOfRooms(Set<ChatRoomDto> memberOfRooms) {
		this.memberOfRooms = memberOfRooms;
	}
}
