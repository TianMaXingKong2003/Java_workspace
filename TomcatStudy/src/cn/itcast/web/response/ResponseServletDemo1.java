package cn.itcast.web.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �ض�����Դ��ת�ķ�ʽ
 */
@WebServlet("/ResponseServletDemo1")
public class ResponseServletDemo1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("ResponseServletDemo1������");
		
//		//���ʴ�Servlet���Զ���ת��/ResponseServletDemo2
//	
//		//1. ����״̬��Ϊ302
//        response.setStatus(302);
//        //2.������Ӧͷlocation
//        response.setHeader("location","/TomcatStudy/ResponseServletDemo2");
        
		
        //�򵥵��ض��򷽷�
		String contextPath = request.getContextPath();//��̬��ȡ����Ŀ¼
        response.sendRedirect(contextPath+"/ResponseServletDemo2");
        
        //�ض�����Է�������վ��(������)����Դ
        //response.sendRedirect("http://www.baidu.com");
        
		//�ض�������������		����ʹ��request��������������
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
