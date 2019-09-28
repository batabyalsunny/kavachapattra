/**
 * 
 */
package ml.bootcode.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * @author sunnyb
 *
 */
@Entity
@Data
public class Message {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String content;
	private String chatId;

	@ManyToOne
	private User sender;
}
