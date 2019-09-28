/**
 * 
 */
package ml.bootcode.dtos;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ml.bootcode.models.User;

/**
 * @author sunnyb
 *
 */
public class ChatRoomDto {

	private String name;

	@JsonIgnore
	private User owner;
	private Set<UserDto> members;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the owner
	 */
	public User getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}

	/**
	 * @return the members
	 */
	public Set<UserDto> getMembers() {
		return members;
	}

	/**
	 * @param members the members to set
	 */
	public void setMembers(Set<UserDto> members) {
		this.members = members;
	}
}
