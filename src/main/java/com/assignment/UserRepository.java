package com.assignment;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select u from User u where u.phoneNumber=?1")
	Optional<User> findByPhoneNumber(String phoneNumber);

	
	

}
