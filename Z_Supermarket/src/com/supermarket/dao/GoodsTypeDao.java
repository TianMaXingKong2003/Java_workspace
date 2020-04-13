package com.supermarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.supermarket.model.GoodsType;
import com.supermarket.model.User;
import com.supermarket.util.JDBCUtils;
import com.supermarket.util.StringUtil;


/**
 * ��Ʒ���Dao��
 * @author Administrator
 *
 */
public class GoodsTypeDao {

	/**
	 * ��Ʒ������		//����ͨ��
	 * @param con
	 * @param goodstype
	 * @return
	 * @throws Exception
	 */
	public boolean add(GoodsType goodsType)throws Exception{
		
		Connection conn=JDBCUtils.getConnection();
		PreparedStatement prepareStatement=null;
				
		try {
		
			prepareStatement= conn.prepareStatement("insert into goodstype values(null,?,?)");
			prepareStatement.setString(1, goodsType.getGoodsTypeName());
			prepareStatement.setString(2, goodsType.getGoodsTypeDesc());
			
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

	
	/**
	 * ɾ��ɾ�����		//����ͨ��
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String id)throws Exception{
		
		
		Connection conn=JDBCUtils.getConnection();
		PreparedStatement prepareStatement=null;
				
		try {
		
			prepareStatement= conn.prepareStatement("delete from goodstype where id=?");
			prepareStatement.setString(1,id);
			
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

	
	/**
	 * ������Ʒ���		//����ͨ��
	 * @param con
	 * @param goodstype
	 * @return
	 * @throws Exception
	 */
	public boolean update(GoodsType goodstype)throws Exception{

		Connection conn=JDBCUtils.getConnection();
		PreparedStatement prepareStatement=null;
				
		try {
		
			prepareStatement= conn.prepareStatement("update goodstype set goodsTypeName=?, goodsTypeDesc=? where id=?");
			prepareStatement.setString(1, goodstype.getGoodsTypeName());
			prepareStatement.setString(2, goodstype.getGoodsTypeDesc());
			prepareStatement.setInt(3, goodstype.getId());
			
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
	
	/**
	 * ��ѯ��Ʒ��𼯺�	//����ͨ��
	 * @param con
	 * @param goodstype
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(GoodsType goodstype)throws Exception{
		
		StringBuffer sb=new StringBuffer("select * from goodstype");
		if(StringUtil.isNotEmpty(goodstype.getGoodsTypeName())){
			sb.append(" and goodsTypeName like '%"+goodstype.getGoodsTypeName()+"%'");
		}
		Connection conn=JDBCUtils.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	
	
}
