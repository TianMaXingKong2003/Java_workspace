package com.itheima.service.impl;

import java.util.List;

import com.itheima.dao.FunctionDao;
import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.dao.impl.FunctionDaoImpl;
import com.itheima.dao.impl.RoleDaoImpl;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.Function;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.service.PrivilegeService;

public class PrivilegeServiceImpl implements PrivilegeService {
	private UserDao userDao = new UserDaoImpl();
	private FunctionDao functionDao = new FunctionDaoImpl();
	private RoleDao roleDao = new RoleDaoImpl();
	public User login(String username, String password) {
		return userDao.find(username,password);
	}
	public List<Function> findAllFunctions() {
		return functionDao.findAll();
	}
	public void addFunction(Function function) {
		functionDao.save(function);
	}
	public List<Role> findAllRoles() {
		return roleDao.findAll();
	}
	public void addRole(Role role) {
		roleDao.save(role);
	}
	public Role findRoleById(String roleId) {
		return roleDao.find(roleId);
	}
	public void grantFunction2Role(String roleId, String[] functionIds) {
		roleDao.updateRoleFunction(roleId,functionIds);
	}
	public List<User> findAllUsers() {
		return userDao.findAll();
	}
	public void addUser(User user) {
		userDao.save(user);
	}
	public User findUserById(String userId) {
		return userDao.find(userId);
	}
	public void grantRole2User(String userId, String[] roleIds) {
		userDao.updateUserRole(userId,roleIds);
	}

}
