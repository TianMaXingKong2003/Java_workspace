package com.tjl.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.tjl.jdbc.JDBCUtils;

//用来测试JDBCUtils.java

public class JDBCUtilsTest {
	
	@Test
	public void jdbcConnectionTest() throws Exception {
		
		Connection conn = JDBCUtils.getConnection();
		
		Statement statement = conn.createStatement();
		
		ResultSet result = statement.executeQuery("select * from test_teacher");
		
		while (result.next()) {
			
			//这里表单项的名称需要正确填写（所打开的表单项名称）
			
			System.out.print(result.getInt("tt_id")+" ");
			System.out.println(result.getString("tt_name"));
			
		}
		
	}
	
}
