package com.deep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deep.model.User;

@Repository
public interface userRepository extends JpaRepository<User, Long> {
	
	public User findByUsername(String username);

}