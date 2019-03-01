package com.app.service;

import java.util.List;

import com.app.model.User;

public interface IUserService {
	public int saveUser(User user);
	public List<User> getAllUsers();
	public void deleteUserById(int userId);
	public User getUserByUserNameAndPwd(String userName, String pwd);
	public List<User> getUsersType();
	
	public User getUserById(int  userId);
	public void makeUserToActive(User user);
	public void makeUserToDeActive(User user);
}
