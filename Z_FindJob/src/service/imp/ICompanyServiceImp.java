package service.imp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import cn.itcast.domain.Company;
import cn.itcast.util.JDBCUtils;
import service.ICompanyService;


public class ICompanyServiceImp implements ICompanyService{

	//����JDBCTemplate������
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	
    
    
	/* ��ʾ���й�˾����Ƹ��Ϣ	����ͨ��
	 * ����List����
	 */
    @Override
	public List<Company> listAllCompanies() {
		// TODO Auto-generated method stub
		
		try {
            //1.��дsql
            String sql = "select * from company where pubtime is not null order by pubtime desc";
            //2.����list����
           
            List<Company> companies = template.query(sql,  
                    new BeanPropertyRowMapper<Company>(Company.class));  
           
            
    		return companies;
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//��¼��־
            return null;
        }
		
	}

    
	/* ��������ʾ���й�˾����Ƹ��Ϣ	����ͨ��
	 * ����List����
	 */
    @Override
	public List<Company> listAllCompaniesByParams(Map<String, String> map) {
	
		try {
			 //1.��дsql
	        String sql = "select * from company where pubtime is not null ";
	        
	        for(Map.Entry<String, String> entry : map.entrySet()){
	            String mapKey = entry.getKey();
	            String mapValue = entry.getValue();
	            //System.out.println(mapKey+":"+mapValue);
	            
	            if("trade".equals(mapKey))		sql+=" and trade="+"\""+mapValue+"\"";
	            
	            if("salary".equals(mapKey))		sql+=" and salary="+"\""+mapValue+"\"";
	            
	            if("pubtime".equals(mapKey))		sql+=" and STR_TO_DATE( "+mapValue+", '%Y-%m-%d %H:%i:%s') ";
	        }
	        
	        System.out.println(sql);
	        
	        System.out.println("\"\"");       //����ת���ַ�
	        
            //2.����list����
           
            List<Company> companies = template.query(sql,  
                    new BeanPropertyRowMapper<Company>(Company.class));  
          
          System.out.println("�鿴���صĽ��");
          
            
//    		for (Company company : companies) {
//    			System.out.println(company);
//    		}
            
    		return companies;
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//��¼��־
            return null;
        }
	}

    /**
     * ע�᷽��	����ͨ��
     * @param company
     * @return 
     */
	@Override
	public boolean register(Company company) {
		// TODO Auto-generated method stub
		Company c=null;
		try {
			//1.��дsql
			String sql = "select * from company where username= ?";
			//2.����query����
			c = template.queryForObject(sql,
			        new BeanPropertyRowMapper<Company>(Company.class),
			        company.getUsername());
		} catch (DataAccessException e) {
			c =null;
		}
		
		if(c==null){
        	System.out.println("��ʼ�洢����");
			//�洢���û�

////        	//��ȡϵͳʱ�䡪��ע��ʱ��
//        	SimpleDateFormat sdf_Time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        	String registerTime=sdf_Time.format(new Date());
    		
        	//insert into company VALUES (id,username,password,name,location,phone,email,trade,tip,salary)
        	
        	String InsertSql="INSERT INTO company VALUES ( id, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        	template.update(InsertSql,company.getUsername(),company.getPassword(),company.getName(),
        											company.getLocation(),company.getPhone(),company.getEmail(),
        											company.getTrade(),company.getTip(),company.getSalary(),null);
			
        	return true;
		}else{
			return false;
		}
		
	}

	
	/**
     * ��¼����	����ͨ��
     * @param login ֻ���û���������
     * @return Company�����û�ȫ������,û�в�ѯ��������null
     */
	@Override
	public Company login(String username, String password) {
		// TODO Auto-generated method stub

		try {
            //1.��дsql
            String sql = "select * from company where username = ? and password = ?";
            //2.����query����
            
            Company company = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Company>(Company.class),
                    username, password);

            System.out.println("��¼�ɹ�");
            return company;
            
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//��¼��־
        	System.out.println("��¼ʧ��");
            return null;
        }
		
	}

	/**
     * 	�޸���Ϣ	����ͨ��
     * @param 
     * @return 
     */
	@Override
	public void update(Company company) {
		// TODO Auto-generated method stub
		
		System.out.println("��ʼ�޸���Ϣ");
		//�洢���û�
    	
		//update company set name= ?,location= ?,phone= ?,email= ?,trade= ?,salary= ?,tip= ? where id=?

		String InsertSql="update company set name= ?,location= ?,phone= ?,email= ?,trade= ?,salary= ?,tip= ? where id=?";
		
		
    	template.update(InsertSql,company.getName(),company.getLocation(),company.getPhone(),company.getEmail(),
    											company.getTrade(),company.getSalary(),company.getTip(),company.getId());

	}

	
	 /**
     * ������Ƹ��Ϣ 	����ͨ��
     * @param company
     * @return 
     */
	@Override
	public void publish(Company company) {
		// TODO Auto-generated method stub
		System.out.println("������Ƹ��Ϣ��������");
		//�洢���û�
    	//update person set pubtime=#{pubtime,jdbcType=TIMESTAMP}		where id=#{id}
		
//    	//��ȡϵͳʱ�䡪��ע��ʱ��
    	SimpleDateFormat sdf_Time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String publishTime=sdf_Time.format(new Date());

    	//update company set pubtime=#{pubtime,jdbcType=TIMESTAMP} where USERNAME=?
		String InsertSql="UPDATE company SET PUBTIME=STR_TO_DATE( ?, '%Y-%m-%d %H:%i:%s')  WHERE USERNAME=?";
	
		
    	template.update(InsertSql,publishTime,company.getUsername());
		
	}

	
	/**
     * ������Ƹ��Ϣ 	����ͨ��
     * @param company
     * @return 
     */
	@Override
	public void deleteInfo(Company company) {
		// TODO Auto-generated method stub
		
		System.out.println("������Ƹ��Ϣ��������");
		
		//update company set pubtime=null		where id=#{id}

		String InsertSql="UPDATE company SET PUBTIME=STR_TO_DATE( ?, '%Y-%m-%d %H:%i:%s')  WHERE USERNAME=?";
		
    	template.update(InsertSql,null,company.getUsername());
	}

	
	/**
     * ��ѯ��Ϣ	����ͨ��
     * @param company
     * @return 
     */
	@Override
	public Company query(long id) {
		
		try {
            //1.��дsql
            String sql = "select * from company where id = ?";
            //2.����query����
            
            Company company = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Company>(Company.class),id);

            System.out.println("��ѯ�ɹ�");
            return company;
            
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//��¼��־
        	System.out.println("��ѯʧ��");
            return null;
        }
		
	}
	
	
}
