package wyp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wyp.bean.Company;
import wyp.bean.Person;
import wyp.service.imp.ICompanyServiceImp;
import wyp.service.imp.IPersonServiceImp;

/**
 * Servlet implementation class PersonUpdateServlet
 */
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
		if("个人".equals(type)){
			String sex = request.getParameter("sex");
			String birthday = request.getParameter("birthday");
			Person new_person = new Person(
					person.getId(),person.getUsername(),person.getPassword(),name, sex, birthday, phone, email, school, education, trade, salary, tip,person.getPubtime());
			new IPersonServiceImp().update(person);
			if("admin".equals(type2)) {
				out.println("alert('修改成功')");
				out.println("window.open ('"+request.getContextPath()+"/a_index.jsp','_top')");
			}else {
				session.setAttribute("person", new_person);
				out.println("alert('修改成功')");
				out.println("window.open ('"+request.getContextPath()+"/index.jsp','_top')"); 
			}
			
		}
		if("公司".equals(type)){
			String location = request.getParameter("location");
			Company new_company = new Company(
					company.getId(),company.getUsername(),company.getPassword(), name, phone, email, location, trade, salary, tip,company.getPubtime());
			new ICompanyServiceImp().update(new_company);
			if("admin".equals(type2)) {
				out.println("alert('修改成功')");
				out.println("window.open ('"+request.getContextPath()+"/a_index.jsp','_top')"); 
			}else {
				session.setAttribute("company", new_company);
				out.println("alert('修改成功')");
				out.println("window.open ('"+request.getContextPath()+"/c_index.jsp','_top')"); 
			}
		}
	    out.println("</script>");
	    out.println("</html>");      
	    out.flush();
	    out.close();
	}

}
