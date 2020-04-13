package com.supermarket.test;

import org.junit.Test;

import com.supermarket.dao.UserDao_Implement;
import com.supermarket.model.User;

public class UserDao_ImplementTest {
	
	
	@Test		//测试登录	//成功
	public void loginTest() throws Exception {
		
		UserDao_Implement udi=new UserDao_Implement();
		
		User user = new User("admin","admin");
		
		System.out.println(udi.login(user));
		
	}
	
	@Test		//测试添加	//成功
	//备注：传输中文的时候如果出现乱码，需要修改你的url后缀加上utf8格式
	//示例写法：jdbc:mysql://localhost:3306/data?useUnicode=true&characterEncoding=utf8
	public void insertTest() throws Exception {
		
		UserDao_Implement udi=new UserDao_Implement();

		//插入的用户名应该为数据库里没有出现过的，因为表设计中的索引为Unique
		User user=new User("王刚","wg");
		
		System.out.println(udi.insert(user));
		
	}

	@Test		//测试删除	//成功
	public void deletTest() throws Exception {
		
		UserDao_Implement udi=new UserDao_Implement();
		
		System.out.println(udi.delete("王刚"));
	}
	
	@Test		//测试修改	//成功
	public void updateTest() throws Exception {
		
		UserDao_Implement udi=new UserDao_Implement();
		
		User user=new User("王刚","wg_changed");
		
		System.out.println(udi.update(user));
	}
	
	@Test		//测试查询	//成功
	public void selectTest() throws Exception {
		
		UserDao_Implement udi=new UserDao_Implement();
		
		System.out.println(udi.select("王刚"));
	}
}
