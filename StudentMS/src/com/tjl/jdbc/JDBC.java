package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//����JDBC���߹�����˼·
//ʵ�ֵķ����Ѿ���װ��JDBCUtils.java�����������
//��Ҫ�޸����ݿ���˺�ʱ��ֻ��Ҫ�޸�db.properties����

public class JDBC {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
		
		//�����쳣��д������������Ӻ���
		try {
			
			//��һ��������MySQL������		"com.mysql.jdbc.Driver"Ϊ�����̶�����
			//���һ��lib�ļ��е�src�£��������ļ��ŵ�lib�Ȼ��������ļ��Ҽ�����·��
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("�������سɹ�");
								
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("��������ʧ��");
		}
		
		//�ڶ������������ݿ�			"jdbc:mysql://localhost:3306/������ݿ���"Ϊ�̶�д��
		
		try {
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			System.out.println("���ݿ����ӳɹ�");
			
			//������������ִ�л���		
			
			Statement statement = conn.createStatement();
			
			//ͨ��SQL���õ���ѯ�������		"SQL���"(selectѡ��  *����  from��  test_detail��)
			//��������Navicat�Ĳ�ѯ�����һ��������
			
			ResultSet result = statement.executeQuery("select * from test_detail");
			
			//��ʾ���ѯ�Ľ��
			
			//������ַ�װ���˲�������JDBCUtilsTest.java
			
			while (result.next()) {
				
				System.out.print(result.getInt("test_id")+"\t");
				System.out.println(result.getString("test_name"));
			}
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		}
			

	}

}
