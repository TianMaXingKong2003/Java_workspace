package cn.itcast.test;

import org.junit.Test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

public class UserDaoTest {

	public static void main(String[] args) {
		
		User loginuser=new User();
		
		loginuser.setUsername("admin");
		loginuser.setPassword("admin");
		
		UserDao dao=new UserDao();
		
		User user = dao.login(loginuser);
		
		if(user!=null)
			System.out.println(user);
		else {
			System.out.println("”√ªß≤È—Ø ß∞‹");
		}
	}
}
