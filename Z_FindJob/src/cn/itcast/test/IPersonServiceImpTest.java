package cn.itcast.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.itcast.domain.Person;
import service.imp.IPersonServiceImp;

public class IPersonServiceImpTest {
	
	//测试登录	成功（中英文用户名测试通过）
	public static void loginTest() {
		
		Person person = new IPersonServiceImp().login("测试中文用户名", "abcdefg");
		
		if(person==null) {
			System.out.println("登录失败");
		}else
		System.out.println(person.toString());
	}
	
	//测试注册	成功
	private static void registerTest() {
		
		boolean bool = false;
		Person person = new Person("csc", "123", "王六六", "nan", "天马行空", "123", "625499896@qq.com", "null", "null", "null", "null", "null");
		IPersonServiceImp iPersonServiceImp = new IPersonServiceImp();
		bool = iPersonServiceImp.register(person);
		if(bool) {
			System.out.println("注册成功");
			System.out.println(person.toString());
		}else
			System.out.println("注册失败");
		
	}
	
	
	//测试修改信息
	/**
	 * 
	 */
	private static void updateTest() {
	
	}
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
//		loginTest();	
		registerTest();
		
//		updateTest();
		
	}

	

	

}
