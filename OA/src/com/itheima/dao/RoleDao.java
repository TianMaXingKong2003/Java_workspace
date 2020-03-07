package com.itheima.dao;

import java.util.List;

import com.itheima.domain.Role;

public interface RoleDao {

	List<Role> findAll();

	void save(Role role);

	Role find(String roleId);
	/**
	 * 修改角色和功能的关系
	 * @param roleId
	 * @param functionIds
	 */
	void updateRoleFunction(String roleId, String[] functionIds);


}
