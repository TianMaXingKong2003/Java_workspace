package cn.itcast.web.servlet.DownloadServlet;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.util.DownLoadUtils;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("DownloadServlet������ִ����");
		
//		1. ��ȡ�ļ�����
		String filename = request.getParameter("filename");
		
//		2. ʹ���ֽ������������ļ����ڴ�
			//2.1�ҵ�����������ʵ·����ͨ��ServletContext����
			ServletContext servletContext = this.getServletContext();
			String realPath = servletContext.getRealPath("/image/"+filename);
			//2.2���ֽ�������
			FileInputStream fis=new FileInputStream(realPath);
			
//		3. ָ��response����Ӧͷ���ͺʹ򿪷�ʽ		content-disposition:attachment;filename=xxx
			String mimeType = servletContext.getMimeType(filename);
			response.setHeader("ContentType", mimeType);
			//δ��������ļ������⣬���鲻Ҫ��������
			response.setHeader("content-disposition", "attachment;filename="+filename);
			
//		4. ������д����response�����
		ServletOutputStream os = response.getOutputStream();
		byte[] buff=new byte[1024*8];
		int len=0;
		while( (len=fis.read(buff))!=-1 ) {
			os.write(buff,0,len);
		}
		
//		�ر����������ͷ���Դ
		fis.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
