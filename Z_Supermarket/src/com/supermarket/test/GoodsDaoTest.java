package com.supermarket.test;

import org.junit.Test;

import com.supermarket.dao.GoodsDao;
import com.supermarket.dao.GoodsTypeDao;
import com.supermarket.model.Goods;
import com.supermarket.model.GoodsType;

public class GoodsDaoTest {

	//�������	//�ɹ�
	@Test		
	public void addTest() throws Exception {
			
		GoodsDao gd=new GoodsDao();

		//������û���Ӧ��Ϊ���ݿ���û�г��ֹ��ģ���Ϊ������е�����ΪUnique
		Goods goods=new Goods("������Ʒ����",(float) 1024,1024,1,"����","����˵��");
		
		System.out.println(gd.add(goods));
	}
	
	//����ɾ��	//�ɹ�
	@Test		
	public void deleteTest() throws Exception {
			
		GoodsDao gd=new GoodsDao();

		System.out.println(gd.delete("7"));
	}
	
	//�����޸�	//�ɹ�
	@Test		
	public void updateTest() throws Exception {
			
		GoodsDao gd=new GoodsDao();

		//�޸ĵ��û���Ӧ��Ϊ���ݿ���û�г��ֹ��ģ���Ϊ������е�����ΪUnique
		Goods goods=new Goods(8,"������Ʒ����",(float) 101,101,1,"����","�����޸Ĺ���");
		
		System.out.println(gd.update(goods));
	}
	
	//����ָ����Ʒ������Ƿ������Ʒ	//�ɹ�
	@Test		
	public void existGoodsByGoodsTypeIdTest() throws Exception {
			
		GoodsDao gd=new GoodsDao();

		System.out.println(gd.existGoodsByGoodsTypeId("1"));
		
	}
		
		
	
}
