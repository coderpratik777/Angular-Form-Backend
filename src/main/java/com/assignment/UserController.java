package com.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public Status registerUser(@RequestBody User user) {
		Status status=new Status();
		try {
			
			User userData=userService.registerUser(user);
			status.setId(userData.getId());
			status.setMessageIfAny("Registration Successfull!!(Create by Pratik Pawar)");
			status.setStatus(true);
			
		} catch(UserException e) {
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
		}
		return status;
	}

}
