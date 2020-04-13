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


@WebServlet("/publishServlet")

public class PublishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishServlet() {
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
		//解决中文乱码问题
		//String type = new String (request.getParameter("type").getBytes("ISO-8859-1"),"UTF-8");
		
		//1.同步编码格式，防止中文乱码
		response.setContentType("text/html;charset=utf-8");   
		request.setCharacterEncoding("utf-8"); 
		response.setCharacterEncoding("utf-8"); 
		
		String type=request.getParameter("type");
		
		System.out.println("publishServlet");
		System.out.println(type);
		
//		request.setCharacterEncoding("UTF-8");
//		String type = request.getParameter("type");
		PrintWriter out = response.getWriter();
	    out.println("<html>");      
	    out.println("<script>"); 
		Date date = new Date();
		
		if("person".equals(type)){
			Person person = (Person) session.getAttribute("person");
			  Date flag = person.getPubtime();
			System.out.println(flag==null);
			if(flag!=null){
				out.println("alert('您已发布过简历！不能重复发布！')");
			}else{
				
				person.setPubtime(date);
				new IPersonServiceImp().publish(person);
				session.setAttribute("person", person);
				out.println("alert('发布成功！')");
			}
			
			out.println("window.open ('"+request.getContextPath()+"/index.jsp','_top')");
		}
		
		if("company".equals(type)){
			Company company = (Company) session.getAttribute("company");
			Date flag = company.getPubtime();
			System.out.println(flag==null);
			
			if(flag!=null){
				out.println("alert('您已发布过招聘信息！不能重复发布！')");
			}else{
				company.setPubtime(date);
				new ICompanyServiceImp().publish(company);
				session.setAttribute("company", company);
		    	out.println("alert('发布成功！')");
			}
	    	out.println("window.open ('"+request.getContextPath()+"/c_index.jsp','_top')");
		}
	    out.println("</script>");
	    out.println("</html>");      
	    out.flush();
	    out.close();
	}

}
