package cn.itcast.test;

import cn.itcast.domain.Person;
import service.imp.IPersonServiceImp;

public class IPersonServiceImpTest {
	
	//���Ե�¼	�ɹ�
	public static void loginTest() {
		
		Person person = new IPersonServiceImp().login("lihongji", "123456");
		
		System.out.println(person.toString());
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
		loginTest();

	}

	

}
