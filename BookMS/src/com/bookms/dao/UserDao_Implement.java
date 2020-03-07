package com.bookms.dao;

import com.bookms.model.User;
import com.bookms.util.JDBCUtils;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import javax.sound.sampled.Line;

//��UserDao�ӿڵ�ʵ����
//�½��������ʱ��Ҫ�ǵõ�������Ҫʵ�ֵĽӿ��Լ���ѡ�̳нӿ�

//��java�������ݿ⣬ʵ������ͨ������MySQL����������ݿ���в�����

public class UserDao_Implement implements UserDao {
	
	//ע�⣺MySQL�﷨�б���Ҫ�������ţ�java����ʱ��Ҫ������
	
	
	//ע�⣺����MySQL�����Ҫ������ı�ͱ�������޸�	
	

	//MySQL��䡪���μ������ĳ��ֵ		�����ʺ�˵���⼸���ط��ǲ�����������Խ����޸ģ�?Ҫ��Ӣ�ĵ�
	private static final String SQL_USER_LOGIN_NAME="SELECT type FROM t_user WHERE userName=?";
	private static final String SQL_USER_LOGIN_PASSWORD="SELECT type FROM t_user WHERE userName=? and password=?";
	//MySQL��䡪����û��˺ź�����		������û���Ӧ��Ϊ���ݿ���û�г��ֹ��ģ���Ϊ������е�����ΪUnique
	private static final String SQL_USER_INSERT="INSERT INTO t_user VALUES (id,?,?,2)";
	//MySQL��䡪ɾ����һ������Ϣ
	private static final String SQL_USER_DELETE = "DELETE FROM t_user WHERE userName=?";
	//MySQL��䡪�������޸ı���Ϣ		
	private static final String SQL_USER_UPDATE = "UPDATE t_user SET password=? WHERE userName=?";
	//MySQL��䡪���β�ѯ��ȫ����Ϣ
	private static final String SQL_USER_SELECT = "SELECT * FROM t_user WHERE userName=?";
	
	//�����ں������Ͽ��Կ������ڽӿ����ע��
	
	@SuppressWarnings("resource")
	@Override		//��¼���Ȩ��
	public int login(User user) {
		
		//�������ݿ⣬�������Ӷ���
		
		Connection conn = JDBCUtils.getConnection();
		
		//����Ԥ���뻷��
		//��Ϊ��Ҫִ�е�SQL����Ǵ��в����ģ�������Ҫ��Ԥ���������
		
		PreparedStatement prepareStatement=null;
		
		ResultSet result =null;
		
		try {	
			
			prepareStatement= conn.prepareStatement(SQL_USER_LOGIN_NAME);
			
			//����SQL����еĲ�����1 2 ����ڼ����ʺŲ���
			
			prepareStatement.setString(1, user.getUname());
			
			//ִ�� sql ��� Query���õ����������result
			
			result= prepareStatement.executeQuery();
			
			//�ý�����鿴��ǰ�û���Ȩ��
			
			boolean flag=result.next();
			
			System.out.print("��ʼ��֤�˺��Ƿ����\t");	System.out.println(flag);
			if(!flag) {
				
				System.out.println("�˺Ų�����");
				
				return -1;		//�˺Ų�����
				
			}else {
				
				System.out.print("�˺Ŵ��ڣ���ʼ��֤����\t");
				
				prepareStatement= conn.prepareStatement(SQL_USER_LOGIN_PASSWORD);
				prepareStatement.setString(1, user.getUname());
				prepareStatement.setString(2, user.getUpass());
				
				result= prepareStatement.executeQuery();
				
				flag=result.next();System.out.println(flag);
				
				if(!flag) {
					
					System.out.println("���벻��ȷ");
					
					return -2;		//���벻��ȷ
					
				}else {
					
					//�ý�����鿴��ǰ�û���Ȩ��
					
					//while (result.next()) {
						
						int type = result.getInt("type");
						
						System.out.println("��¼�ɹ������˺ŵ�����Ϊ��"+type);
						
						return type;
					//}
				}
				
			}
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			
			//�ͷ���Դ�������ڴ��ռ��
			
			JDBCUtils.close(conn, prepareStatement, result);
		}
	
		return 0;
	}

	@Override		//�����û���Ϣ�����ݿ���
	public boolean insert(User user) {
		
		Connection conn=JDBCUtils.getConnection();
		PreparedStatement prepareStatement=null;
				
		try {
		
			prepareStatement= conn.prepareStatement(SQL_USER_INSERT);
			prepareStatement.setString(1, user.getUname());
			prepareStatement.setString(2, user.getUpass());
			
			//MySQL�е���ɾ�Ķ�����executeUpdate()
			int line = prepareStatement.executeUpdate();
			
			//MySQL�᷵��һ�����ֱ�ʾ��Ӱ�������������0˵�������ݵĲ����ɹ���
			
			return line>0?true:false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCUtils.close(conn, prepareStatement, null);
		}
		
		return false;
	}

	@Override		//ɾ���û���Ϣ�����ݿ���
	public boolean delete(String uname) {
		
		Connection conn=JDBCUtils.getConnection();
		PreparedStatement prepareStatement=null;
				
		try {
		
			prepareStatement= conn.prepareStatement(SQL_USER_DELETE);
			prepareStatement.setString(1,uname);
			
			//MySQL�е���ɾ�Ķ�����executeUpdate()
			int line = prepareStatement.executeUpdate();
			
			//MySQL�᷵��һ�����ֱ�ʾ��Ӱ�������������0˵�������ݵĲ����ɹ���
			
			return line>0?true:false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCUtils.close(conn, prepareStatement, null);
		}
		
		return false;
	}

	@Override		//�޸��û���Ϣ�����ݿ���
	public boolean update(User user) {
		
		Connection conn=JDBCUtils.getConnection();
		PreparedStatement prepareStatement=null;
				
		try {
		
			prepareStatement= conn.prepareStatement(SQL_USER_UPDATE);
			prepareStatement.setString(1, user.getUpass());
			prepareStatement.setString(2, user.getUname());
			
			//MySQL�е���ɾ�Ķ�����executeUpdate()
			int line = prepareStatement.executeUpdate();
			
			//MySQL�᷵��һ�����ֱ�ʾ��Ӱ�������������0˵�������ݵĲ����ɹ���
			
			return line>0?true:false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCUtils.close(conn, prepareStatement, null);
		}
		
		return false;
	}

	@Override		//�����ݿ��в����û���Ϣ
	public User select(String uname) {
		Connection conn=JDBCUtils.getConnection();
		PreparedStatement prepareStatement=null;
				
		try {
		
			prepareStatement= conn.prepareStatement(SQL_USER_SELECT);
			prepareStatement.setString(1,uname);
			
			//ִ�� sql ��� Query���õ����������result
			
			ResultSet result = prepareStatement.executeQuery();
			
			//MySQL�᷵��һ���������
			
			int id_rt = 0,type_rt = 0;String uname_rt = null,upass_rt = null;
			
			//���ղ���ȡ����Ӧ��ֵ
			while(result.next()) {
				
				id_rt= result.getInt("id");
				uname_rt=result.getString("uname");
				upass_rt=result.getString("upass");
				type_rt=result.getInt("type");
			}
			
			//����һ��user����
			return new User(id_rt,uname_rt,upass_rt,type_rt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCUtils.close(conn, prepareStatement, null);
		}
		
		return null;
	}

}

