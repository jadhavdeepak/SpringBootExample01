package com.deep;

import com.deep.dto.UserDto;
import com.deep.entity.Address;
import com.deep.entity.User;
import com.deep.entity.UserRole;
import com.deep.repository.AddressRepository;
import com.deep.repository.UserRepository;
import com.deep.repository.UserRoleRepository;
import com.deep.service.AddressService;
import com.deep.service.UserRoleService;
import com.deep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class SpringBootProject {
/*	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject.class, args);
	}

/*	@Override
	public void run(String... args) {
		System.out.println("Project Started !!");

		UserRole userRole = new UserRole();
		userRole.setRoleId(1l);
		userRole.setRoleName("ADMIN");
		userRole.setRoleDesc("Administrator");
//		userRoleService.saveUserRole(userRole);
//		userRoleRepository.save(userRole);

		Address address = new Address();
		address.setAddressId(101l);
		address.setStreet("Manaji Nagar");
		address.setCity("Pune");
		address.setPinCode(411041);
//		addressService.saveAddress(address);
//		addressRepository.save(address);

		User users = new User();
		users.setUserId(111l);
		users.setFirstName("Deepak");
		users.setLastName("Jadhav");
		users.setUserName("Deepak Jadhav");
		users.setPassword("password");
		users.setUserEmail("jadhavdeepak.dj@gmail.com");
		users.setPhone("9767770809");
		users.setUserRoles((Set<UserRole>) userRole);
		users.setAddresses((Set<Address>) address);
//		userService.saveUser(users);
		userRepository.save(users);
		System.out.println(users.getUserName());

	}*/

}