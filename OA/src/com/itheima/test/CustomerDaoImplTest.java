package com.itheima.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.junit.Test;

import com.itheima.dao.CustomerDao;
import com.itheima.dao.impl.CustomerDaoImpl;
import com.itheima.domain.Customer;
import com.itheima.util.C3P0Util;

public class CustomerDaoImplTest {

	@Test
	public void testFindAll() {
		CustomerDao dao = new CustomerDaoImpl();
		Customer customer = new Customer();
		
		customer.setId(4);
		customer.setEmail("abc@123.com");
		customer.setPhoneNumber("138....");
		customer.setStatus("火热");
		List<Customer> cs = dao.find(customer);
		System.out.println(cs.size());
	}
	
	@Test
	public void testfind() throws Exception {
		
		Connection conn= C3P0Util.getConnection();
		
		Statement statement = conn.createStatement();
		
		ResultSet result = statement.executeQuery("select * from classes");
		
		while (result.next()) {
			
			
			System.out.print(result.getInt("id")+" ");
			System.out.println(result.getString("name"));
			
		}
		
	}

}
