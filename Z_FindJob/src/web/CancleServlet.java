package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

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

@WebServlet("/cancleServlet")

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

		//1.同步编码格式，防止中文乱码
		response.setContentType("text/html;charset=utf-8");   
		request.setCharacterEncoding("utf-8"); 
		response.setCharacterEncoding("utf-8"); 
		
		String type=request.getParameter("type");
		
		System.out.println("publishServlet");
		System.out.println(type);
		
		HttpSession session = request.getSession();
		//String type = request.getParameter("type");
		PrintWriter out = response.getWriter();
	    out.println("<html>");      
	    out.println("<script>");
	    
	    
	    //撤销简历
		if("person".equals(type)){	
			Person person = (Person) session.getAttribute("person");
			Date flag = person.getPubtime();
			System.out.println(flag==null);
			
			if(flag==null){
				out.println("alert('您还未布过简历！')");
			}else{
				new IPersonServiceImp().deleteResume(person);
				person.setPubtime(null);
				session.setAttribute("person", person);
				out.println("alert('撤销成功！')");
			}
			out.println("window.open ('"+request.getContextPath()+"/index.jsp','_top')");
		}
		
		if("company".equals(type)){
			
			Company company = (Company) session.getAttribute("company");
			Date flag = company.getPubtime();
			System.out.println(flag==null);
			
			if(flag==null){
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
