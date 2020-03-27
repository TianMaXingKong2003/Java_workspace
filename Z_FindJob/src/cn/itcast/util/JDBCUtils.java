package cn.itcast.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

//JDBC������	ʹ��Durid���ӳ�

public class JDBCUtils {
	
	private static DataSource ds;
	
	
	static {
		
		try {
			//1.���������ļ�
			
			Properties pro=new Properties();
			//ʹ���������ClassLoader���ػ���ֽ�������
			InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
			pro.load(is);
			
			//2.��ʼ�����ӳض���
			
			ds=DruidDataSourceFactory.createDataSource(pro);
			
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	

	/**
	 * ��ȡ���ӳض���
	 */
	public static DataSource getDataSource() {
		return ds;
	}
	
	
	/**
	 * ��ȡ����Connection����
	 * @throws SQLException 
	 */
	
	public static	Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	
}
