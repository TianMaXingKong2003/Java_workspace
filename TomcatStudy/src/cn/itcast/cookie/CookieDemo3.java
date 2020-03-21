package cn.itcast.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieDemo3")
public class CookieDemo3 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		1. 创建Cookie对象，绑定数据
			Cookie c1=new Cookie("message1", "你好");
			Cookie c2=new Cookie("message2", "天马行空");
			Cookie c3=new Cookie("message3", "！@#￥！#￥#￥%……&");
//		2.设置Cookie存活时间
			//c1.setMaxAge(60);		//持久化到硬盘，60秒后自动删除
//		3. 发送Cookie对象
			response.addCookie(c1);
			response.addCookie(c2);
			response.addCookie(c3);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
