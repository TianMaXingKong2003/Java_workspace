package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.domain.Company;
import cn.itcast.domain.Person;
import service.imp.ICompanyServiceImp;
import service.imp.IPersonServiceImp;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		System.out.println("doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.同步编码格式，防止中文乱码
		request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("rem");
		if(remember!=null){
			Cookie c1 = new Cookie("username",username);
			Cookie c2 = new Cookie("password",password);
			c1.setMaxAge(60*60*24*365);
			c2.setMaxAge(60*60*24*365);
			response.addCookie(c1);
			response.addCookie(c2);
		}
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		
		System.out.println(type);
		System.out.println("LoginServlet");
		
		
		if("person".equals(type)){
			
			Person person =null;
			person = new IPersonServiceImp().login(username, password);
			System.out.print(username);System.out.print("\t\t");System.out.println(password);
				
			if(person == null||"admin".equals(person.getPhone())){
				
				response.sendRedirect("login.jsp");
			}else {
				session.setAttribute("person",person);
				response.sendRedirect("index.jsp");
			}
		}
		if("business".equals(type)){
			Company company = new ICompanyServiceImp().login(username, password);
			if(company == null){
				response.sendRedirect("login.jsp");
			}else {
				session.setAttribute("company",company);
				response.sendRedirect("c_index.jsp");
			}
		}
		if("admin".equals(type)){
			Person person = new IPersonServiceImp().login(username, password);
			if(person == null){
				response.sendRedirect("login.jsp");
			}else if("admin".equals(person.getPhone())){
				//鎵�鏈夌殑鍏徃杩斿洖
				List<Company> companyList=new ICompanyServiceImp().listAllCompanies();
				session.setAttribute("companyList", companyList);
				List<Person> personList=new IPersonServiceImp().listAllPersons();
				session.setAttribute("personList", personList);
				session.setAttribute("admin",person);				
				response.sendRedirect("a_index.jsp");
			}else {
				response.sendRedirect("login.jsp");
			}
		}
		
	}

}
