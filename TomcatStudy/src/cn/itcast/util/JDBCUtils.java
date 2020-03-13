package cn.itcast.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

//JDBC工具类	使用Durid连接池

public class JDBCUtils {
	
	private static DataSource ds;
	
	
	static {
		
		try {
			//1.加载配置文件
			
			Properties pro=new Properties();
			//使用类加载器ClassLoader加载获得字节输入流
			InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
			pro.load(is);
			
			//2.初始化连接池对象
			
			ds=DruidDataSourceFactory.createDataSource(pro);
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	

	/**
	 * 获取连接池对象
	 */
	public static DataSource getDataSource() {
		return ds;
	}
	
	
	/**
	 * 获取连接Connection对象
	 * @throws SQLException 
	 */
	
	public static	Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	
}
