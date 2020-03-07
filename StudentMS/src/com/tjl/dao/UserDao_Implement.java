package com.tjl.dao;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tjl.bean.User;
import com.tjl.jdbc.JDBCUtils;

import java.sql.Statement;

import javax.sound.sampled.Line;

//对UserDao接口的实现类
//新建这种类的时候要记得点击添加你要实现的接口以及勾选继承接口

//用java控制数据库，实际上是通过发送MySQL语句来对数据库进行操作的

public class UserDao_Implement implements UserDao {
	
	//注意：MySQL语法中表名要带单引号，java传参时不要加引号
	
	
	//注意：下列MySQL语句需要根据你的表和表项进行修改	
	
	

	//MySQL语句—带参检索表格某个值		几个问号说明这几个地方是参数，后面可以进行修改，?要用英文的
	private static final String SQL_USER_LOGIN="SELECT type FROM user WHERE uname=? and upass=?";
	//MySQL语句—添加用户账号和密码		插入的用户名应该为数据库里没有出现过的，因为表设计中的索引为Unique
	private static final String SQL_USER_INSERT="INSERT INTO user VALUES (id,?,?,2)";
	//MySQL语句—删除掉一条表单信息
	private static final String SQL_USER_DELETE = "DELETE FROM user WHERE uname=?";
	//MySQL语句—带参数修改表单信息		
	private static final String SQL_USER_UPDATE = "UPDATE user SET upass=? WHERE uname=?";
	//MySQL语句—带参查询表全部信息
	private static final String SQL_USER_SELECT = "SELECT * FROM user WHERE uname=?";
	
	//鼠标放在函数名上可以看到它在接口里的注释
	
	@Override		//登录检测权限
	public int login(User user) {
		
		//连接数据库，创建连接对象
		
		Connection conn = JDBCUtils.getConnection();
		
		//创建预编译环境
		//因为将要执行的SQL语句是带有参数的，所以需要用预编译的类型
		
		PreparedStatement prepareStatement=null;
		
		ResultSet result =null;
		
		try {	
			
			prepareStatement= conn.prepareStatement(SQL_USER_LOGIN);
			
			//设置SQL语句中的参数，1 2 代表第几个问号参数
			
			prepareStatement.setString(1, user.getUname());
			prepareStatement.setString(2, user.getUpass());
			
			//执行 sql 语句 Query，得到结果集对象result
			
			result= prepareStatement.executeQuery();
			
			//用结果集查看当前用户的权限
			
			while (result.next()) {
				
				int type = result.getInt("type");
				
				return type;
			}
				
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			
			//释放资源，减少内存的占用
			
			JDBCUtils.close(conn, prepareStatement, result);
		}
	
		return -1;
	}

	@Override		//增加用户信息到数据库中
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

	@Override		//删除用户信息到数据库中
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

	@Override		//修改用户信息到数据库中
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

	@Override		//在数据库中查找用户信息
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
				uname_rt=result.getString("uname");
				upass_rt=result.getString("upass");
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

}
