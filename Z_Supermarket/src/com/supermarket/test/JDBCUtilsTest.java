package com.supermarket.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.supermarket.util.JDBCUtils;

//�������ݿ�����

public class JDBCUtilsTest {
	
	@Test
	public void testJDBCUtils() throws Exception {
		
		Connection conn = JDBCUtils.getConnection();
		
		Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from "+JDBCUtils.getForm());
			
			while (result.next()) {
				
				//��������������Ҫ��ȷ��д�����򿪵ı������ƣ�
				
				System.out.print(result.getInt("id")+"\t");
				System.out.print(result.getString("userName")+"\t");
				System.out.println(result.getString("password"));
				
			}
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	
	
	
}
