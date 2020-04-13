package com.supermarket.test;

import java.sql.ResultSet;

import org.junit.Test;

import com.supermarket.dao.GoodsTypeDao;
import com.supermarket.dao.UserDao_Implement;
import com.supermarket.model.GoodsType;
import com.supermarket.model.User;

public class GoodsTypeDaoTest {

	//测试添加	//成功
	@Test		
	public void addTest() throws Exception {
			
		GoodsTypeDao gtd=new GoodsTypeDao();

		//插入的用户名应该为数据库里没有出现过的，因为表设计中的索引为Unique
		GoodsType goodType=new GoodsType("测试","测试说明");
		
		System.out.println(gtd.add(goodType));
	}
	
	//测试删除	//成功
	@Test		
	public void deleteTest() throws Exception {
			
		GoodsTypeDao gtd=new GoodsTypeDao();

		System.out.println(gtd.delete("4"));
	}
	
	//测试修改	//成功
	@Test		
	public void updateTest() throws Exception {
			
		GoodsTypeDao gtd=new GoodsTypeDao();

		//修改的用户名应该为数据库里没有出现过的，因为表设计中的索引为Unique
		GoodsType goodType=new GoodsType(8,"测试","测试说明2");
		
		System.out.println(gtd.update(goodType));
	}
	
	//测试查找	//成功
		
}
