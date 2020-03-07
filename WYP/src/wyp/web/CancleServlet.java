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
 * Servlet implementation class PersonPublishServlet
 */
public class CancleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancleServlet() {
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
		//解决中文乱码问题
		String type = new String (request.getParameter("type").getBytes("ISO-8859-1"),"UTF-8");
		
		HttpSession session = request.getSession();
		//String type = request.getParameter("type");
		PrintWriter out = response.getWriter();
	    out.println("<html>");      
	    out.println("<script>");
	    //撤销简历
		if("个人".equals(type)){
			Person person = (Person) session.getAttribute("person");
			if(person.getPubtime()==null){
				out.println("alert('您还未布过简历！')");
			}else{
				new IPersonServiceImp().deleteResume(person);
				person.setPubtime(null);
				session.setAttribute("person", person);
				out.println("alert('撤销成功！')");
			}
			out.println("window.open ('"+request.getContextPath()+"/index.jsp','_top')");
		}
		
		if("公司".equals(type)){
			Company company = (Company) session.getAttribute("company");
			if(company.getPubtime()==null){
				out.println("alert('您还未布过招聘信息！')");
			}else{
				new ICompanyServiceImp().deleteInfo(company);
				company.setPubtime(null);
				session.setAttribute("company", company);
				out.println("alert('撤销成功！')");
			}
			out.println("window.open ('"+request.getContextPath()+"/c_index.jsp','_top')");    
		}
	    out.println("</script>");
	    out.println("</html>");      
	    out.flush();
	    out.close();
	}

}
