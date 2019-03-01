/**
 * 
 */
package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
import com.app.model.Item;
import com.app.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
private ICustomerDao dao;
	@Override
	public void deleteCustById(int custId) {
		dao.deleteCustomer(custId);

	}

	@Override
	public int saveCustomer(Customer cust) {
		return dao.saveCustomer(cust) ;
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		return dao.getAllCustomer();
	}

	@Override
	public List<Item> getItemsOfCustomerbyId(int custId) {
		return dao.getItemsOfCustomerbyId(custId);
	}

	@Override
	public void updateCustomer(Customer cust) {
		dao.updateCustomer(cust);
	}
		@Override
		public Customer getCustomerByEmail(String custEmail) {
			return dao.getCustomerByEmail(custEmail);
	}

		@Override
		public Customer getCustomerById(int custId) {
			return dao.getCustomerbyId(custId);
		}

		

}
