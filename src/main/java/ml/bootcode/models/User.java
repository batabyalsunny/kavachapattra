/**
 * 
 */
package ml.bootcode.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * @author sunnyb
 *
 */
@Entity
public class User {

	private Long id;
	private String email;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private Set<ChatRoom> myRooms;

	@ManyToMany(mappedBy = "members")
	private Set<ChatRoom> memberOfRooms;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
	public Set<ChatRoom> getMyRooms() {
		return myRooms;
	}

	/**
	 * @param myRooms the myRooms to set
	 */
	public void setMyRooms(Set<ChatRoom> myRooms) {
		this.myRooms = myRooms;
	}

	/**
	 * @return the memberOfRooms
	 */
	public Set<ChatRoom> getMemberOfRooms() {
		return memberOfRooms;
	}

	/**
	 * @param memberOfRooms the memberOfRooms to set
	 */
	public void setMemberOfRooms(Set<ChatRoom> memberOfRooms) {
		this.memberOfRooms = memberOfRooms;
	}
}
