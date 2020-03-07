package com.itheima.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.dao.CustomerStatusDao;
import com.itheima.domain.CustomerStatus;
import com.itheima.exception.DaoException;
import com.itheima.util.C3P0Util;

public class CustomerStatusDaoImpl implements CustomerStatusDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	public List<CustomerStatus> findAll() {
		try {
			return qr.query("select * from CUSTOMERSTATUS", new BeanListHandler<CustomerStatus>(CustomerStatus.class));
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	public CustomerStatus findOne(String customerStatusId) {
		try {
			return qr.query("select * from CUSTOMERSTATUS where id=?", new BeanHandler<CustomerStatus>(CustomerStatus.class),customerStatusId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	public void save(CustomerStatus customerStatus) {
		try {
			qr.update("insert into CUSTOMERSTATUS (name,description) values (?,?)", customerStatus.getName(),customerStatus.getDescription());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
