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
 �ڷ������е�Servlet�ж��Ƿ���һ����ΪlastTime��cookie
 
1. �У����ǵ�һ�η���
	1. ��Ӧ���ݣ���ӭ���������ϴη���ʱ��Ϊ:2018��6��10��11:50:20
	2. д��Cookie��lastTime=2018��6��10��11:50:01
	
2. û�У��ǵ�һ�η���
	1. ��Ӧ���ݣ����ã���ӭ���״η���
	2. д��Cookie��lastTime=2018��6��10��11:50:01
	
ע�⣺�ð���δ��ɣ�
ѧϰ���ӣ�https://github.com/TianMaXingKong2003/Java-Web/blob/master/LearningNotes/day16.md
	
 */
@WebServlet("/CookieTestDemo")
public class CookieTestDemo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		�������ñ��룬Ҫ�ڻ�ȡ��֮ǰ���ã����������߿ͻ��˱�����Ӧ�����ݸ�ʽ�Լ������ʽ
		response.setContentType("text/html;charset=gbk");	
		
//		1.��ȡ���е�Cookie
		Cookie[] cookies = request.getCookies();
//		2.�������е�Cookie
		if (cookies!=null&&cookies.length>0) {
			for (Cookie cookie : cookies) {
//				3.��ȡ����
				String name = cookie.getName();
//				4.�ж������Ƿ��ǣ�lastTime
				if ("lastTime".equals(name)) {
//					˵�����ǵ�һ�η���
				
//					��ȡCookie��value��ʱ��
					String value = cookie.getValue();
					response.getWriter().write("<h1>��ӭ���������ϴη���ʱ��Ϊ:"+value+"</h1>");
					break;
				}
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
