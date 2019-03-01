package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
import com.app.model.Item;
@Repository
public class CustomerDaoImpl implements ICustomerDao {
	@Autowired
private HibernateTemplate ht;

	@Override
	public void deleteCustomer(int custId) {
		ht.delete(new Customer(custId));
	}
	@Override
	public int saveCustomer(Customer cust) {
		
		return (Integer)ht.save(cust);
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		return ht.loadAll(Customer.class);
	}
	@Override
	public void updateCustomer(Customer cust) {
	ht.update(cust);
	
		
	}
	@Override
	public Customer getCustomerByEmail(String custEmail) {
		Customer cust=null;
		
		String hql="from "+Customer.class.getName()
				+ " where custEmail=?";
		List<Customer> custList=ht.find(hql, custEmail);
		
		if(custList!=null && custList.size()>0){
			cust=custList.get(0);
		}
		return cust;
	}
	@Override
	public List<Item> getItemsOfCustomerbyId(int custId) {
		String hql="from "+Item.class.getName()
				+" where custId=?";
		List<Item> list=ht.find(hql, custId);
		return list;
	}
	@Override
	public Customer getCustomerbyId(int custId) {
		
		return ht.get(Customer.class, custId);
	}

}
