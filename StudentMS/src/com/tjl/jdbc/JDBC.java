package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//这是JDBC工具构建的思路
//实现的方法已经封装到JDBCUtils.java这个工具类中
//需要修改数据库和账号时，只需要修改db.properties即可

public class JDBC {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		
		//捕获异常的写法，让软件更加合理
		try {
			
			//第一步·加载MySQL的驱动		"com.mysql.jdbc.Driver"为驱动固定名称
			//添加一个lib文件夹到src下，把驱动文件放到lib里，然后对驱动文件右键构建路径
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动加载成功");
								
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("驱动加载失败");
		}
		
		//第二步·连接数据库			"jdbc:mysql://localhost:3306/你的数据库名"为固定写法
		
		try {
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			System.out.println("数据库连接成功");
			
			//第三步·创建执行环境		
			
			Statement statement = conn.createStatement();
			
			//通过SQL语句得到查询结果集合		"SQL语句"(select选择  *所有  from从  test_detail表)
			//可以先在Navicat的查询里测试一下你的语句
			
			ResultSet result = statement.executeQuery("select * from test_detail");
			
			//显示你查询的结果
			
			//这个部分封装到了测试类中JDBCUtilsTest.java
			
			while (result.next()) {
				
				System.out.print(result.getInt("test_id")+"\t");
				System.out.println(result.getString("test_name"));
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
			

	}

}
