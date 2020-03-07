package com.itheima.service;

import com.itheima.domain.Customer;

public interface CustomerService {
	/**
	 * 新用户注册
	 * @param customer
	 */
	void regist(Customer customer);
	/**
	 * 用户登陆
	 * @param email
	 * @param phoneNumber
	 * @return
	 */
	Customer login(String email, String phoneNumber);
	
	void updateCustomer(Customer customer);
	/**
	 * 根据激活码查询客户
	 * @param activeCode
	 * @return
	 */
	Customer findCustomerByActiveCode(String activeCode);

}
