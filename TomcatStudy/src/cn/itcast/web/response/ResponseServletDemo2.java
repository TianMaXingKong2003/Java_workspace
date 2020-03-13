package cn.itcast.web.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseServletDemo2
 */
@WebServlet("/ResponseServletDemo2")
public class ResponseServletDemo2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("ResponseServletDemo2被访问");
		

		//首先设置编码，要在获取流之前设置，服务器告诉客户端本次响应体数据格式以及编码格式
		response.setContentType("text/html;charset=gbk");	
		
		
		//1.获取字符输出流
		PrintWriter pw = response.getWriter();
		//2.输出数据
		pw.write("<h1>Made in 天马行空</h1>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
