package com.itheima.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	
	
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	public static DataSource getDataSource(){
		System.out.println("获取数据库数据成功");
		return dataSource;
	}
		public static Connection getConnection(){
		try {
			System.out.println("数据库连接成功");
			return dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
			throw new RuntimeException(e);
		}
	}
	
	
}
