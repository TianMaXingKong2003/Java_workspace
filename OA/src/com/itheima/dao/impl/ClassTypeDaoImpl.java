package com.itheima.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.dao.ClassTypeDao;
import com.itheima.domain.ClassType;
import com.itheima.exception.DaoException;
import com.itheima.util.C3P0Util;

public class ClassTypeDaoImpl implements ClassTypeDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	public List<ClassType> findAll() {
		try {
			return qr.query("select * from CLASSTYPES", new BeanListHandler<ClassType>(ClassType.class));
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	public void save(ClassType classType) {
		try {
			qr.update("insert into CLASSTYPES (name,description) values (?,?)", classType.getName(),classType.getDescription());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	public ClassType findOne(String classTypeId) {
		try {
			return qr.query("select * from CLASSTYPES where id=?", new BeanHandler<ClassType>(ClassType.class),classTypeId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
