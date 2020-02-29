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

//����JDBC�����Ŀ���������
//���ô���ʱ���Զ���������
//�����������ݿ⹦�ܺ͹رջ��չ���
//�������ݿ����õ������Ϣֻ��Ҫ�޸�db.properties

public class JDBCUtils {
	
	//�������˽�о�̬��Ա����
	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	//��̬�����ʼ���Զ�ִ�У���ʹ������������ø���ķ���ʱҲ���Զ�ִ��
	static {
		
		//����JDBCUtils.class��ø����һ������ ��������ʹ��getClassLoader()�������
		//Ȼ���ü�������ͨ���ֽ�������ķ�ʽ��db.properties�ļ�������
		
		InputStream inputs = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
		
		//��Ϊ�õ����ֽ�����properties��ʽ��
		//������Ҫ����һ��Properties���͵Ķ�����������
		
		Properties p =new Properties();
		
		//�������ļ�
		
		try {
			p.load(inputs);
			System.out.println("�����ļ���ȡ�ɹ�");
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("�����ļ���ȡʧ��");
		}
		
		driver = p.getProperty("driver");
		url = p.getProperty("url");
		username = p.getProperty("username");
		password = p.getProperty("password");
		
		
		//��������
		try {
			Class.forName(driver);
			System.out.println("�������سɹ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("��������ʧ��");
		}
		
	}
	
	
	//������Ӷ���ķ���
	
	public static Connection getConnection() {
				
		try {
			System.out.println("���ݿ����ӳɹ�");
			
			return DriverManager.getConnection(url, username, password);
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		}
		return null;
	}
	
	
	//�ͷ���Դ�ķ���
	
	public static void close(Connection conn,Statement statement,ResultSet result) {
		
		//���ж��Ƿ�Ϊ�գ������ȴ����ĺ�ر�˳��
		
		try {
			
			if(result!=null) {
				
				result.close();//��ֻ�ǹ������ñ�����
				
				result=null;//java���Զ�������Դ
				
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	
	

}
