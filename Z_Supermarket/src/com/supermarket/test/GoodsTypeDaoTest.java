package com.supermarket.test;

import java.sql.ResultSet;

import org.junit.Test;

import com.supermarket.dao.GoodsTypeDao;
import com.supermarket.dao.UserDao_Implement;
import com.supermarket.model.GoodsType;
import com.supermarket.model.User;

public class GoodsTypeDaoTest {

	//�������	//�ɹ�
	@Test		
	public void addTest() throws Exception {
			
		GoodsTypeDao gtd=new GoodsTypeDao();

		//������û���Ӧ��Ϊ���ݿ���û�г��ֹ��ģ���Ϊ������е�����ΪUnique
		GoodsType goodType=new GoodsType("����","����˵��");
		
		System.out.println(gtd.add(goodType));
	}
	
	//����ɾ��	//�ɹ�
	@Test		
	public void deleteTest() throws Exception {
			
		GoodsTypeDao gtd=new GoodsTypeDao();

		System.out.println(gtd.delete("4"));
	}
	
	//�����޸�	//�ɹ�
	@Test		
	public void updateTest() throws Exception {
			
		GoodsTypeDao gtd=new GoodsTypeDao();

		//�޸ĵ��û���Ӧ��Ϊ���ݿ���û�г��ֹ��ģ���Ϊ������е�����ΪUnique
		GoodsType goodType=new GoodsType(8,"����","����˵��2");
		
		System.out.println(gtd.update(goodType));
	}
	
	//���Բ���	//�ɹ�
		
}
