package com.itheima.service.impl;

import com.itheima.dao.CustomerDao;
import com.itheima.dao.impl.CustomerDaoImpl;
import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao = new CustomerDaoImpl();
	public void regist(Customer customer) {
		customerDao.save(customer);
	}
	public Customer login(String email, String phoneNumber) {
		Customer customer = new Customer();
		customer.setEmail(email);
		customer.setPhoneNumber(phoneNumber);
		return customerDao.uniqueResult(customer);
	}
	public void updateCustomer(Customer customer) {
		customerDao.update(customer);
	}
	public Customer findCustomerByActiveCode(String activeCode) {
		Customer customer = new Customer();
		customer.setActiveCode(activeCode);
		return customerDao.uniqueResult(customer);
	}
	
}
