package cn.itcast.test;

import java.util.List;

import cn.itcast.domain.Company;
import service.imp.ICompanyServiceImp;

public class ICompanyServiceImpTest {

	//������ʾ���й�˾����Ƹ��Ϣ	�ɹ�
	private static void listAllCompaniesTest() {
		// TODO �Զ����ɵķ������
		
		List<Company> companies = new ICompanyServiceImp().listAllCompanies();
		
		for (Company company : companies) {
			System.out.println(company);
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		listAllCompaniesTest();
	}

	

}
