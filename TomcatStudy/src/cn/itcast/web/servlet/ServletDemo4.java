package cn.itcast.web.servlet;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//ע������д��url�������ʽ��˵���������ö����ַ�������ַ����ӳ��ͬһ��Servlet

//@WebServlet({"/ServletDemo4","/demo4","/Demo4","/servletdemo4"})

//���������ö��·��

@WebServlet("/user/demo4")

public class ServletDemo4 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("demo4ִ��service");
	}

}
