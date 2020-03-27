package cn.itcast.test;

import cn.itcast.domain.Person;
import service.imp.IPersonServiceImp;

public class IPersonServiceImpTest {
	
	//测试登录	成功
	public static void loginTest() {
		
		Person person = new IPersonServiceImp().login("lihongji", "123456");
		
		System.out.println(person.toString());
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		loginTest();

	}

	

}
