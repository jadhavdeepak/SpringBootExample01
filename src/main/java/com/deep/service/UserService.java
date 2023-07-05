package com.deep.service;

import com.deep.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

	User createUser(User users) throws Exception;
	User getUserById(long userId);
	public List<User> getAllUsers();
	User saveUser(User user);
	User deleteUser(Long userId);
}