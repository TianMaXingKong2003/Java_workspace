package service.imp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.itcast.dao.IEmployeeDao;
import cn.itcast.domain.Company;
import cn.itcast.domain.Employee;
import cn.itcast.domain.Person;
import cn.itcast.util.JDBCUtils;
import service.IEmployeeService;
import tools.MyBatisSqlSessionFactory;

public class IEmployeeServiceImp implements IEmployeeService {

	//声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	
    /**
     * 添加雇佣	//测试通过
     * @param 
     * @return 
     */
	@Override
	public void insert(long p_id, long c_id) {
		// TODO Auto-generated method stub

		try {
			//1.编写sql			//默认isAgreed为0->即雇佣关系为未雇佣
	        String sql = "INSERT INTO employee VALUES ( id, "+p_id+","+ c_id+","+ 0+")";
	        //2.调用query方法
	        
	        System.out.println(p_id+"\t\t"+c_id);
	        
	        template.execute(sql);
	        
	        System.out.println("添加雇佣成功");
	       
	    } catch (DataAccessException e) {
	        //e.printStackTrace();//记录日志
	    	System.out.println("添加雇佣失败");
	        
	    }
	}
	
	/**
     * 查询雇佣	测试通过
     * @param 
     * @return 
     */
	@Override
	public Employee query(long p_id, long c_id) {
		// TODO Auto-generated method stub

		try {
			//1.编写sql
            String sql = "select * from employee where p_id=? and c_id=?";
            //2.调用query方法
            
            System.out.println(p_id+"\t\t"+c_id);
            
            Employee employees = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Employee>(Employee.class),p_id,c_id);

            System.out.println("查询雇佣成功");
            return employees;
            
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//记录日志
        	System.out.println("查询雇佣失败");
            return null;
        }
	}

	/**
     * 通过公司id查求职者	测试通过
     * @param 
     * @return 
     */
	@Override
	public List<Person> candidateQuery(long c_id) {
		// TODO Auto-generated method stub
		
		try {
            //1.编写sql
            String sql = "select person.ID,USERNAME,PASSWORD,NAME,SEX,BIRTHDAY,SCHOOL,PHONE,EMAIL,TRADE,SALARY,"
            		+ "TIP,PUBTIME,EDUCATION from person,employee where c_id=? and person.id=p_id order by isAgreed desc"; 
         
            //2.调用list方法
           
            List<Person> persons = template.query(sql,  
                    new BeanPropertyRowMapper<Person>(Person.class),c_id);  

            System.out.println("查询求职者成功");
    		return persons;
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//记录日志
        	System.out.println("查询求职者失败");
            return null;
        }
		
		
	}

	
	/**
     * 修改雇佣关系		//测试通过
     * @param 
     * @return 
     */
	@Override
	public void update(long isAgreed,long id) {
		// TODO Auto-generated method stub
		
		//update employee set isAgreed = #{0} where id=#{1}
		
		try {
			//1.编写sql			//默认isAgreed为0->即雇佣关系为未雇佣
	        String sql = "update employee set isAgreed = "+isAgreed+" where id= "+id;
	        //2.调用query方法
	        
	        System.out.println(isAgreed+"\t\t"+id);
	        
	        template.execute(sql);
	        
	        System.out.println("修改雇佣成功");
	       
	    } catch (DataAccessException e) {
	        //e.printStackTrace();//记录日志
	    	System.out.println("修改雇佣失败");
	        
	    }
	}

	
	/**
     * 通过求职者id查公司	测试通过
     * @param 
     * @return 
     */
	@Override
	public List<Company> companyQuery(long p_id) {
		// TODO Auto-generated method stub
		
		try {
            //1.编写sql
            String sql = "select company.ID,USERNAME,PASSWORD,NAME,LOCATION,PHONE,EMAIL,TRADE,TIP,SALARY,PUBTIME from "
            		+ "company,employee where p_id=? and company.id=c_id order by isAgreed desc";
            //2.调用query方法
            
            List<Company> companys = template.query(sql,
                    new BeanPropertyRowMapper<Company>(Company.class),p_id);

            System.out.println("通过求职者id查公司成功");
            return companys;
            
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//记录日志
        	System.out.println("通过求职者id查公司失败");
            return null;
        }
		
	}


}
