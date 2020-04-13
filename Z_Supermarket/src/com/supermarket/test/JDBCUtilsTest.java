package com.supermarket.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.supermarket.util.JDBCUtils;

//测试数据库连接

public class JDBCUtilsTest {
	
	@Test
	public void testJDBCUtils() throws Exception {
		
		Connection conn = JDBCUtils.getConnection();
		
		Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from "+JDBCUtils.getForm());
			
			while (result.next()) {
				
				//这里表单项的名称需要正确填写（所打开的表单项名称）
				
				System.out.print(result.getInt("id")+"\t");
				System.out.print(result.getString("userName")+"\t");
				System.out.println(result.getString("password"));
				
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	
	
}
