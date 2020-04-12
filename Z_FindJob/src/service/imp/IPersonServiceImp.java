package service.imp;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.itcast.dao.IPersonDao;
import cn.itcast.domain.Person;
import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import service.IPersonService;
import tools.MyBatisSqlSessionFactory;

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
        	SimpleDateFormat sdf_Time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	String registerTime=sdf_Time.format(new Date());
    		
        	String InsertSql="INSERT INTO person VALUES ( id, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, STR_TO_DATE( ?, '%Y-%m-%d %H:%i:%s'), ?)";
        	template.update(InsertSql,person.getUsername(),person.getPassword(),person.getName(),
        											person.getSex(),person.getBirthday(),person.getSchool(),
        											person.getPhone(),person.getEmail(),person.getTrade(),
        											person.getSalary(),person.getTip(),registerTime,person.getEducation());
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
		
    	System.out.println("开始存储对象");
		//存储该用户
    	

		String InsertSql="UPDATE person SET NAME=? ,SEX=? ,BIRTHDAY=? ,SCHOOL=? ,PHONE=? ,EMAIL=? ,TRADE=? ,"+
		"SALARY=? ,TIP=? ,EDUCATION=?  WHERE USERNAME=?";
		
		
    	template.update(InsertSql,person.getName(),person.getSex(),person.getBirthday(),
    			person.getSchool(),person.getPhone(),person.getEmail(),person.getTrade(),person.getSalary(),
    			person.getTip(),person.getEducation(),person.getUsername());

	}

	@Override
	public void publish(Person person) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.getSqlSessionFactory();
		IPersonDao personDao = session.getMapper(IPersonDao.class);
		personDao.udpatePubtime(person);
		session.commit();
	}

	@Override
	public void deleteResume(Person person) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.getSqlSessionFactory();
		IPersonDao personDao = session.getMapper(IPersonDao.class);
		personDao.ZeroPubtime(person);
		session.commit();
	}

	@Override
	public List<Person> listAllPersons() {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.getSqlSessionFactory();
		IPersonDao personDao = session.getMapper(IPersonDao.class);
		List<Person> persons = personDao.findAllPersons();
		return persons;
	}

	@Override
	public List<Person> listAllPersonsByParams(Map<String, String> map) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.getSqlSessionFactory();
		IPersonDao personDao = session.getMapper(IPersonDao.class);
		List<Person> persons = personDao.findPersonsByParams(map);
		return persons;
	}

	@Override
	public Person query(long id) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.getSqlSessionFactory();
		IPersonDao personDao = session.getMapper(IPersonDao.class);
		Person person = personDao.findPersonById(id);
		return person;
	}

	public void deleteInfo(Person person) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.getSqlSessionFactory();
		IPersonDao personDao = session.getMapper(IPersonDao.class);
		personDao.ZeroPubtime(person);
		session.commit();
	}

	

}
