package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Company;
import bean.Person;
import service.imp.ICompanyServiceImp;
import service.imp.IPersonServiceImp;

/**
 * Servlet implementation class PersonPublishServlet
 */
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
		//瑙ｅ喅涓枃涔辩爜闂
		String type = new String (request.getParameter("type").getBytes("ISO-8859-1"),"UTF-8");
//		request.setCharacterEncoding("UTF-8");
//		String type = request.getParameter("type");
		PrintWriter out = response.getWriter();
	    out.println("<html>");      
	    out.println("<script>"); 
		Date date = new Date();
		if("涓汉".equals(type)){
			Person person = (Person) session.getAttribute("person");
			if(person.getPubtime()!=null){
				out.println("alert('鎮ㄥ凡鍙戝竷杩囩畝鍘嗭紒涓嶈兘閲嶅鍙戝竷锛�')");
			}else{
				person.setPubtime(date);
				new IPersonServiceImp().publish(person);
				session.setAttribute("person", person);
				out.println("alert('鍙戝竷鎴愬姛锛�')");
			}
			
			out.println("window.open ('"+request.getContextPath()+"/index.jsp','_top')");
		}
		
		if("鍏徃".equals(type)){
			Company company = (Company) session.getAttribute("company");
			if(company.getPubtime()!=null){
				out.println("alert('鎮ㄥ凡鍙戝竷杩囨嫑鑱樹俊鎭紒涓嶈兘閲嶅鍙戝竷锛�')");
			}else{
				company.setPubtime(date);
				new ICompanyServiceImp().publish(company);
				session.setAttribute("company", company);
		    	out.println("alert('鍙戝竷鎴愬姛锛�')");
			}
	    	out.println("window.open ('"+request.getContextPath()+"/c_index.jsp','_top')");
		}
	    out.println("</script>");
	    out.println("</html>");      
	    out.flush();
	    out.close();
	}

}