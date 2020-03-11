package cn.itcast.web.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo2
 */
@WebServlet("/RequestDemo2")
public class RequestDemo2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
System.out.println("RequestDemo2被访问了，通过请求转发机制访问RequestDemo3");
		
		
		//存储数据到request域中		(String  键，Objiect  值)
		
		request.setAttribute("msg", "hello");
		
		
		
		
		
		
		//1. 通过request对象获取请求转发器对象	
		//2. 使用RequestDispatcher对象来进行转发
		
		request.getRequestDispatcher("/RequestDemo3").forward(request, response);
		
		//只能转发到当前服务器内部资源中
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
