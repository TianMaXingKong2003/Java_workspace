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


//对UserDao接口的实现类
//新建这种类的时候要记得点击添加你要实现的接口以及勾选继承接口

//用java控制数据库，实际上是通过发送MySQL语句来对数据库进行操作的

public class UserDao_Implement implements UserDao {
	
	//注意：MySQL语法中表名要带单引号，java传参时不要加引号
	
	
	//注意：下列MySQL语句需要根据你的表和表项进行修改	
	

	//MySQL语句—带参检索表格某个值		几个问号说明这几个地方是参数，后面可以进行修改，?要用英文的
	private static final String SQL_USER_LOGIN_NAME="SELECT type FROM user WHERE userName=?";
	private static final String SQL_USER_LOGIN_PASSWORD="SELECT type FROM user WHERE userName=? and password=?";
	//MySQL语句—添加用户账号和密码		插入的用户名应该为数据库里没有出现过的，因为表设计中的索引为Unique
	private static final String SQL_USER_INSERT="INSERT INTO user VALUES (id,?,?,2)";
	//MySQL语句—删除掉一条表单信息
	private static final String SQL_USER_DELETE = "DELETE FROM user WHERE userName=?";
	//MySQL语句—带参数修改表单信息		
	private static final String SQL_USER_UPDATE = "UPDATE user SET password=? WHERE userName=?";
	//MySQL语句—带参查询表全部信息
	private static final String SQL_USER_SELECT = "SELECT * FROM user WHERE userName=?";
	
	//鼠标放在函数名上可以看到它在接口里的注释
	
	
	//登录检测权限
	@SuppressWarnings("resource")
	@Override		
	public int login(User user) {
		
		//连接数据库，创建连接对象
		
		Connection conn = JDBCUtils.getConnection();
		
		//创建预编译环境
		//因为将要执行的SQL语句是带有参数的，所以需要用预编译的类型
		
		PreparedStatement prepareStatement=null;
		
		ResultSet result =null;
		
		try {	
			
			prepareStatement= conn.prepareStatement(SQL_USER_LOGIN_NAME);
			
			//设置SQL语句中的参数，1 2 代表第几个问号参数
			
			prepareStatement.setString(1, user.getUname());
			
			//执行 sql 语句 Query，得到结果集对象result
			
			result= prepareStatement.executeQuery();
			
			//用结果集查看当前用户的权限
			
			boolean flag=result.next();
			
			System.out.print("开始验证账号是否存在\t");	System.out.println(flag);
			if(!flag) {
				
				System.out.println("账号不存在");
				
				return -1;		//账号不存在
				
			}else {
				
				System.out.print("账号存在，开始验证密码\t");
				
				prepareStatement= conn.prepareStatement(SQL_USER_LOGIN_PASSWORD);
				prepareStatement.setString(1, user.getUname());
				prepareStatement.setString(2, user.getUpass());
				
				result= prepareStatement.executeQuery();
				
				flag=result.next();System.out.println(flag);
				
				if(!flag) {
					
					System.out.println("密码不正确");
					
					return -2;		//密码不正确
					
				}else {
					
					//用结果集查看当前用户的权限
					
					//while (result.next()) {
						
						int type = result.getInt("type");
						
						System.out.println("登录成功，该账号的类型为："+type);
						
						return type;
					//}
				}
				
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			
			//释放资源，减少内存的占用
			
			JDBCUtils.close(conn, prepareStatement, result);
		}
	
		return 0;
	}
		
	//增加用户信息到数据库中
	@Override		
	public boolean insert(User user) {
		
		Connection conn=JDBCUtils.getConnection();
		PreparedStatement prepareStatement=null;
				
		try {
		
			prepareStatement= conn.prepareStatement(SQL_USER_INSERT);
			prepareStatement.setString(1, user.getUname());
			prepareStatement.setString(2, user.getUpass());
			
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

	//删除用户信息到数据库中
	@Override		
	public boolean delete(String uname) {
		
		Connection conn=JDBCUtils.getConnection();
		PreparedStatement prepareStatement=null;
				
		try {
		
			prepareStatement= conn.prepareStatement(SQL_USER_DELETE);
			prepareStatement.setString(1,uname);
			
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

	//修改用户信息到数据库中
	@Override		
	public boolean update(User user) {
		
		Connection conn=JDBCUtils.getConnection();
		PreparedStatement prepareStatement=null;
				
		try {
		
			prepareStatement= conn.prepareStatement(SQL_USER_UPDATE);
			prepareStatement.setString(1, user.getUpass());
			prepareStatement.setString(2, user.getUname());
			
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

	//在数据库中查找用户信息
	@Override		
	public User select(String uname) {
		Connection conn=JDBCUtils.getConnection();
		PreparedStatement prepareStatement=null;
				
		try {
		
			prepareStatement= conn.prepareStatement(SQL_USER_SELECT);
			prepareStatement.setString(1,uname);
			
			//执行 sql 语句 Query，得到结果集对象result
			
			ResultSet result = prepareStatement.executeQuery();
			
			//MySQL会返回一个结果集合
			
			int id_rt = 0,type_rt = 0;String uname_rt = null,upass_rt = null;
			
			//按照参数取出对应的值
			while(result.next()) {
				
				id_rt= result.getInt("id");
				uname_rt=result.getString("userName");
				upass_rt=result.getString("password");
				type_rt=result.getInt("type");
			}
			
			//返回一个user对象
			return new User(id_rt,uname_rt,upass_rt,type_rt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCUtils.close(conn, prepareStatement, null);
		}
		
		return null;
	}

	/**
	 * 查询用户信息集合
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

