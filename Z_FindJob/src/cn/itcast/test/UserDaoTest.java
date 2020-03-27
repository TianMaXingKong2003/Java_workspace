package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

public class UserDaoTest {

	public static void main(String[] args) {
		
		User loginuser=new User();
		
		loginuser.setUsername("admin123");
		loginuser.setPassword("admin123");
		
		UserDao dao=new UserDao();
		
		User user = dao.login(loginuser);
		
		if(user!=null)
		{
			System.out.println("用户查询成功");
			System.out.println(user);
		}
		else {
			System.out.println("用户查询失败");
		}
	}
}
