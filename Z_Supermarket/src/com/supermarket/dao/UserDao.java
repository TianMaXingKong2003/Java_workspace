package com.supermarket.dao;

import com.supermarket.model.User;

//这是一个接口，关于接口的基础知识详见《Java核心技术》p117-124

//接口的实现在UserDao_Implement.java中

//用java控制数据库，实际上是通过发送MySQL语句来对数据库进行操作的

public interface UserDao {

	
	/**验证登录的方法
	 * @param user要登录的用户		uname账号		upass密码
	 * @return int类型			1 管理员登录		2 普通用户登录			0 异常		-1 账号不存在		-2 密码不正确		
	 */
	int login(User user);
	
	/**用来添加用户信息的方法
	 * @param	user要添加的用户		包含账号和密码
	 * @return	false	失败		true	成功
	 */
	boolean insert(User user);
	
	/**用来删除用户信息的方法
	 * @param	uname要删除的用户		包含账号和密码
	 * @return	false	失败		true	成功
	 */
	boolean delete(String uname);
	
	/**用来修改用户信息的方法
	 * @param	user要修改的用户		包含账号和密码
	 * @return	false	失败		true	成功
	 */
	boolean update(User user);
	
	/**用来查询用户信息的方法
	 * @param uname要查询的用户
	 * @return 查询成功返回user		失败返回null
	 */
	User select(String uname);
	
}
