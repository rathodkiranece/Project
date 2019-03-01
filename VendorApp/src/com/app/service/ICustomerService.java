package com.app.service;

import java.util.List;

import com.app.model.Customer;
import com.app.model.Item;
public interface ICustomerService {
	public int saveCustomer(Customer cust);
	public List<Customer> getAllCustomer();
	public void deleteCustById(int custId);
	public void updateCustomer(Customer cust);
	public Customer getCustomerByEmail(String custEmail);
	public List<Item> getItemsOfCustomerbyId(int custId);
	public Customer getCustomerById(int id);
	
	
}
