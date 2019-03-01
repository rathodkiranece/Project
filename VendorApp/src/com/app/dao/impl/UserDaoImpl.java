package com.app.dao.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;

@Repository
public class UserDaoImpl implements IUserDao {
	@Autowired
	private HibernateTemplate ht;

	public int saveUser(User user) {
		return (Integer)ht.save(user);
	}
	@Override
	public List<User> getAllUsers() {
		return ht.loadAll(User.class);
	}

	@Override
	public void deleteUserById(int userId) {

		ht.delete(new User(userId));
	}
	@Override
	public User getUserByUserNameAndPwd(String userName, String pwd) {
		User user=null;
		String hql="from com.app.model.User where (userEmail=? or userContact=?) and userPwd=?";
		List<User> userList= ht.find(hql, userName, userName, pwd);
		if(userList != null && userList.size()>0){
			return userList.get(0);
		}
		return user;
	}
	@Override
	public List<User> getUsersType() {
		String hql = "from com.app.model.User where userType = 'user'";

		return ht.find(hql);
	}
	@Override
	public User getUserById(int userId) {
		User user = null;
		List<User> userList =ht.find("from com.app.model.User where userId=?", userId);
		if(userList!=null && userList.size()>0){
			user=  userList.get(0);
		}
		return user;
	}
	@Override
	public void makeUserToActive(User user) {
		user.setStatus(1);
		ht.update(user);
	}

	@Override
	public void makeUserToDeActive(User user) {
	user.setStatus(0);
	ht.update(user);
		
	}

	
}
