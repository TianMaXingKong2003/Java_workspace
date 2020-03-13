package cn.itcast.web.servlet.LoginServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.User;

/**
 * Servlet implementation class SuccessServlet
 */
@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��ȡrequest���й����user����
        User user = (User) request.getAttribute("user");

        if(user != null){
            //��ҳ��дһ�仰

            //���ñ���
            response.setContentType("text/html;charset=utf-8");
            //���
            response.getWriter().write("��¼�ɹ���"+user.getUsername()+",��ӭ��");
        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
