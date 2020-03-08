package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//通过注解来配置servlet，不通过web.xml文件
//需要加入这一行@WebServlet················

@WebServlet("/Demo3")
public class ServletDemo3 extends GenericServlet{

	//GenericServlet：将Servlet接口中其他的方法做了默认空实现
	//只将service()方法作为抽象将来定义Servlet类时
	//可以继承GenericServlet，实现service()方法即可
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		
		System.out.println("ServletDemo3执行了service方法");
		
	}

	

}
