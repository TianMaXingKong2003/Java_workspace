package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//ͨ��ע��������servlet����ͨ��web.xml�ļ�
//��Ҫ������һ��@WebServlet��������������������������������

@WebServlet("/Demo3")
public class ServletDemo3 extends GenericServlet{

	//GenericServlet����Servlet�ӿ��������ķ�������Ĭ�Ͽ�ʵ��
	//ֻ��service()������Ϊ����������Servlet��ʱ
	//���Լ̳�GenericServlet��ʵ��service()��������
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		
		System.out.println("ServletDemo3ִ����service����");
		
	}

	

}
