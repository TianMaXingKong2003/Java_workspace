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

//		1. ����Cookie���󣬰�����
			Cookie c1=new Cookie("message1", "���");
			Cookie c2=new Cookie("message2", "�����п�");
			Cookie c3=new Cookie("message3", "��@#����#��#��%����&");
//		2.����Cookie���ʱ��
			//c1.setMaxAge(60);		//�־û���Ӳ�̣�60����Զ�ɾ��
//		3. ����Cookie����
			response.addCookie(c1);
			response.addCookie(c2);
			response.addCookie(c3);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
