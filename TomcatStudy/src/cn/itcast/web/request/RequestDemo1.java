package cn.itcast.web.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo1
 */
@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//1.获取请求的行数据
		
				System.out.println("1.获取请求的行数据\n");
		
		  		System.out.println("1.1 获取请求方式 ："+request.getMethod());
				
		  		System.out.println("1.2 获取虚拟目录："+request.getContextPath());
					
		  		System.out.println("1.3 获取Servlet路径: "+request.getServletPath());
				
				System.out.println("1.4 获取get方式请求参数："+request.getQueryString());
				
				System.out.println("1.5 获取请求URI："+request.getRequestURI());		//URL:统一资源定位符	URI：统一资源标识符
					
				System.out.println("1.6 获取协议及版本："+request.getProtocol());
				
				System.out.println("1.7 获取客户机的IP地址："+request.getRemoteAddr()+"\n");
	
		//2.获取请求的头数据
				
				System.out.println("2.获取请求的头数据\n");
				
				System.out.println("首先获取所有的请求头名称：");
				
				Enumeration<String> headerNames = request.getHeaderNames();//得到所有的名称集合
				
				while (headerNames.hasMoreElements()) {					//遍历所有的名称
					String name = (String) headerNames.nextElement();
					String value = request.getHeader(name);
					System.out.println("名称："+name+"\t\t"+"值："+value);
					
				}
				
				//名称：user-agent 判断浏览器版本/客户端的系统
				String agent = request.getHeader("user-agent");
				
				if (agent.contains("Chrome")) {
					//谷歌浏览器
					System.out.println("用户使用的是谷歌浏览器");
				}else if (agent.contains("Firefox")) {
					//火狐浏览器
					System.out.println("用户使用的是火狐浏览器");
				}
				
				//名称：用户从哪里访问请求本服务的（浏览器里直接输入地址为空，超链接方式则显示源头）
				String referer = request.getHeader("referer");
				
				System.out.println("用户的从"+referer+"访问链接");
				
				
				//（常用）获取请求参数的通用方式
				
				//不论get还是post请求方式都可以使用下列方法来获取请求参数
				
				//1.String getParameter(String name):根据参数名称获取参数值    username=zs&password=123
				//2.String[] getParameterValues(String name):根据参数名称获取参数值的数组  hobby=xx&hobby=game
				//3.Enumeration<String> getParameterNames():获取所有请求的参数名称
				//4.Map<String,String[]> getParameterMap():获取所有参数的map集合
				
	}

	
	@SuppressWarnings("unlikely-arg-type")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//只有POST请求方式，才有请求体，在请求体中封装了POST请求的请求参数
		System.out.println("获取post请求的体数据");
		
//		//方法1（不常用）
//			//步骤：1. 获取流对象		
//			BufferedReader reader = request.getReader();
//			//2. 再从流对象中拿数据
//			String line=null;
//			while ( (line=reader.readLine()) !=null){
//				System.err.println(line);
//			}
		
		//方法2（常用）获取请求参数的通用方式
			
			//不论get还是post请求方式都可以使用下列方法来获取请求参数
			
			//1.String getParameter(String name):根据参数名称获取参数值    username=zs&password=123
			//2.String[] getParameterValues(String name):根据参数名称获取参数值的数组  hobby=xx&hobby=game
			//3.Enumeration<String> getParameterNames():获取所有请求的参数名称
			//4.Map<String,String[]> getParameterMap():获取所有参数的map集合

		/*
		* 中文乱码问题：
			* get方式：tomcat 8 已经将get方式乱码问题解决了
			* post方式：会乱码
			* 解决：在获取参数前，设置request的编码request.setCharacterEncoding("utf-8");*/	//格式要和html一致
		//注意：有时候你用eclipse编写html的中文字符时，要注意系统首选项里的格式是gbk还是utf-8
	
		request.setCharacterEncoding("gbk");//同步编码格式
		
		//1.根据参数名称获取参数值
		System.out.println("1.根据参数名称获取参数值");
		
		String username = request.getParameter("username");	System.out.println(username);
		String password = request.getParameter("password");System.out.println(password+"\n");
		
		
		
		//2.根据参数名称获取参数值的数组
		System.out.println("2.根据参数名称获取参数值的数组");
		
		String[] hobbies = request.getParameterValues("hobby");
		if (hobbies==null) {
			System.out.print("用户未勾选任何选项");
		}else {
			for(String string:hobbies)
				System.out.print(string+"\t");
		}System.out.println("\n");
		
		
	
		//3.获取所有请求的参数名称
		System.out.println("3.获取所有请求的参数名称");
		
		Enumeration<String> parameterNames = request.getParameterNames();
		System.out.print("获取所有请求的参数名称：");
		while (parameterNames.hasMoreElements()) {
			String string = (String) parameterNames.nextElement();
			System.out.print(string+"\t\t");
		}System.out.println("\n");
		
		
		
		//4.获取所有参数的map集合
		System.out.println("4.获取所有参数的map集合");
		Map<String, String[]> parameterMap = request.getParameterMap();
		
		for(String key:parameterMap.keySet()) {//用keySet()遍历Map集合
			
			System.out.print(key+"------->");
			
			//获取值
			for (int i = 0; i < parameterMap.get(key).length; i++) {
				System.out.print(parameterMap.get(key)[i]+" \t ");
			}
			System.out.println();
		}
		
		
	}

	
}
