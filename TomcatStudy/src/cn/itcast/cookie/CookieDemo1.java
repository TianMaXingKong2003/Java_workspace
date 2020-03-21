package cn.itcast.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieDemo1")
public class CookieDemo1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//	1. 创建Cookie对象，绑定数据
		Cookie c=new Cookie("message", "hello");
//	2.设置Cookie存活时间
		c.setMaxAge(30);		//持久化到硬盘，30秒后自动删除
//	3. 发送Cookie对象
		response.addCookie(c);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
