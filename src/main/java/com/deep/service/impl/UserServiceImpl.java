package com.deep.service.impl;

import com.deep.dto.UserDto;
import com.deep.exception.UserNotFoundException;
import com.deep.repository.AddressRepository;
import com.deep.repository.UserRoleRepository;
import org.modelmapper.ModelMapper;

import com.deep.entity.User;
import com.deep.repository.UserRepository;
import com.deep.service.UserService;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserRepository userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ModelMapper modelMapper;

	private UserDto mapUserToUserDetailsDto(User user){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		UserDto userRequest = new UserDto();
		userRequest = modelMapper.map(user, UserDto.class);
		return userRequest;
	}

	private User mapUserDetailsDtoToUser(UserDto userDto){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		User userResponce = new User();
		userResponce = modelMapper.map(userDto, User.class);
		return userResponce;
	}

	@Override
	public UserDto createUser(UserDto userRequest) throws UserNotFoundException {

		User user = mapUserDetailsDtoToUser(userRequest);
		Optional<User> userName = userRepository.findByUserName(user.getUserName());
		if (userName.isPresent() || !userName.isEmpty()){
			throw new UserNotFoundException("User is already present");
		}
		User savedUser = userRepository.save(user);
		UserDto userResponce = mapUserToUserDetailsDto(savedUser);
		return userResponce;
	}

	@Override
	public User getUserById(long userId) {

		/*Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()){
			return user.get();
		}else {
			throw new ResourceNotFoundException("User", "userId", userId);
		}*/

		/*return userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User", "userId", userId));*/
		return  null;
	}

	@Override
	public Set<UserDto> getAllUsers() {
		if (userRepository.findAll().isEmpty())
			System.out.println("User not available in the database");
		Set<UserDto> userSet = (Set<UserDto>) userRepository.findAll()
				.stream()
				.map(this::mapUserToUserDetailsDto)
				.collect(Collectors.toList());
//		userSet.sort((o1, o2) -> o1.getUserId().compareTo(o2.getUserId()));
		return userSet;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User deleteUser(Long userId) {
/*		if (userRepository.findById(userId)==null)
			System.out.println("User not available");
		else
			userRepository.deleteById(userId);*/
		return null;
	}
}