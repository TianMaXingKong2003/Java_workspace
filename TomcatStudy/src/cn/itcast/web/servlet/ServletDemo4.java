package cn.itcast.web.servlet;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//注解里填写的url是数组格式，说明可以配置多个地址，多个地址可以映射同一个Servlet

//@WebServlet({"/ServletDemo4","/demo4","/Demo4","/servletdemo4"})

//还可以设置多层路径

@WebServlet("/user/demo4")

public class ServletDemo4 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("demo4执行service");
	}

}
