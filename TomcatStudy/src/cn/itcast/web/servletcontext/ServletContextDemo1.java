package cn.itcast.web.servletcontext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ServletContext�����ȡ		�����Ǻ��ַ�ʽ����ȡ�Ķ���ͬһ��
		
		//1. ͨ��request�����ȡ		request.getServletContext();
		ServletContext context1 = request.getServletContext();
		//2. ͨ��HttpServlet��ȡ		this.getServletContext();
		ServletContext context2 = this.getServletContext();
		
//		ServletContext���ܣ�

//		1. ��ȡMIME���ͣ�
//			* MIME����:�ڻ�����ͨ�Ź����ж����һ���ļ���������
//				* ��ʽ�� ������/С����   text/html		image/jpeg
//
//			* ��ȡ��String getMimeType(String file)  
		
//		2. ����󣺹�������
//			1. setAttribute(String name,Object value)
//			2. getAttribute(String name)
//			3. removeAttribute(String name)
//
//			* ServletContext����Χ�������û��������������
		
//		3. ��ȡ�ļ�����ʵ(������)·��
//			1. ������String getRealPath(String path)  
//				 String b = context.getRealPath("/b.txt");//webĿ¼����Դ����
//		         System.out.println(b);
//		
//		        String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INFĿ¼�µ���Դ����
//		        System.out.println(c);
//		
//		        String a = context.getRealPath("/WEB-INF/classes/a.txt");//srcĿ¼�µ���Դ����
//		        System.out.println(a);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
