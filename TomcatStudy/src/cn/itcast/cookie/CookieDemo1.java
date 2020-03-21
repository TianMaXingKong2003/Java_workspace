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
		
//	1. ����Cookie���󣬰�����
		Cookie c=new Cookie("message", "hello");
//	2.����Cookie���ʱ��
		c.setMaxAge(30);		//�־û���Ӳ�̣�30����Զ�ɾ��
//	3. ����Cookie����
		response.addCookie(c);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
