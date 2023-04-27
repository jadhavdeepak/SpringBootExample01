package com.deep.serviceImpl;

import com.deep.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deep.model.User;
import com.deep.repository.userRepository;
import com.deep.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public userRepository userRepository;

	@Override
	public User createUser(User users) throws Exception {

		User user = userRepository.findByUsername(users.getUsername());
		if (user != null) {
			System.out.println("User is already there !");
			throw new Exception("User is already present !");
		} else {
			user = userRepository.save(users);
		}
		return user;
	}

	@Override
	public User getUserById(long userId) {
		/*Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()){
			return user.get();
		}else {
			throw new ResourceNotFoundException("User", "userId", userId);
		}*/

		return userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User", "userId", userId));
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}
}