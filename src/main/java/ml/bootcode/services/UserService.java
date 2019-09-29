/**
 * 
 */
package ml.bootcode.services;

import java.util.List;

import ml.bootcode.dtos.UserDto;

/**
 * @author sunnyb
 *
 */
public interface UserService {

	List<UserDto> getUsers();

	UserDto getUser(Long id);

	UserDto addUser(UserDto userDto);

	UserDto updateUser(Long id, UserDto userDto);

	void deleteUser(Long id);
}
