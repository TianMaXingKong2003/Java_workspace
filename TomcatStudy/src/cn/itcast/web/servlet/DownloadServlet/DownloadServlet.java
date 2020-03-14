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
		
		System.out.println("DownloadServlet被调用执行了");
		
//		1. 获取文件名称
		String filename = request.getParameter("filename");
		
//		2. 使用字节输入流加载文件进内存
			//2.1找到服务器的真实路径（通过ServletContext对象）
			ServletContext servletContext = this.getServletContext();
			String realPath = servletContext.getRealPath("/image/"+filename);
			//2.2用字节流关联
			FileInputStream fis=new FileInputStream(realPath);
			
//		3. 指定response的响应头类型和打开方式		content-disposition:attachment;filename=xxx
			String mimeType = servletContext.getMimeType(filename);
			response.setHeader("ContentType", mimeType);
			//未解决中文文件名问题，建议不要用中文名
			response.setHeader("content-disposition", "attachment;filename="+filename);
			
//		4. 将数据写出到response输出流
		ServletOutputStream os = response.getOutputStream();
		byte[] buff=new byte[1024*8];
		int len=0;
		while( (len=fis.read(buff))!=-1 ) {
			os.write(buff,0,len);
		}
		
//		关闭输入流，释放资源
		fis.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
