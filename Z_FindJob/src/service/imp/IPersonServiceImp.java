package service.imp;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import cn.itcast.domain.Person;
import cn.itcast.util.JDBCUtils;
import service.IPersonService;


public class IPersonServiceImp implements IPersonService {
	
	 //����JDBCTemplate������
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

	
	/**
     * ע�᷽��	����ͨ��
     * @param person
     * @return 
     */
    @Override
	public boolean register(Person person) {
		
		Person p=null;
		try {
			//1.��дsql
			String sql = "select * from person where username= ?";
			//2.����query����
			p = template.queryForObject(sql,
			        new BeanPropertyRowMapper<Person>(Person.class),
			        person.getUsername());
		} catch (DataAccessException e) {
			p =null;
		}
		
		if(p==null){
        	System.out.println("��ʼ�洢����");
			//�洢���û�

//        	//��ȡϵͳʱ�䡪��ע��ʱ��
//        	SimpleDateFormat sdf_Time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        	String registerTime=sdf_Time.format(new Date());
    		
        	String InsertSql="INSERT INTO person VALUES ( id, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        	template.update(InsertSql,person.getUsername(),person.getPassword(),person.getName(),
        											person.getSex(),person.getBirthday(),person.getSchool(),
        											person.getPhone(),person.getEmail(),person.getTrade(),
        											person.getSalary(),person.getTip(),null,person.getEducation());
			return true;
		}else{
			return false;
		}
    
	}

		
	/**
     * ��¼����	����ͨ��
     * @param login ֻ���û���������
     * @return Person�����û�ȫ������,û�в�ѯ��������null
     */
    @Override
	public Person login(String username, String password) {
		
		try {
            //1.��дsql
            String sql = "select * from person where username = ? and password = ?";
            //2.����query����
            
            Person person = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Person>(Person.class),
                    username, password);

            System.out.println("��¼�ɹ�");
            return person;
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//��¼��־
        	System.out.println("��¼ʧ��");
            return null;
        }
	}

    
    /**
     * �޸���Ϣ	����ͨ��	
     * @param person
     * @return 
     */
	@Override
	public void update(Person person) {
		
    	System.out.println("��ʼ�޸���Ϣ");
		//�洢���û�
    	
    	
    	System.out.println(person.getSex());

		String InsertSql="UPDATE person SET NAME=? ,SEX=? ,BIRTHDAY=? ,SCHOOL=? ,PHONE=? ,EMAIL=? ,TRADE=? ,"+
		"SALARY=? ,TIP=? ,EDUCATION=?  WHERE USERNAME=?";
		
		
    	template.update(InsertSql,person.getName(),person.getSex(),person.getBirthday(),
    			person.getSchool(),person.getPhone(),person.getEmail(),person.getTrade(),person.getSalary(),
    			person.getTip(),person.getEducation(),person.getUsername());

	}

	 /**
     * ��������	����ͨ��
     * @param person
     * @return 
     */
	@Override
	public void publish(Person person) {
		// TODO Auto-generated method stub

		System.out.println("����������������");
		//�洢���û�
    	//update person set pubtime=#{pubtime,jdbcType=TIMESTAMP}		where id=#{id}
		
//    	//��ȡϵͳʱ�䡪��ע��ʱ��
    	SimpleDateFormat sdf_Time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String publishTime=sdf_Time.format(new Date());

		String InsertSql="UPDATE person SET PUBTIME=STR_TO_DATE( ?, '%Y-%m-%d %H:%i:%s')  WHERE USERNAME=?";
		
		
    	template.update(InsertSql,publishTime,person.getUsername());
		
	}

	/**
     * ��������	����ͨ��
     * @param person
     * @return 
     */
	@Override
	public void deleteResume(Person person) {
		// TODO Auto-generated method stub

		System.out.println("����������������");

		String InsertSql="UPDATE person SET PUBTIME=STR_TO_DATE( ?, '%Y-%m-%d %H:%i:%s')  WHERE USERNAME=?";
		
    	template.update(InsertSql,null,person.getUsername());
		
	}

	
	/* ��ʾ������Ƹ�ߵļ�����Ϣ	����ͨ��
	 * ����List����
	 */
	@Override
	public List<Person> listAllPersons() {
		// TODO Auto-generated method stub
		
		try {
            //1.��дsql
            String sql = "select * from person where pubtime is not null order by pubtime desc";
            //2.����list����
           
            List<Person> persons = template.query(sql,  
                    new BeanPropertyRowMapper<Person>(Person.class));  

    		return persons;
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//��¼��־
            return null;
        }
	}

	
	/* ��������ʾ������Ƹ�ߵļ�����Ϣ	����ͨ��
	 * ����List����
	 */
	@Override
	public List<Person> listAllPersonsByParams(Map<String, String> map) {
		// TODO Auto-generated method stub
		
		try {
			 //1.��дsql
	        String sql = "select * from person where pubtime is not null ";
	        
	        for(Map.Entry<String, String> entry : map.entrySet()){
	            String mapKey = entry.getKey();
	            String mapValue = entry.getValue();
	            //System.out.println(mapKey+":"+mapValue);
	            
	            if("trade".equals(mapKey))		sql+=" and trade="+"\""+mapValue+"\"";
	            
	            if("school".equals(mapKey))	sql+=" and school="+"\""+mapValue+"\"";
	            
	            if("salary".equals(mapKey))		sql+=" and salary="+"\""+mapValue+"\"";
	            
	            if("pubtime".equals(mapKey))		sql+=" and STR_TO_DATE( "+mapValue+", '%Y-%m-%d %H:%i:%s') ";
	        }
	        
//	        System.out.println(sql);
//	        
//	        System.out.println("\"\"");       //����ת���ַ�
	        
           //2.����list����
          
           List<Person> persons = template.query(sql,  
                   new BeanPropertyRowMapper<Person>(Person.class));  
         
         //System.out.println("�鿴���صĽ��");
         
   		return persons;
           
       } catch (DataAccessException e) {
           //e.printStackTrace();//��¼��־
           return null;
       }
	}

	/**
     * ͨ��id������ְ��	����ͨ��
     * @param person
     * @return 
     */
	@Override
	public Person query(long id) {
		// TODO Auto-generated method stub
		try {
            //1.��дsql
            String sql = "select * from person where id = ?";
            //2.����query����
            
            Person person = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Person>(Person.class),id);

            System.out.println("��ѯ�ɹ�");
            return person;
            
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//��¼��־
        	System.out.println("��ѯʧ��");
            return null;
        }
		
	}

	
	/**
     * ͨ��idɾ����ְ�߷�����Ϣ		����ͨ��
     * @param person
     * @return 
     */
	public void deleteInfo(Person person) {
		// TODO Auto-generated method stub
		
		//update person set pubtime=null	where id=#{id}
		
		System.out.println("ͨ��idɾ����ְ�߷�����Ϣ");

		String InsertSql="update person set pubtime=null	 where id=?";
		
    	template.update(InsertSql,person.getId());
		
	}

	

}
