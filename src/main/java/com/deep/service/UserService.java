package com.deep.service;

import com.deep.model.User;

import java.util.List;

public interface UserService {

	User createUser(User users) throws Exception;

	User getUserById(long userId);
	public List<User> getAllUsers();

	User saveUser(User user);

	void deleteUser(Long userId);
}