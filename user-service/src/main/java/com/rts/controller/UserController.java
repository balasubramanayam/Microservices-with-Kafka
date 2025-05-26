package com.rts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rts.model.User;
import com.rts.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping  
	public User add(@RequestBody User user) {
		return userService.add(user);
	}

	@GetMapping()
	public List<User> list() {
		return userService.list();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") Integer userId) {
		User Object = userService.getByUserId(userId);
		if (Object == null) {
			throw new RuntimeException("Employee with id" + userId + "is not found");
		}
		return Object;
	}

}
