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
		
		//1.ͬ�������ʽ����ֹ��������
		request.setCharacterEncoding("utf-8");
		
//		//2.�������ƻ�ȡ����ֵ
//		String username = request.getParameter("username");	System.out.println(username);
//		String password = request.getParameter("password");System.out.println(password+"\n");
//		//3.��װuser����
//		User loginuser=new User();
//		loginuser.setUsername(username);loginuser.setPassword(password);
		
		//2.��ȡ����������в���
		Map<String, String[]> map = request.getParameterMap();
		//3.����User����		��ʹ��BeanUtils��װ(��org.apache��)
		User loginuser=new User();
		try {
			BeanUtils.populate(loginuser, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		//4.����UserDao��login����
		UserDao dao=new UserDao();
		User user = dao.login(loginuser);
		
		//5.�ж�user
		if (user==null) {
			System.out.println("��¼ʧ��");
			
			//ת����
			request.getRequestDispatcher("/FailServlet").forward(request, response);
			
		}else {
			System.out.println("��¼�ɹ�");
			//�洢����
			request.setAttribute("user", user);
			//ת����
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
