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
public class InitAckDto {

	private Long userId;
	private String connectionId;
}
