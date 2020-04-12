package cn.itcast.test;

import java.util.List;

import cn.itcast.domain.Company;
import service.imp.ICompanyServiceImp;

public class ICompanyServiceImpTest {

	//测试显示所有公司的招聘信息	成功
	private static void listAllCompaniesTest() {
		// TODO 自动生成的方法存根
		
		List<Company> companies = new ICompanyServiceImp().listAllCompanies();
		
		for (Company company : companies) {
			System.out.println(company);
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		listAllCompaniesTest();
	}

	

}
