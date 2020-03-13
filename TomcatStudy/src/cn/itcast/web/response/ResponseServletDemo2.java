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
		
		System.out.println("ResponseServletDemo2������");
		

		//�������ñ��룬Ҫ�ڻ�ȡ��֮ǰ���ã����������߿ͻ��˱�����Ӧ�����ݸ�ʽ�Լ������ʽ
		response.setContentType("text/html;charset=gbk");	
		
		
		//1.��ȡ�ַ������
		PrintWriter pw = response.getWriter();
		//2.�������
		pw.write("<h1>Made in �����п�</h1>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
