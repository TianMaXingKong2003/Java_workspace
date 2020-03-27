package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Company;
import bean.Person;
import service.imp.ICompanyServiceImp;
import service.imp.IPersonServiceImp;

/**
 * Servlet implementation class PersonRegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String trade = request.getParameter("trade");
		String salary = request.getParameter("salary");
		String tip = request.getParameter("tip");
		String sex = request.getParameter("sex");
		String isAuto = request.getParameter("isAuto");
		boolean bool = false;
        PrintWriter out = response.getWriter(); 
        //涓汉娉ㄥ唽
		if(sex!=null){
			String birthday = request.getParameter("birthday");
			String school = request.getParameter("school");
			String education = request.getParameter("education");
			Person person = new Person(username, password, name, sex, birthday, phone, email, school, education, trade, salary, tip);
			IPersonServiceImp iPersonServiceImp = new IPersonServiceImp();
			bool = iPersonServiceImp.register(person);
			if(bool == false){
				//ajax鍚戝墠鍙颁紶鍊�
		        out.write("璇ョ敤鎴峰悕宸插瓨鍦紒");      
		    //娉ㄥ唽鎴愬姛
			}else{
				//娉ㄥ唽瀹岀珛鍗冲彂甯冪畝鍘�
				if(isAuto!=null){
					person.setPubtime(new Date());
					iPersonServiceImp.publish(person);
				}
			}
		}
		//鍏徃娉ㄥ唽
		else{
			String location = request.getParameter("location");
			Company company = new Company(username, password, name, phone, email, location, trade, salary, tip);
			ICompanyServiceImp iCompanyServiceImp = new ICompanyServiceImp();
			bool = iCompanyServiceImp.register(company);
			if(bool == false){
		        out.write("璇ョ敤鎴峰悕宸插瓨鍦紒");
			//娉ㄥ唽鎴愬姛
			}else{
				//娉ㄥ唽瀹岀珛鍗冲彂甯冪畝鍘�
				if(isAuto!=null){
					company.setPubtime(new Date());
					iCompanyServiceImp.publish(company);
				}
			}
		}
        out.flush();
        out.close();
	}

}
