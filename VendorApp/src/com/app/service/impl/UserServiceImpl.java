package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDao;
import com.app.model.User;
import com.app.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao dao;

	public int saveUser(User user) {
		return dao.saveUser(user);
	}
	@Override
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}
	@Override
	public void deleteUserById(int userId) {
		dao.deleteUserById(userId);
	}
	
	public User getUserByUserNameAndPwd(String userName, String pwd) {
		return dao.getUserByUserNameAndPwd(userName, pwd);
	}
	@Override
	public List<User> getUsersType() {
		return dao.getUsersType();
	}
	
	@Override
	public User getUserById(int userId) {
		return dao.getUserById(userId);
	}
	
	@Override
	public void makeUserToActive(User user) {
		dao.makeUserToActive(user);
	}

	@Override
	public void makeUserToDeActive(User user) {

		dao.makeUserToDeActive(user);
	}
}