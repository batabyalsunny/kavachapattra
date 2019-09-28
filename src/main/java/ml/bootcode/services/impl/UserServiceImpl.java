/**
 * 
 */
package ml.bootcode.services.impl;

import org.springframework.stereotype.Service;

import ml.bootcode.dtos.UserDto;
import ml.bootcode.repositories.UserRepository;
import ml.bootcode.services.UserService;

/**
 * @author sunnyb
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	/**
	 * @param userRepository
	 */
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDto addUser(UserDto userDto) {

//		User user = new User();
//		user.setEmail(userDto.getEmail());
//
//		userRepository.save(user);

		return userDto;
	}

}
