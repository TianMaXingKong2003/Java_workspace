package com.itheima.dao;

import java.util.List;

import com.itheima.domain.CustomerStatus;

public interface CustomerStatusDao {

	List<CustomerStatus> findAll();

	CustomerStatus findOne(String customerStatusId);

	void save(CustomerStatus customerStatus);

}
