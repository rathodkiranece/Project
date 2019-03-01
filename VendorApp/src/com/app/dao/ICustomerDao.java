package com.app.dao;

import java.util.List;

import com.app.model.Customer;
import com.app.model.Item;

public interface ICustomerDao {
	public int saveCustomer(Customer cust);
	public List<Customer> getAllCustomer();
	public void deleteCustomer(int custId);
	public void updateCustomer(Customer cust);
	public Customer getCustomerByEmail(String custEmail);
	public List<Item> getItemsOfCustomerbyId(int custId);
	public Customer getCustomerbyId(int custId);

}
