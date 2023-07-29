package com.deep.service;

import com.deep.dto.UserDto;
import com.deep.entity.User;
import com.deep.exception.UserNotFoundException;

import java.util.Set;

public interface UserService {

	public UserDto createUser(UserDto userRequest) throws UserNotFoundException;
	User getUserById(long userId);
	public Set<UserDto> getAllUsers();
	User saveUser(User user);
	User deleteUser(Long userId);
}