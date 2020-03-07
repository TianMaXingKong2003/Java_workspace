package com.itheima.dao.impl;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.exception.DaoException;
import com.itheima.util.C3P0Util;

public class CustomerDaoImpl implements CustomerDao {
	
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	
	public void save(Customer customer) {
		try {
			qr.update("insert into CUSTOMERS (name,phoneNumber,gender,qq,email,address,status,classType,infoSource,message) values (?,?,?,?,?,?,?,?,?,?)", 
					customer.getName(),customer.getPhoneNumber(),customer.getGender(),customer.getQq(),
					customer.getEmail(),customer.getAddress(),customer.getStatus(),customer.getClassType(),
					customer.getInfoSource(),customer.getMessage());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	//反射customer的所有的字段，只要字段不为null，都作为查询条件，执行的and查询
	public List<Customer> find(Customer customer) {
		try {
			
			StringBuffer sb = new StringBuffer("select * from CUSTOMERS where 1=1 ");
			if(customer==null){
				return qr.query(sb.toString(), new BeanListHandler<Customer>(Customer.class));
			}
			List listParam = new ArrayList();
			Class clazz = customer.getClass();
			Field fields[] = clazz.getDeclaredFields();
			for(Field field:fields){
				field.setAccessible(true);//强暴
				Object fieldValue = field.get(customer);
				if(fieldValue!=null){
					//作为查询条件
					sb.append("and "+field.getName()+"=? ");
					listParam.add(fieldValue);
				}
			}
			System.out.println(sb.toString());
			return qr.query(sb.toString(), new BeanListHandler<Customer>(Customer.class), listParam.toArray());
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	public Customer uniqueResult(Customer customer) {
		List<Customer> cs = find(customer);
		if(cs.size()==0){
			return null;
		}
		if(cs.size()>1)
			throw new DaoException("结果不是唯一的，请使用find(Customer c)方法");
		return cs.get(0);
	}
	
	public Customer find(String email, String phoneNumber) {
		Customer customer = new Customer();
		customer.setEmail(email);
		customer.setPhoneNumber(phoneNumber);
		return uniqueResult(customer);
	}
	
	public void update(Customer customer) {
		try {
			qr.update("update CUSTOMERS set name=?,phoneNumber=?,gender=?,qq=?,email=?,address=?,status=?,classType=?,infoSource=?,message=?,actived=?,activeCode=?,activeDate=? where id=?", 
					customer.getName(),customer.getPhoneNumber(),customer.getGender(),customer.getQq(),
					customer.getEmail(),customer.getAddress(),customer.getStatus(),customer.getClassType(),
					customer.getInfoSource(),customer.getMessage(),customer.getActived(),customer.getActiveCode(),customer.getActiveDate(),
					customer.getId());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
