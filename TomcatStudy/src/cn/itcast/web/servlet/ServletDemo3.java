package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//通过注解来配置servlet，不通过web.xml文件
//需要加入这一行@WebServlet················

@WebServlet("/demo3")
public class ServletDemo3 implements Servlet{

	@Override
	public void destroy() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		
	}

}
