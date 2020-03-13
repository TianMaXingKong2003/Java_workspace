package cn.itcast.web.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 重定向：资源跳转的方式
 */
@WebServlet("/ResponseServletDemo1")
public class ResponseServletDemo1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("ResponseServletDemo1被访问");
		
//		//访问此Servlet会自动跳转到/ResponseServletDemo2
//	
//		//1. 设置状态码为302
//        response.setStatus(302);
//        //2.设置响应头location
//        response.setHeader("location","/TomcatStudy/ResponseServletDemo2");
        
		
        //简单的重定向方法
		String contextPath = request.getContextPath();//动态获取虚拟目录
        response.sendRedirect(contextPath+"/ResponseServletDemo2");
        
        //重定向可以访问其他站点(服务器)的资源
        //response.sendRedirect("http://www.baidu.com");
        
		//重定向是两次请求		不能使用request对象来共享数据
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
