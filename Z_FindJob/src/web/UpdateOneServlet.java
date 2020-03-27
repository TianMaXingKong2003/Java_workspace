package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Company;
import bean.Person;
import service.imp.ICompanyServiceImp;

/**
 * Servlet implementation class UpdateOneServlet
 */
public class UpdateOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOneServlet() {
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
		String id=request.getParameter("cid");
		String cz=request.getParameter("cz");
		long lid=Long.parseLong(id);
		PrintWriter out = response.getWriter();
	    out.println("<html>");      
	    out.println("<script>");
		if("update".equals(cz)) {
			Company company = new ICompanyServiceImp().query(lid);
			session.setAttribute("company", company);
			out.println("window.open ('"+request.getContextPath()+"/a_update.jsp','_top')"); 
		}else {
			Company company2 = new ICompanyServiceImp().query(lid);
			new ICompanyServiceImp().deleteInfo(company2);
			List<Company> companyList=new ICompanyServiceImp().listAllCompanies();
			session.setAttribute("companyList", companyList);
			session.setAttribute("admin",person);
			out.println("alert('删除成功')");
			out.println("window.open ('"+request.getContextPath()+"/a_index.jsp','_top')"); 
		}
	
	    out.println("</script>");
	    out.println("</html>");      
	    out.flush();
	    out.close();
	}

}
