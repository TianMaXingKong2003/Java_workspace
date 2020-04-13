package com.supermarket.dao;

import com.supermarket.model.Goods;
import com.supermarket.model.GoodsType;
import com.supermarket.model.User;
import com.supermarket.util.JDBCUtils;
import com.supermarket.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.jws.soap.SOAPBinding.Use;


//��UserDao�ӿڵ�ʵ����
//�½��������ʱ��Ҫ�ǵõ�������Ҫʵ�ֵĽӿ��Լ���ѡ�̳нӿ�

//��java�������ݿ⣬ʵ������ͨ������MySQL����������ݿ���в�����

public class UserDao_Implement implements UserDao {
	
	//ע�⣺MySQL�﷨�б���Ҫ�������ţ�java����ʱ��Ҫ������
	
	
	//ע�⣺����MySQL�����Ҫ������ı�ͱ�������޸�	
	

	//MySQL��䡪���μ������ĳ��ֵ		�����ʺ�˵���⼸���ط��ǲ�����������Խ����޸ģ�?Ҫ��Ӣ�ĵ�
	private static final String SQL_USER_LOGIN_NAME="SELECT type FROM user WHERE userName=?";
	private static final String SQL_USER_LOGIN_PASSWORD="SELECT type FROM user WHERE userName=? and password=?";
	//MySQL��䡪����û��˺ź�����		������û���Ӧ��Ϊ���ݿ���û�г��ֹ��ģ���Ϊ������е�����ΪUnique
	private static final String SQL_USER_INSERT="INSERT INTO user VALUES (id,?,?,2)";
	//MySQL��䡪ɾ����һ������Ϣ
	private static final String SQL_USER_DELETE = "DELETE FROM user WHERE userName=?";
	//MySQL��䡪�������޸ı���Ϣ		
	private static final String SQL_USER_UPDATE = "UPDATE user SET password=? WHERE userName=?";
	//MySQL��䡪���β�ѯ��ȫ����Ϣ
	private static final String SQL_USER_SELECT = "SELECT * FROM user WHERE userName=?";
	
	//�����ں������Ͽ��Կ������ڽӿ����ע��
	
	
	//��¼���Ȩ��
	@SuppressWarnings("resource")
	@Override		
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
		
	//�����û���Ϣ�����ݿ���
	@Override		
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

	//ɾ���û���Ϣ�����ݿ���
	@Override		
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

	//�޸��û���Ϣ�����ݿ���
	@Override		
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

	//�����ݿ��в����û���Ϣ
	@Override		
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
				uname_rt=result.getString("userName");
				upass_rt=result.getString("password");
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

	/**
	 * ��ѯ�û���Ϣ����
	 * @param con
	 * @param goodstype
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(User user)throws Exception{
		
		StringBuffer sb=new StringBuffer("select * from user");
		if(StringUtil.isNotEmpty(user.getUname())){
			sb.append(" and userName like '%"+user.getUname()+"%'");
		}
		Connection conn=JDBCUtils.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
}

