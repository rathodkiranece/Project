package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IAdminDao;
import com.app.model.Admin;
import com.app.service.IAdminService;
@Service
public class AdminServiceImpl implements IAdminService {
	@Autowired
	private IAdminDao dao;
	@Override
	public int saveAdmin(Admin admin) {
		return dao.saveAdmin(admin);
	}

}
