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

	//声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	
    
    @Override
	/* 显示所有公司的招聘信息	测试通过
	 * 返回List集合
	 */
	public List<Company> listAllCompanies() {
		// TODO Auto-generated method stub
		
		try {
            //1.编写sql
            String sql = "select * from company where pubtime is not null order by pubtime desc";
            //2.调用list方法
           
            List<Company> companies = template.query(sql,  
                    new BeanPropertyRowMapper<Company>(Company.class));  
           
            
    		return companies;
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//记录日志
            return null;
        }
		
	}

    @Override
	/* 带参数显示所有公司的招聘信息
	 * 返回List集合
	 */
	public List<Company> listAllCompaniesByParams(Map<String, String> map) {
	
		try {
			 //1.编写sql
	        String sql = "select * from company where pubtime is not null ";
	        
	        for(Map.Entry<String, String> entry : map.entrySet()){
	            String mapKey = entry.getKey();
	            String mapValue = entry.getValue();
	            System.out.println(mapKey+":"+mapValue);
	            
	            if("trade".equals(mapKey))		sql+=" and trade="+"\""+mapValue+"\"";
	            
	            if("salary".equals(mapKey))		sql+=" and salary="+"\""+mapValue+"\"";
	            
	            if("pubtime".equals(mapKey))		sql+=" and STR_TO_DATE( "+mapValue+", '%Y-%m-%d %H:%i:%s') ";
	        }
	        
	        System.out.println(sql);
	        
	        System.out.println("\"\"");       //利用转义字符
	        
            //2.调用list方法
           
            List<Company> companies = template.query(sql,  
                    new BeanPropertyRowMapper<Company>(Company.class));  
          
          System.out.println("查看返回的结果");
          
            
    		for (Company company : companies) {
    			System.out.println(company);
    		}
            
    		return companies;
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//记录日志
            return null;
        }
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
