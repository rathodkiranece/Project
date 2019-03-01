package com.app.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IAdminDao;
import com.app.model.Admin;
@Repository
public class AdminDaoImpl implements IAdminDao{
	@Autowired
	private HibernateTemplate ht;
	

	@Override
	public int saveAdmin(Admin admin) {
		return (Integer) ht.save(admin);
	}

}
