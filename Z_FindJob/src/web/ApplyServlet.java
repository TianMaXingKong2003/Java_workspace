package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Employee;
import service.imp.IEmployeeServiceImp;

@WebServlet("/applyServlet")
public class ApplyServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyServlet() {
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
	//���빫˾
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<html>");      
		out.println("<script>");
		long p_id = Long.parseLong(request.getParameter("p_id"));
		long c_id = Long.parseLong(request.getParameter("c_id"));
		IEmployeeServiceImp iEmployeeServiceImp = new IEmployeeServiceImp();
		Employee employee = iEmployeeServiceImp.query(p_id, c_id);
		if(employee==null){
			 iEmployeeServiceImp.insert(p_id, c_id);
			 out.println("alert('����ɹ�')");
		}else{
			 out.println("alert('����������ù�˾�������ظ����룡')");
		}
		out.println("window.open ('"+request.getContextPath()+"/index.jsp','_top')"); 
	    out.println("</script>");
	    out.println("</html>"); 
	    out.flush();
	    out.close();
	}

}
