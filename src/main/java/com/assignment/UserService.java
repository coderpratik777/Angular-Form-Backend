
package com.assignment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User registerUser(User user) {
		Optional<User> userData=userRepository.findByPhoneNumber(user.getPhoneNumber());
		if(!userData.isPresent()) {
			userRepository.save(user);
			return user;
		} else {
			throw new UserException("ALready registered User...(created by Pratik Pawar)");
		}
	}

}
