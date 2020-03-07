package com.itheima.dao;

import java.util.List;

import com.itheima.domain.Function;

public interface FunctionDao {

	List<Function> findAll();

	void save(Function function);

}
