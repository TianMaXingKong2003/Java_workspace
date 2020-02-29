package com.tjl.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JDBCUtils {
	
	//静态语句块
	static {
		
		//首先JDBCUtils.class获得该类的一个对象，用它来使用getClassLoader()类加载器
		//然后用加载器会通过字节流输入的方式打开db.properties文件的内容
		
		InputStream inputs = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
		
		//因为得到的字节流是properties格式的
		//所以需要创建一个Properties类型的对象来解析它
		
		Properties p =new Properties();
		
		//加载流文件
		
		try {
			p.load(inputs);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		String driver = p.getProperty("driver");
		
		//System.out.println(driver);
		
		//加载驱动
		try {
			Class.forName(driver);
			System.out.println("驱动加载成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("驱动加载失败");
		}
		
		
	}

}
