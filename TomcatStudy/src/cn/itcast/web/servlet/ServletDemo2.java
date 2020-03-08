package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo2 implements Servlet{

	@Override		//销毁方法		服务器正常关闭的时候执行，执行一次
	public void destroy() {
		// TODO 自动生成的方法存根
		System.out.println("服务器正常关闭，ServletDemo2执行销毁方法");
	}

	@Override		//获取Servlet配置
	public ServletConfig getServletConfig() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override		//获取Servlet信息
	public String getServletInfo() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override		//初始化方法		只执行一次
	public void init(ServletConfig config) throws ServletException {
		// TODO 自动生成的方法存根
		
		System.out.println("ServletDemo2执行初始化方法");
		
	}

	@Override		//提供服务的方法		每一次访问此service时执行
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		
		System.out.println("ServletDemo2执行service方法");
	}
}
