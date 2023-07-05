package com.deep;

import com.deep.repository.UserRepository;
import com.deep.serviceImpl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.security.RunAs;

@SpringBootTest
class SpringBootCrudApplicationTests {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	public com.deep.repository.UserRepository userRepository;

	@Test
	void contextLoads() {
		System.out.println("Tesing application !");
	}

}
