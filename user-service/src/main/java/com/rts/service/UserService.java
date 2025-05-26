package com.rts.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rts.dao.UserDao;
import com.rts.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public User add(User user) {
		return userDao.add(user);
	}

	public List<User> list() {
		return userDao.findAllUsers();
	}

	public User getByUserId(int userId) {

		return userDao.getById(userId);
	}  

}
