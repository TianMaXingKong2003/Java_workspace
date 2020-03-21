package cn.itcast.cookie;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 在服务器中的Servlet判断是否有一个名为lastTime的cookie
 
1. 有：不是第一次访问
	1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
	2. 写回Cookie：lastTime=2018年6月10日11:50:01
	
2. 没有：是第一次访问
	1. 响应数据：您好，欢迎您首次访问
	2. 写回Cookie：lastTime=2018年6月10日11:50:01
	
注意：该案例未完成！
学习链接：https://github.com/TianMaXingKong2003/Java-Web/blob/master/LearningNotes/day16.md
	
 */
@WebServlet("/CookieTestDemo")
public class CookieTestDemo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		首先设置编码，要在获取流之前设置，服务器告诉客户端本次响应体数据格式以及编码格式
		response.setContentType("text/html;charset=gbk");	
		
//		1.获取所有的Cookie
		Cookie[] cookies = request.getCookies();
//		2.遍历所有的Cookie
		if (cookies!=null&&cookies.length>0) {
			for (Cookie cookie : cookies) {
//				3.获取名称
				String name = cookie.getName();
//				4.判断名称是否是：lastTime
				if ("lastTime".equals(name)) {
//					说明不是第一次访问
				
//					获取Cookie的value：时间
					String value = cookie.getValue();
					response.getWriter().write("<h1>欢迎回来，您上次访问时间为:"+value+"</h1>");
					break;
				}
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
