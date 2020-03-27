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
	
	@Override		//覆写doGet方法
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		
		
		System.out.println("get请求");
		
		//获取get方式请求参数
		System.out.println("请求参数："+req.getQueryString());
		
		//获取客户机的IP地址：
		System.out.println("客户机的IP地址："+req.getRemoteAddr());
	}
	
	
	@Override		//覆写doPost方法
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		
		System.out.println("post请求");
		
		
	}
}
