package com.itheima.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Function;
import com.itheima.domain.Role;
import com.itheima.exception.DaoException;
import com.itheima.util.C3P0Util;

public class RoleDaoImpl implements RoleDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	public List<Role> findAll() {
		try {
			return qr.query("select * from roles", new BeanListHandler<Role>(Role.class));
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public void save(Role role) {
		try {
			qr.update("insert into roles (name,description) values (?,?)", role.getName(),role.getDescription());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public Role find(String roleId) {
		try {
			Role role = qr.query("select * from roles where id=?", new BeanHandler<Role>(Role.class),roleId);
			if(role!=null){
				//查询关联的功能
//				String sql = "select f.* from role_function rf,functions f where rf.f_id=f.id and rf.r_id=?";
				String sql = "select f.* from role_function rf inner join functions f on rf.f_id=f.id where rf.r_id=?";
				List<Function> functions = qr.query(sql, new BeanListHandler<Function>(Function.class), role.getId());
				role.setFunctions(functions);
			}
			return role;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public void updateRoleFunction(String roleId, String[] functionIds) {
		
		try {
			//先把原来的关系删掉
			qr.update("delete from role_function where r_id=?", roleId);
			//建立新的关系
			for(String functionId:functionIds)
				qr.update("insert into role_function (r_id,f_id) values (?,?)", roleId,functionId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
