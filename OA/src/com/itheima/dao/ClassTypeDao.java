package com.itheima.dao;

import java.util.List;

import com.itheima.domain.ClassType;

public interface ClassTypeDao {

	List<ClassType> findAll();

	void save(ClassType classType);

	ClassType findOne(String classTypeId);

}
