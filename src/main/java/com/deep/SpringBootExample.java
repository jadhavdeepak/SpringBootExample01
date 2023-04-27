package com.deep;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deep.model.User;
import com.deep.service.UserService;

@SpringBootApplication
public class SpringBootExample {
	
//	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExample.class, args);
	}

/*	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Project Started !!");
		
		User users = new User();
		users.setFirstName("Deepak");
		users.setLastName("Jadhav");
		users.setUsername("Deepak Jadhav");
		users.setPassword("password");
		users.setEmail("jadhavdeepak.dj@gmail.com");
		users.setPhone("9767770809");
		users.setProfile("Deepak.png");

		User user1 = this.userService.createUser(users);
		System.out.println(user1.getUsername());
	}*/

}
