/**
 * 
 */
package ml.bootcode.services;

import ml.bootcode.dtos.InitAckDto;

/**
 * @author sunnyb
 *
 */
public interface MessageService {

	InitAckDto initChat(InitAckDto init);
}
