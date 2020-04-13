package com.supermarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.supermarket.util.JDBCUtils;
import com.supermarket.util.StringUtil;
import com.supermarket.model.Goods;

/**
 * ��ƷDao��
 * @author Administrator
 *
 */
public class GoodsDao {

	/**
	 * ��Ʒ���	//����ͨ��
	 * @param con
	 * @param 
	 * @return
	 * @throws Exception
	 */
	public boolean add(Goods goods)throws Exception{
	
		Connection conn=JDBCUtils.getConnection();
		PreparedStatement prepareStatement=null;
				
		try {
		
			prepareStatement= conn.prepareStatement("insert into goods values(null,?,?,?,?,?,?)");
			
			prepareStatement.setString(1, goods.getGoodsName());
			prepareStatement.setFloat(2, goods.getPrice());
			prepareStatement.setInt(3, goods.getQuantity());
			prepareStatement.setInt(4, goods.getGoodsTypeId());
			prepareStatement.setString(5, goods.getGoodsTypeName());
			prepareStatement.setString(6, goods.getGoodsDesc());
			
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
	 * ��Ʒɾ��	//����ͨ��
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String id)throws Exception{

		Connection conn=JDBCUtils.getConnection();
		PreparedStatement prepareStatement=null;
				
		try {
		
			prepareStatement= conn.prepareStatement("delete from goods where id=?");
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
	 * ��Ʒ�޸�	//����ͨ��
	 * @param con
	 * @param 
	 * @return
	 * @throws Exception
	 */
	public boolean update(Goods goods)throws Exception{
		
		Connection conn=JDBCUtils.getConnection();
		PreparedStatement prepareStatement=null;
				
		try {
		
			prepareStatement= conn.prepareStatement("update goods set goodsName=?,price=?,quantity=?,goodsTypeId=?,goodsTypeName=?,goodsDesc=?  where id=?");
			prepareStatement.setString(1, goods.getGoodsName());
			prepareStatement.setFloat(2, goods.getPrice());
			prepareStatement.setInt(3, goods.getQuantity());
			prepareStatement.setInt(4, goods.getGoodsTypeId());
			prepareStatement.setString(5, goods.getGoodsTypeName());
			prepareStatement.setString(6, goods.getGoodsDesc());
			prepareStatement.setInt(7, goods.getId());
			
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
	 * ָ����Ʒ������Ƿ������Ʒ
	 * @param con
	 * @param 
	 * @return
	 * @throws Exception
	 */
	public boolean existGoodsByGoodsTypeId(String goodsTypeId)throws Exception{
		
		Connection conn=JDBCUtils.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("select * from goods where goodsTypeId=?");
		pstmt.setString(1, goodsTypeId);
		ResultSet rs=pstmt.executeQuery();
		return rs.next();
		
	}
	
	/**
	 * ͼ����Ϣ��ѯ
	 * @param con
	 * @param 
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Goods goods)throws Exception{
		StringBuffer sb=new StringBuffer("select * from goods g,goodsType gt where g.goodsTypeId=gt.id");

		if(StringUtil.isNotEmpty(goods.getGoodsName())){
			sb.append(" and g.goodsName like '%"+goods.getGoodsName()+"%'");
		}
		
		if(goods.getGoodsTypeId()!=null && goods.getGoodsTypeId()!=-1){
			sb.append(" and g.goodsTypeId="+goods.getGoodsTypeId());
		}
		
		Connection conn=JDBCUtils.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
}
