package com.deep.repository;

import com.deep.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<User, Long> {
}
