package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.domain.Person;
import service.imp.IPersonServiceImp;

@WebServlet("/updateOneServlet2")
public class UpdateOneServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOneServlet2() {
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
		String id=request.getParameter("pid");
		String cz=request.getParameter("cz");
		long lid=Long.parseLong(id);
		PrintWriter out = response.getWriter();
	    out.println("<html>");      
	    out.println("<script>");
	    
		if("update".equals(cz)) {
			Person person1 = new IPersonServiceImp().query(lid);
			session.setAttribute("person", person1);
			out.println("window.open ('"+request.getContextPath()+"/a_update2.jsp','_top')"); 
		}else {
			Person person2 = new IPersonServiceImp().query(lid);
			new IPersonServiceImp().deleteInfo(person2);
			List<Person> personlist=new IPersonServiceImp().listAllPersons();
			session.setAttribute("personlist", personlist);
			session.setAttribute("admin",person);
			out.println("alert('É¾³ý³É¹¦')");
			out.println("window.open ('"+request.getContextPath()+"/a_index.jsp','_top')"); 
		}
	
	    out.println("</script>");
	    out.println("</html>");      
	    out.flush();
	    out.close();
	}

}
