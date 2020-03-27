package cn.itcast.web.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/httpdemo")
public class HttpServletDemo extends HttpServlet{
	
	@Override		//��дdoGet����
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		
		
		System.out.println("get����");
		
		//��ȡget��ʽ�������
		System.out.println("���������"+req.getQueryString());
		
		//��ȡ�ͻ�����IP��ַ��
		System.out.println("�ͻ�����IP��ַ��"+req.getRemoteAddr());
	}
	
	
	@Override		//��дdoPost����
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		
		System.out.println("post����");
		
		
	}
}
