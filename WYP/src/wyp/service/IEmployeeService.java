package wyp.service;

import java.util.List;

import wyp.bean.Company;
import wyp.bean.Employee;
import wyp.bean.Person;

public interface IEmployeeService {
	public void insert(long p_id,long c_id);
	public Employee query(long p_id,long c_id);
	public List<Person> candidateQuery(long c_id);
	public List<Company> companyQuery(long p_id);
	public void update(long isAgreed,long id);
}
