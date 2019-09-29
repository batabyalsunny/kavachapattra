/**
 * 
 */
package ml.bootcode.dtos;

import lombok.Data;

/**
 * @author sunnyb
 *
 */
@Data
public class StartChatAckDto {

	private String chatId;
	private String message;
}
