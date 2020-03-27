package service.imp;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

import cn.itcast.dao.ICompanyDao;
import cn.itcast.domain.Company;
import cn.itcast.domain.Person;
import cn.itcast.util.JDBCUtils;
import service.ICompanyService;
import tools.MyBatisSqlSessionFactory;

public class ICompanyServiceImp implements ICompanyService{

	//����JDBCTemplate������
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	
    
    @Override
	/* ��ʾ���й�˾����Ƹ��Ϣ	����ͨ��
	 * ����List����
	 */
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

	@Override
	public List<Company> listAllCompaniesByParams(Map<String, String> map) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.getSqlSessionFactory();
		ICompanyDao companyDao = session.getMapper(ICompanyDao.class);
		List<Company> companies = companyDao.findCompaniesByParams(map);
		return companies;	
	}

	@Override
	public boolean register(Company company) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.getSqlSessionFactory();
		ICompanyDao companyDao = session.getMapper(ICompanyDao.class);
		Company c = companyDao.findCompanyByName(company.getUsername());
		if(c==null){
			companyDao.saveCompany(company);
			session.commit();
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Company login(String username, String password) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.getSqlSessionFactory();
		ICompanyDao companyDao = session.getMapper(ICompanyDao.class);
		Company c = companyDao.findCompanyByNameAndPassword(username, password);		
		if(c!=null){
			return c;
		}else{
			return null;
		}
	}

	@Override
	public void update(Company company) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.getSqlSessionFactory();
		ICompanyDao companyDao = session.getMapper(ICompanyDao.class);
		companyDao.updateCompany(company);
		session.commit();
	}

	@Override
	public void publish(Company company) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.getSqlSessionFactory();
		ICompanyDao companyDao = session.getMapper(ICompanyDao.class);
		companyDao.udpatePubtime(company);
		session.commit();
	}

	@Override
	public void deleteInfo(Company company) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.getSqlSessionFactory();
		ICompanyDao companyDao = session.getMapper(ICompanyDao.class);
		companyDao.ZeroPubtime(company);
		session.commit();
	}

	@Override
	public Company query(long id) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.getSqlSessionFactory();
		ICompanyDao companyDao = session.getMapper(ICompanyDao.class);
		Company company = companyDao.findCompanyById(id);
		return company;
	}
	
}
