package service.imp;


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

	@Override
	public boolean register(Person person) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.getSqlSessionFactory();
		IPersonDao personDao = session.getMapper(IPersonDao.class);
		Person p = personDao.findPersonByName(person.getUsername());
		if(p==null){
			personDao.savePerson(person);
			session.commit();
			return true;
		}else{
			return false;
		}
	}

	@Override	
	/**
     * 登录方法	测试通过
     * @param login 只有用户名和密码
     * @return Person包含用户全部数据,没有查询到，返回null
     */
	public Person login(String username, String password) {
		
		try {
            //1.编写sql
            String sql = "select * from person where username = ? and password = ?";
            //2.调用query方法
            
            Person person = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Person>(Person.class),
                    username, password);

            return person;
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//记录日志
            return null;
        }
	}

	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.getSqlSessionFactory();
		IPersonDao personDao = session.getMapper(IPersonDao.class);
		personDao.updatePerson(person);
		session.commit();
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
