package com.itheima.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.dao.UserDao;
import com.itheima.domain.Function;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.exception.DaoException;
import com.itheima.util.C3P0Util;

public class UserDaoImpl implements UserDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	public User find(String username, String password) {
		try {
			return qr.query("select * from users where username=? and password=?", new BeanHandler<User>(User.class),username,password);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public List<User> findAll() {
		try {
			return qr.query("select * from users", new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public void save(User user) {
		try {
			qr.update("insert into users (username,password,nickname) values (?,?,?)", user.getUsername(),user.getPassword(),user.getNickname());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		
	}
	public User find(String userId) {
		try {
			User user = qr.query("select * from users where id=?", new BeanHandler<User>(User.class),userId);
			if(user!=null){
				//查询关联的角色
				String sql = "select r.* from user_role ur inner join roles r on ur.r_id=r.id where ur.u_id=?";
				List<Role> roles = qr.query(sql, new BeanListHandler<Role>(Role.class), user.getId());
				user.setRoles(roles);
			}
			return user;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public void updateUserRole(String userId, String[] roleIds) {
		try {
			//先把原来的关系删掉
			qr.update("delete from user_role where u_id=?", userId);
			//建立新的关系
			for(String roleId:roleIds)
				qr.update("insert into user_role (u_id,r_id) values (?,?)", userId,roleId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
