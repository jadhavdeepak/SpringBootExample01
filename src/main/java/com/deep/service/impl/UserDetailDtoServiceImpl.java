package com.deep.service.impl;

import com.deep.dto.UserDetailsDTO;
import com.deep.entity.User;
import com.deep.repository.UserRepository;
import com.deep.repository.UserRoleRepository;
import com.deep.service.UserDetailDtoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailDtoServiceImpl implements UserDetailDtoService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    private UserRoleRepository addressRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private ModelMapper modelMapper;

    private UserDetailsDTO convertUserToUserDetailsDto(User user){
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setUserId(user.getUserId());
        userDetailsDTO.setUserName(user.getUserName());
        userDetailsDTO.setUserEmail(user.getUserEmail());
//        userDetailsDTO.setCity(user.getAddresses().getCity());
//        userDetailsDTO.setRoleName(user.getUserRoles().getRoleName());
        return userDetailsDTO;
    }

    @Override
    public List<UserDetailsDTO> getAllUserDetailsDto() {
        return userRepository.findAll()
                .stream()
                .map(this::convertUserToUserDetailsDto)
                .collect(Collectors.toList());
    }
}
