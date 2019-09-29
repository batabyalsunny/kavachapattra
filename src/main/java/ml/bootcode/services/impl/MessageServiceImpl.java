/**
 * 
 */
package ml.bootcode.services.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import ml.bootcode.dtos.InitAckDto;
import ml.bootcode.models.User;
import ml.bootcode.repositories.UserRepository;
import ml.bootcode.services.MessageService;
import ml.bootcode.utils.EntityValidator;

/**
 * @author sunnyb
 *
 */
@Service
public class MessageServiceImpl implements MessageService {

	private UserRepository userRepository;
	private EntityValidator<User> userEntityValidator;

	/**
	 * @param userRepository
	 * @param userEntityValidator
	 */
	public MessageServiceImpl(UserRepository userRepository, EntityValidator<User> userEntityValidator) {
		this.userRepository = userRepository;
		this.userEntityValidator = userEntityValidator;
	}

	@Override
	public InitAckDto initChat(InitAckDto init) {

		String chatId;

		User user = userEntityValidator.validate(userRepository.findById(init.getUserId()));

		// Check if user already has chat id.
		if (user.getChatId() != null) {
			chatId = user.getChatId();
		} else {

			// Generate chat Id by hashing user id.
			chatId = DigestUtils.sha256Hex(user.getId().toString());
		}

		// Set chat Id as connection id.
		init.setConnectionId(chatId);

		return init;
	}

}
