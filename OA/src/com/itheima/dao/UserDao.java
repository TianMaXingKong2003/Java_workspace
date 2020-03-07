package com.itheima.dao;

import java.util.List;

import com.itheima.domain.User;

public interface UserDao {

	User find(String username, String password);

	List<User> findAll();

	void save(User user);

	User find(String userId);

	void updateUserRole(String userId, String[] roleIds);

}
