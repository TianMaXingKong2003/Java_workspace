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

		System.out.println("ResponseServletDemo3������");

		//�������ñ��룬Ҫ�ڻ�ȡ��֮ǰ���ã����������߿ͻ��˱�����Ӧ�����ݸ�ʽ�Լ������ʽ
		response.setContentType("text/html;charset=gbk");	
		//1.��ȡ�ֽ������
		ServletOutputStream os = response.getOutputStream();
		//2.�������
		os.write("welcome �����п�".getBytes());
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
