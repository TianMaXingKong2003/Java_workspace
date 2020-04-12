package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.domain.Company;
import cn.itcast.domain.Person;
import service.imp.ICompanyServiceImp;
import service.imp.IPersonServiceImp;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.同步编码格式，防止中文乱码
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		Person person = (Person) session.getAttribute("person");
		Company company = (Company) session.getAttribute("company");
		String name = request.getParameter("name");
		String school = request.getParameter("school");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String education = request.getParameter("education");
		String trade = request.getParameter("trade");
		String salary = request.getParameter("salary");
		String tip = request.getParameter("tip");
		String type = request.getParameter("type");
		String type2 = request.getParameter("type2");
		PrintWriter out = response.getWriter();
		System.out.println(type);
	    out.println("<html>");      
	    out.println("<script>");
	    
	    System.out.println("updateServlet");
	    
	    String sex = request.getParameter("xingbie");
	    
		String birthday = request.getParameter("birthday");
	    
//	    System.out.println(person.getId());
//		System.out.println(person.getUsername());
//		System.out.println(person.getPassword());
//		System.out.println(name);
//		System.out.println(sex);
//		System.out.println(birthday);
//		System.out.println(phone);
//		System.out.println(email);
//		System.out.println(school);
//		System.out.println(education);
//		System.out.println(trade);
//		System.out.println(salary);
//		System.out.println(tip);
//		System.out.println(person.getPubtime());
	    
		if("person".equals(type)){
			
			Person new_person = new Person(
					person.getId(),person.getUsername(),person.getPassword(),name, sex, birthday, phone, email, school, education, trade, salary, tip,person.getPubtime());
			
			System.out.println("修改内容");
			
			new IPersonServiceImp().update(person);
			if("admin".equals(type2)) {
				out.println("alert('Success!')");
				out.println("window.open ('"+request.getContextPath()+"/a_index.jsp','_top')");
			}else {
				session.setAttribute("person", new_person);
				out.println("alert('Success!')");
				out.println("window.open ('"+request.getContextPath()+"/index.jsp','_top')"); 
			}
			
		}
		if("business".equals(type)){
			String location = request.getParameter("location");
			Company new_company = new Company(
					company.getId(),company.getUsername(),company.getPassword(), name, phone, email, location, trade, salary, tip,company.getPubtime());
			new ICompanyServiceImp().update(new_company);
			if("admin".equals(type2)) {
				out.println("alert('Success!')");
				out.println("window.open ('"+request.getContextPath()+"/a_index.jsp','_top')"); 
			}else {
				session.setAttribute("company", new_company);
				out.println("alert('Success!')");
				out.println("window.open ('"+request.getContextPath()+"/c_index.jsp','_top')"); 
			}
		}
	    out.println("</script>");
	    out.println("</html>");      
	    out.flush();
	    out.close();
	}

}
