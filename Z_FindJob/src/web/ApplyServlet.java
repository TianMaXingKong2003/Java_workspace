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
	//申请公司
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.同步编码格式，防止中文乱码
		response.setContentType("text/html;charset=utf-8");   
		request.setCharacterEncoding("utf-8"); 
		response.setCharacterEncoding("utf-8"); 
		
		PrintWriter out = response.getWriter();
		out.println("<html>");      
		out.println("<script>");
		long p_id = Long.parseLong(request.getParameter("p_id"));
		long c_id = Long.parseLong(request.getParameter("c_id"));
		IEmployeeServiceImp iEmployeeServiceImp = new IEmployeeServiceImp();
		Employee employee = iEmployeeServiceImp.query(p_id, c_id);
		
		if(employee==null){
			 iEmployeeServiceImp.insert(p_id, c_id);
			 out.println("alert('申请成功')");
		}else{
			 out.println("alert('您已申请过该公司！不能重复申请！')");
		}
		out.println("window.open ('"+request.getContextPath()+"/index.jsp','_top')"); 
	    out.println("</script>");
	    out.println("</html>"); 
	    out.flush();
	    out.close();
	}

}
