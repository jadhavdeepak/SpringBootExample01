package com.deep.repository;

import com.deep.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

//    Department findByDepartmentName(String deptName);
}
