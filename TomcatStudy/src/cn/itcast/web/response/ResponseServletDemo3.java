package cn.itcast.web.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseServletDem3
 */
@WebServlet("/ResponseServletDemo3")
public class ResponseServletDemo3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("ResponseServletDemo3被访问");

		//首先设置编码，要在获取流之前设置，服务器告诉客户端本次响应体数据格式以及编码格式
		response.setContentType("text/html;charset=gbk");	
		//1.获取字节输出流
		ServletOutputStream os = response.getOutputStream();
		//2.输出数据
		os.write("welcome 天马行空".getBytes());
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
