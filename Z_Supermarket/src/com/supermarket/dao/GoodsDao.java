package com.supermarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.supermarket.util.JDBCUtils;
import com.supermarket.util.StringUtil;
import com.supermarket.model.Goods;

/**
 * 商品Dao类
 * @author Administrator
 *
 */
public class GoodsDao {

	/**
	 * 商品添加	//测试通过
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
			
			//MySQL中的增删改都是用executeUpdate()
			int line = prepareStatement.executeUpdate();
			
			//MySQL会返回一个数字表示受影响的行数，大于0说明对数据的操作成功了
			
			return line>0?true:false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCUtils.close(conn, prepareStatement, null);
		}
		
		return false;
	}
	
	
	/**
	 * 商品删除	//测试通过
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
			
			//MySQL中的增删改都是用executeUpdate()
			int line = prepareStatement.executeUpdate();
			
			//MySQL会返回一个数字表示受影响的行数，大于0说明对数据的操作成功了
			
			return line>0?true:false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCUtils.close(conn, prepareStatement, null);
		}
		
		return false;
	}
	
	/**
	 * 商品修改	//测试通过
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
			
			//MySQL中的增删改都是用executeUpdate()
			int line = prepareStatement.executeUpdate();
			
			//MySQL会返回一个数字表示受影响的行数，大于0说明对数据的操作成功了
			
			return line>0?true:false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCUtils.close(conn, prepareStatement, null);
		}
		
		return false;
		
	}
	
	/**
	 * 指定商品类别下是否存在商品
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
	 * 图书信息查询
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
