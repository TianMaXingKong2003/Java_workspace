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

	//����JDBCTemplate������
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	
    /**
     * ��ӹ�Ӷ	//����ͨ��
     * @param 
     * @return 
     */
	@Override
	public void insert(long p_id, long c_id) {
		// TODO Auto-generated method stub

		try {
			//1.��дsql			//Ĭ��isAgreedΪ0->����Ӷ��ϵΪδ��Ӷ
	        String sql = "INSERT INTO employee VALUES ( id, "+p_id+","+ c_id+","+ 0+")";
	        //2.����query����
	        
	        System.out.println(p_id+"\t\t"+c_id);
	        
	        template.execute(sql);
	        
	        System.out.println("��ӹ�Ӷ�ɹ�");
	       
	    } catch (DataAccessException e) {
	        //e.printStackTrace();//��¼��־
	    	System.out.println("��ӹ�Ӷʧ��");
	        
	    }
	}
	
	/**
     * ��ѯ��Ӷ	����ͨ��
     * @param 
     * @return 
     */
	@Override
	public Employee query(long p_id, long c_id) {
		// TODO Auto-generated method stub

		try {
			//1.��дsql
            String sql = "select * from employee where p_id=? and c_id=?";
            //2.����query����
            
            System.out.println(p_id+"\t\t"+c_id);
            
            Employee employees = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Employee>(Employee.class),p_id,c_id);

            System.out.println("��ѯ��Ӷ�ɹ�");
            return employees;
            
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//��¼��־
        	System.out.println("��ѯ��Ӷʧ��");
            return null;
        }
	}

	/**
     * ͨ����˾id����ְ��	����ͨ��
     * @param 
     * @return 
     */
	@Override
	public List<Person> candidateQuery(long c_id) {
		// TODO Auto-generated method stub
		
		try {
            //1.��дsql
            String sql = "select person.ID,USERNAME,PASSWORD,NAME,SEX,BIRTHDAY,SCHOOL,PHONE,EMAIL,TRADE,SALARY,"
            		+ "TIP,PUBTIME,EDUCATION from person,employee where c_id=? and person.id=p_id order by isAgreed desc"; 
         
            //2.����list����
           
            List<Person> persons = template.query(sql,  
                    new BeanPropertyRowMapper<Person>(Person.class),c_id);  

            System.out.println("��ѯ��ְ�߳ɹ�");
    		return persons;
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//��¼��־
        	System.out.println("��ѯ��ְ��ʧ��");
            return null;
        }
		
		
	}

	
	/**
     * �޸Ĺ�Ӷ��ϵ		//����ͨ��
     * @param 
     * @return 
     */
	@Override
	public void update(long isAgreed,long id) {
		// TODO Auto-generated method stub
		
		//update employee set isAgreed = #{0} where id=#{1}
		
		try {
			//1.��дsql			//Ĭ��isAgreedΪ0->����Ӷ��ϵΪδ��Ӷ
	        String sql = "update employee set isAgreed = "+isAgreed+" where id= "+id;
	        //2.����query����
	        
	        System.out.println(isAgreed+"\t\t"+id);
	        
	        template.execute(sql);
	        
	        System.out.println("�޸Ĺ�Ӷ�ɹ�");
	       
	    } catch (DataAccessException e) {
	        //e.printStackTrace();//��¼��־
	    	System.out.println("�޸Ĺ�Ӷʧ��");
	        
	    }
	}

	
	/**
     * ͨ����ְ��id�鹫˾	����ͨ��
     * @param 
     * @return 
     */
	@Override
	public List<Company> companyQuery(long p_id) {
		// TODO Auto-generated method stub
		
		try {
            //1.��дsql
            String sql = "select company.ID,USERNAME,PASSWORD,NAME,LOCATION,PHONE,EMAIL,TRADE,TIP,SALARY,PUBTIME from "
            		+ "company,employee where p_id=? and company.id=c_id order by isAgreed desc";
            //2.����query����
            
            List<Company> companys = template.query(sql,
                    new BeanPropertyRowMapper<Company>(Company.class),p_id);

            System.out.println("ͨ����ְ��id�鹫˾�ɹ�");
            return companys;
            
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//��¼��־
        	System.out.println("ͨ����ְ��id�鹫˾ʧ��");
            return null;
        }
		
	}


}
