package cn.itcast.web.servlet.LoginServlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		String checkCode_session = (String) session.getAttribute("checkCode_session");
		String checkCode=loginuser.getCheckCode();
		//删除session中的验证码（为了安全）
		session.removeAttribute("checkCode_session");
		//首先判断验证码是否正确
		System.out.print("当前的验证码："+checkCode_session);
		System.out.println("\t用户提交的验证码："+checkCode);
		if (checkCode_session!=null && checkCode_session.equalsIgnoreCase(checkCode)) {
			//忽略大小写比较字符串
			//判断账号信息和数据库进行的比较
			
			if (user==null) {
				System.out.println("登录失败");
				
				//转发到
				//request.getRequestDispatcher("/FailServlet").forward(request, response);
				
				//存储提示信息到request
				request.setAttribute("login_error", "用户名或密码错误");
				//转发到登录页面
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				
			}else {
				System.out.println("登录成功");
				//存储数据 request.setAttribute("user", user);
				//转发 request.getRequestDispatcher("/SuccessServlet").forward(request, response);
				
				//存储数据到session
				session.setAttribute("user", user);
				//重定向到新的页面
				String contextPath = request.getContextPath();//动态获取虚拟目录
		        response.sendRedirect(contextPath+"/success.jsp");
				
				
			}
			
		}else {
			//验证码不一致
			
			//存储提示信息到request
			request.setAttribute("checkCode_error", "验证码错误");
			//转发到登录页面
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
