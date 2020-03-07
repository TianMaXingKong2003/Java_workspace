package com.itheima.service;

import java.util.List;

import com.itheima.domain.Function;
import com.itheima.domain.Role;
import com.itheima.domain.User;

/**
 * 权限管理有关
 * @author wzhting
 *
 */
public interface PrivilegeService {

	User login(String username, String password);

	List<Function> findAllFunctions();

	void addFunction(Function function);

	List<Role> findAllRoles();

	void addRole(Role role);
	/**
	 * 同时把关联的功能也查询出来
	 * @param roleId
	 * @return
	 */
	Role findRoleById(String roleId);

	void grantFunction2Role(String roleId, String[] functionIds);

	List<User> findAllUsers();

	void addUser(User user);
	/**
	 * 同时把已经分配的角色查询出来
	 * @param userId
	 * @return
	 */
	User findUserById(String userId);
	/**
	 * 给用户分配角色
	 * @param userId
	 * @param roleIds
	 */
	void grantRole2User(String userId, String[] roleIds);

}
