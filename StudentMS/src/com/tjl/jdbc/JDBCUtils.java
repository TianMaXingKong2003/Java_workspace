package com.tjl.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.spi.DirStateFactory.Result;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.mysql.jdbc.Statement;

//这是JDBC完整的开发工具类
//调用此类时会自动加载驱动
//包含连接数据库功能和关闭回收功能
//连接数据库所用的相关信息只需要修改db.properties

public class JDBCUtils {
	
	//声明类的私有静态成员变量
	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	//静态语句块初始化自动执行，即使不创建对象调用该类的方法时也会自动执行
	static {
		
		//首先JDBCUtils.class获得该类的一个对象 ，用它来使用getClassLoader()类加载器
		//然后用加载器会通过字节流输入的方式打开db.properties文件的内容
		
		InputStream inputs = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
		
		//因为得到的字节流是properties格式的
		//所以需要创建一个Properties类型的对象来解析它
		
		Properties p =new Properties();
		
		//加载流文件
		
		try {
			p.load(inputs);
			System.out.println("配置文件读取成功");
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("配置文件读取失败");
		}
		
		driver = p.getProperty("driver");
		url = p.getProperty("url");
		username = p.getProperty("username");
		password = p.getProperty("password");
		
		
		//加载驱动
		try {
			Class.forName(driver);
			System.out.println("驱动加载成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("驱动加载失败");
		}
		
	}
	
	
	//获得连接对象的方法
	
	public static Connection getConnection() {
				
		try {
			System.out.println("数据库连接成功");
			
			return DriverManager.getConnection(url, username, password);
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		return null;
	}
	
	
	//释放资源的方法
	
	public static void close(Connection conn,Statement statement,ResultSet result) {
		
		//先判断是否为空，按照先创建的后关闭顺序
		
		try {
			
			if(result!=null) {
				
				result.close();//这只是关了引用变量名
				
				result=null;//java会自动回收资源
				
			}
			
			if(statement!=null) {
				
				statement.close();
				statement=null;
			}
			
			if (conn!=null) {
				
				conn.close();
				conn=null;
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	

}
