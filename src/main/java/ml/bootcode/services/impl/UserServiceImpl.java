/**
 * 
 */
package ml.bootcode.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import ml.bootcode.dtos.UserDto;
import ml.bootcode.models.User;
import ml.bootcode.repositories.UserRepository;
import ml.bootcode.services.UserService;
import ml.bootcode.utils.EntityValidator;

/**
 * @author sunnyb
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private ModelMapper mapper;
	private EntityValidator<User> entityValidator;

	/**
	 * @param userRepository
	 * @param mapper
	 * @param entityValidator
	 */
	public UserServiceImpl(UserRepository userRepository, ModelMapper mapper, EntityValidator<User> entityValidator) {
		this.userRepository = userRepository;
		this.mapper = mapper;
		this.entityValidator = entityValidator;
	}

	@Override
	public List<UserDto> getUsers() {

		return userRepository.findAll().stream().map(user -> {
			return mapper.map(user, UserDto.class);
		}).collect(Collectors.toList());
	}

	@Override
	public UserDto getUser(Long id) {
		return mapper.map(userRepository.findById(id), UserDto.class);
	}

	@Override
	public UserDto addUser(UserDto userDto) {
		return mapper.map(userRepository.save(mapper.map(userDto, User.class)), UserDto.class);
	}

	@Override
	public UserDto updateUser(Long id, UserDto userDto) {

		entityValidator.validate(userRepository.findById(id));

		User user = mapper.map(userDto, User.class);
		user.setId(id);

		return mapper.map(userRepository.save(user), UserDto.class);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.delete(entityValidator.validate(userRepository.findById(id)));
	}

}
