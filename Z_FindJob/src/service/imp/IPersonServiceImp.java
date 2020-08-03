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
	
	 //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

	
	/**
     * 注册方法	测试通过
     * @param person
     * @return 
     */
    @Override
	public boolean register(Person person) {
		
		Person p=null;
		try {
			//1.编写sql
			String sql = "select * from person where username= ?";
			//2.调用query方法
			p = template.queryForObject(sql,
			        new BeanPropertyRowMapper<Person>(Person.class),
			        person.getUsername());
		} catch (DataAccessException e) {
			p =null;
		}
		
		if(p==null){
        	System.out.println("开始存储对象");
			//存储该用户

//        	//获取系统时间——注册时间
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
     * 登录方法	测试通过
     * @param login 只有用户名和密码
     * @return Person包含用户全部数据,没有查询到，返回null
     */
    @Override
	public Person login(String username, String password) {
		
		try {
            //1.编写sql
            String sql = "select * from person where username = ? and password = ?";
            //2.调用query方法
            
            Person person = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Person>(Person.class),
                    username, password);

            System.out.println("登录成功");
            return person;
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//记录日志
        	System.out.println("登录失败");
            return null;
        }
	}

    
    /**
     * 修改信息	测试通过	
     * @param person
     * @return 
     */
	@Override
	public void update(Person person) {
		
    	System.out.println("开始修改信息");
		//存储该用户
    	
    	
    	System.out.println(person.getSex());

		String InsertSql="UPDATE person SET NAME=? ,SEX=? ,BIRTHDAY=? ,SCHOOL=? ,PHONE=? ,EMAIL=? ,TRADE=? ,"+
		"SALARY=? ,TIP=? ,EDUCATION=?  WHERE USERNAME=?";
		
		
    	template.update(InsertSql,person.getName(),person.getSex(),person.getBirthday(),
    			person.getSchool(),person.getPhone(),person.getEmail(),person.getTrade(),person.getSalary(),
    			person.getTip(),person.getEducation(),person.getUsername());

	}

	 /**
     * 发布简历	测试通过
     * @param person
     * @return 
     */
	@Override
	public void publish(Person person) {
		// TODO Auto-generated method stub

		System.out.println("发布简历方法调用");
		//存储该用户
    	//update person set pubtime=#{pubtime,jdbcType=TIMESTAMP}		where id=#{id}
		
//    	//获取系统时间——注册时间
    	SimpleDateFormat sdf_Time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String publishTime=sdf_Time.format(new Date());

		String InsertSql="UPDATE person SET PUBTIME=STR_TO_DATE( ?, '%Y-%m-%d %H:%i:%s')  WHERE USERNAME=?";
		
		
    	template.update(InsertSql,publishTime,person.getUsername());
		
	}

	/**
     * 撤销简历	测试通过
     * @param person
     * @return 
     */
	@Override
	public void deleteResume(Person person) {
		// TODO Auto-generated method stub

		System.out.println("撤销简历方法调用");

		String InsertSql="UPDATE person SET PUBTIME=STR_TO_DATE( ?, '%Y-%m-%d %H:%i:%s')  WHERE USERNAME=?";
		
    	template.update(InsertSql,null,person.getUsername());
		
	}

	
	/* 显示所有招聘者的简历信息	测试通过
	 * 返回List集合
	 */
	@Override
	public List<Person> listAllPersons() {
		// TODO Auto-generated method stub
		
		try {
            //1.编写sql
            String sql = "select * from person where pubtime is not null order by pubtime desc";
            //2.调用list方法
           
            List<Person> persons = template.query(sql,  
                    new BeanPropertyRowMapper<Person>(Person.class));  

    		return persons;
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//记录日志
            return null;
        }
	}

	
	/* 带参数显示所有招聘者的简历信息	测试通过
	 * 返回List集合
	 */
	@Override
	public List<Person> listAllPersonsByParams(Map<String, String> map) {
		// TODO Auto-generated method stub
		
		try {
			 //1.编写sql
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
//	        System.out.println("\"\"");       //利用转义字符
	        
           //2.调用list方法
          
           List<Person> persons = template.query(sql,  
                   new BeanPropertyRowMapper<Person>(Person.class));  
         
         //System.out.println("查看返回的结果");
         
   		return persons;
           
       } catch (DataAccessException e) {
           //e.printStackTrace();//记录日志
           return null;
       }
	}

	/**
     * 通过id查找求职者	测试通过
     * @param person
     * @return 
     */
	@Override
	public Person query(long id) {
		// TODO Auto-generated method stub
		try {
            //1.编写sql
            String sql = "select * from person where id = ?";
            //2.调用query方法
            
            Person person = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Person>(Person.class),id);

            System.out.println("查询成功");
            return person;
            
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//记录日志
        	System.out.println("查询失败");
            return null;
        }
		
	}

	
	/**
     * 通过id删除求职者发布信息		测试通过
     * @param person
     * @return 
     */
	public void deleteInfo(Person person) {
		// TODO Auto-generated method stub
		
		//update person set pubtime=null	where id=#{id}
		
		System.out.println("通过id删除求职者发布信息");

		String InsertSql="update person set pubtime=null	 where id=?";
		
    	template.update(InsertSql,person.getId());
		
	}

	

}
