package cn.itcast.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.itcast.domain.Person;
import service.imp.IPersonServiceImp;

public class IPersonServiceImpTest {
	
	//���Ե�¼	�ɹ�����Ӣ���û�������ͨ����
	public static void loginTest() {
		
		Person person = new IPersonServiceImp().login("���������û���", "abcdefg");
		
		if(person==null) {
			System.out.println("��¼ʧ��");
		}else
		System.out.println(person.toString());
	}
	
	//����ע��	�ɹ�
	private static void registerTest() {
		
		boolean bool = false;
		Person person = new Person("csc", "123", "������", "nan", "�����п�", "123", "625499896@qq.com", "null", "null", "null", "null", "null");
		IPersonServiceImp iPersonServiceImp = new IPersonServiceImp();
		bool = iPersonServiceImp.register(person);
		if(bool) {
			System.out.println("ע��ɹ�");
			System.out.println(person.toString());
		}else
			System.out.println("ע��ʧ��");
		
	}
	
	
	//�����޸���Ϣ
	/**
	 * 
	 */
	private static void updateTest() {
	
	}
	
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
//		loginTest();	
		registerTest();
		
//		updateTest();
		
	}

	

	

}
