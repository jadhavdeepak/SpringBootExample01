package com.deep.serviceImpl;

import com.deep.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deep.entity.User;
import com.deep.repository.UserRepository;
import com.deep.service.UserService;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserRepository userRepository;

	@Override
	public User createUser(User users) throws Exception {

		User user = userRepository.findByUsername(users.getUsername());

		if (user != null) {
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
		if (userRepository.findAll().isEmpty())
			System.out.println("User not available in the database");
		List<User> userlist = (List<User>) userRepository.findAll();
		userlist.sort((o1, o2) -> o1.getUserId().compareTo(o2.getUserId()));
		return userlist;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User deleteUser(Long userId) {
		if (userRepository.findById(userId)==null)
			System.out.println("User not available");
		else
			userRepository.deleteById(userId);
		return null;
	}
}