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

	//声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	
    
    
	/* 显示所有公司的招聘信息	测试通过
	 * 返回List集合
	 */
    @Override
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

    
	/* 带参数显示所有公司的招聘信息	测试通过
	 * 返回List集合
	 */
    @Override
	public List<Company> listAllCompaniesByParams(Map<String, String> map) {
	
		try {
			 //1.编写sql
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
	        
	        System.out.println("\"\"");       //利用转义字符
	        
            //2.调用list方法
           
            List<Company> companies = template.query(sql,  
                    new BeanPropertyRowMapper<Company>(Company.class));  
          
          System.out.println("查看返回的结果");
          
            
//    		for (Company company : companies) {
//    			System.out.println(company);
//    		}
            
    		return companies;
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//记录日志
            return null;
        }
	}

    /**
     * 注册方法	测试通过
     * @param company
     * @return 
     */
	@Override
	public boolean register(Company company) {
		// TODO Auto-generated method stub
		Company c=null;
		try {
			//1.编写sql
			String sql = "select * from company where username= ?";
			//2.调用query方法
			c = template.queryForObject(sql,
			        new BeanPropertyRowMapper<Company>(Company.class),
			        company.getUsername());
		} catch (DataAccessException e) {
			c =null;
		}
		
		if(c==null){
        	System.out.println("开始存储对象");
			//存储该用户

////        	//获取系统时间——注册时间
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
     * 登录方法	测试通过
     * @param login 只有用户名和密码
     * @return Company包含用户全部数据,没有查询到，返回null
     */
	@Override
	public Company login(String username, String password) {
		// TODO Auto-generated method stub

		try {
            //1.编写sql
            String sql = "select * from company where username = ? and password = ?";
            //2.调用query方法
            
            Company company = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Company>(Company.class),
                    username, password);

            System.out.println("登录成功");
            return company;
            
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//记录日志
        	System.out.println("登录失败");
            return null;
        }
		
	}

	/**
     * 	修改信息	测试通过
     * @param 
     * @return 
     */
	@Override
	public void update(Company company) {
		// TODO Auto-generated method stub
		
		System.out.println("开始修改信息");
		//存储该用户
    	
		//update company set name= ?,location= ?,phone= ?,email= ?,trade= ?,salary= ?,tip= ? where id=?

		String InsertSql="update company set name= ?,location= ?,phone= ?,email= ?,trade= ?,salary= ?,tip= ? where id=?";
		
		
    	template.update(InsertSql,company.getName(),company.getLocation(),company.getPhone(),company.getEmail(),
    											company.getTrade(),company.getSalary(),company.getTip(),company.getId());

	}

	
	 /**
     * 发布招聘信息 	测试通过
     * @param company
     * @return 
     */
	@Override
	public void publish(Company company) {
		// TODO Auto-generated method stub
		System.out.println("发布招聘信息方法调用");
		//存储该用户
    	//update person set pubtime=#{pubtime,jdbcType=TIMESTAMP}		where id=#{id}
		
//    	//获取系统时间——注册时间
    	SimpleDateFormat sdf_Time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String publishTime=sdf_Time.format(new Date());

    	//update company set pubtime=#{pubtime,jdbcType=TIMESTAMP} where USERNAME=?
		String InsertSql="UPDATE company SET PUBTIME=STR_TO_DATE( ?, '%Y-%m-%d %H:%i:%s')  WHERE USERNAME=?";
	
		
    	template.update(InsertSql,publishTime,company.getUsername());
		
	}

	
	/**
     * 撤销招聘信息 	测试通过
     * @param company
     * @return 
     */
	@Override
	public void deleteInfo(Company company) {
		// TODO Auto-generated method stub
		
		System.out.println("撤销招聘信息方法调用");
		
		//update company set pubtime=null		where id=#{id}

		String InsertSql="UPDATE company SET PUBTIME=STR_TO_DATE( ?, '%Y-%m-%d %H:%i:%s')  WHERE USERNAME=?";
		
    	template.update(InsertSql,null,company.getUsername());
	}

	
	/**
     * 查询信息	测试通过
     * @param company
     * @return 
     */
	@Override
	public Company query(long id) {
		
		try {
            //1.编写sql
            String sql = "select * from company where id = ?";
            //2.调用query方法
            
            Company company = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Company>(Company.class),id);

            System.out.println("查询成功");
            return company;
            
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//记录日志
        	System.out.println("查询失败");
            return null;
        }
		
	}
	
	
}
