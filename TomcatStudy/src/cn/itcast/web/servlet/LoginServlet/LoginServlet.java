package cn.itcast.web.servlet.LoginServlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.同步编码格式，防止中文乱码
		request.setCharacterEncoding("utf-8");
		
//		//2.参数名称获取参数值
//		String username = request.getParameter("username");	System.out.println(username);
//		String password = request.getParameter("password");System.out.println(password+"\n");
//		//3.封装user对象
//		User loginuser=new User();
//		loginuser.setUsername(username);loginuser.setPassword(password);
		
		//2.获取请求里的所有参数
		Map<String, String[]> map = request.getParameterMap();
		//3.创建User对象		并使用BeanUtils封装(用org.apache的)
		User loginuser=new User();
		try {
			BeanUtils.populate(loginuser, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		//4.调用UserDao的login方法
		UserDao dao=new UserDao();
		User user = dao.login(loginuser);
		
		//5.判断user
		if (user==null) {
			System.out.println("登录失败");
			
			//转发到
			request.getRequestDispatcher("/FailServlet").forward(request, response);
			
		}else {
			System.out.println("登录成功");
			//存储数据
			request.setAttribute("user", user);
			//转发到
			request.getRequestDispatcher("/SuccessServlet").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
