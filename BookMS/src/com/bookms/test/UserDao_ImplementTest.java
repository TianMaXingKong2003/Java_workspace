package com.bookms.test;

import org.junit.Test;

import com.bookms.dao.UserDao_Implement;
import com.bookms.model.User;

public class UserDao_ImplementTest {
	
	
	@Test		//���Ե�¼	//�ɹ�
	public void loginTest() throws Exception {
		
		UserDao_Implement udi=new UserDao_Implement();
		
		User user = new User("admin","admin");
		
		System.out.println(udi.login(user));
		
	}
	
	@Test		//��������	//	
	//��ע���������ĵ�ʱ������������룬��Ҫ�޸����url��׺����utf8��ʽ
	//ʾ��д����jdbc:mysql://localhost:3306/data?useUnicode=true&characterEncoding=utf8
	public void insertTest() throws Exception {
		
		UserDao_Implement udi=new UserDao_Implement();

		//������û���Ӧ��Ϊ���ݿ���û�г��ֹ��ģ���Ϊ������е�����ΪUnique
		User user=new User("����","wg");
		
		System.out.println(udi.insert(user));
		
	}

	@Test		//����ɾ��	//
	public void deletTest() throws Exception {
		
		UserDao_Implement udi=new UserDao_Implement();
		
		System.out.println(udi.delete("����"));
	}
	
	@Test		//�����޸�	//
	public void updateTest() throws Exception {
		
		UserDao_Implement udi=new UserDao_Implement();
		
		User user=new User("����","wg_changed");
		
		System.out.println(udi.update(user));
	}
	
	@Test		//���Բ�ѯ	//
	public void selectTest() throws Exception {
		
		UserDao_Implement udi=new UserDao_Implement();
		
		System.out.println(udi.select("����"));
	}
}