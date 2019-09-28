/**
 * 
 */
package ml.bootcode.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ml.bootcode.dtos.UserDto;
import ml.bootcode.services.UserService;

/**
 * @author sunnyb
 *
 */
@RestController
@RequestMapping("users")
public class UserController {

	private UserService userService;

	@Value("${ml.bootcode.message}")
	private String message;

	/**
	 * @param userService
	 */
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public UserDto addUser(@RequestBody UserDto userDto) {
		return userService.addUser(userDto);
	}

	@GetMapping
	public String getMessage() {
		return message;
	}
}
