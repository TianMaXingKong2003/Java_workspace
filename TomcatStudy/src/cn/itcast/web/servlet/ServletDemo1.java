package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo1 implements Servlet{

	@Override		//���ٷ���		�����������رյ�ʱ��ִ�У�ִ��һ��
	public void destroy() {
		// TODO �Զ����ɵķ������
		System.out.println("�����������رգ�Servletִ�����ٷ���");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override		//��ʼ������		ִֻ��һ��
	public void init(ServletConfig config) throws ServletException {
		// TODO �Զ����ɵķ������
		
		System.out.println("Servletִ�г�ʼ������");
		
	}

	@Override		//�ṩ����ķ���		ÿһ�η��ʴ�serviceʱִ��
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		
		System.out.println("Servletִ��service����");
	}

}
