package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo2 implements Servlet{

	@Override		//���ٷ���		�����������رյ�ʱ��ִ�У�ִ��һ��
	public void destroy() {
		// TODO �Զ����ɵķ������
		System.out.println("�����������رգ�ServletDemo2ִ�����ٷ���");
	}

	@Override		//��ȡServlet����
	public ServletConfig getServletConfig() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override		//��ȡServlet��Ϣ
	public String getServletInfo() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override		//��ʼ������		ִֻ��һ��
	public void init(ServletConfig config) throws ServletException {
		// TODO �Զ����ɵķ������
		
		System.out.println("ServletDemo2ִ�г�ʼ������");
		
	}

	@Override		//�ṩ����ķ���		ÿһ�η��ʴ�serviceʱִ��
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		
		System.out.println("ServletDemo2ִ��service����");
	}
}
