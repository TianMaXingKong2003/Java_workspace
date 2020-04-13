package com.supermarket.test;

import org.junit.Test;

import com.supermarket.dao.GoodsDao;
import com.supermarket.dao.GoodsTypeDao;
import com.supermarket.model.Goods;
import com.supermarket.model.GoodsType;

public class GoodsDaoTest {

	//测试添加	//成功
	@Test		
	public void addTest() throws Exception {
			
		GoodsDao gd=new GoodsDao();

		//插入的用户名应该为数据库里没有出现过的，因为表设计中的索引为Unique
		Goods goods=new Goods("测试商品名字",(float) 1024,1024,1,"测试","测试说明");
		
		System.out.println(gd.add(goods));
	}
	
	//测试删除	//成功
	@Test		
	public void deleteTest() throws Exception {
			
		GoodsDao gd=new GoodsDao();

		System.out.println(gd.delete("7"));
	}
	
	//测试修改	//成功
	@Test		
	public void updateTest() throws Exception {
			
		GoodsDao gd=new GoodsDao();

		//修改的用户名应该为数据库里没有出现过的，因为表设计中的索引为Unique
		Goods goods=new Goods(8,"测试商品名字",(float) 101,101,1,"测试","测试修改功能");
		
		System.out.println(gd.update(goods));
	}
	
	//测试指定商品类别下是否存在商品	//成功
	@Test		
	public void existGoodsByGoodsTypeIdTest() throws Exception {
			
		GoodsDao gd=new GoodsDao();

		System.out.println(gd.existGoodsByGoodsTypeId("1"));
		
	}
		
		
	
}
