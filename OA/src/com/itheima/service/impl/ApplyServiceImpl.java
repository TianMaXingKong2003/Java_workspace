package com.itheima.service.impl;

import java.util.List;

import com.itheima.commons.Page;
import com.itheima.dao.ApplyDao;
import com.itheima.dao.impl.ApplyDaoImpl;
import com.itheima.domain.Apply;
import com.itheima.domain.Customer;
import com.itheima.service.ApplyService;

public class ApplyServiceImpl implements ApplyService {
	private ApplyDao applyDao = new ApplyDaoImpl();
	public void genApply(Apply apply) {
		if(apply==null){
			throw new RuntimeException("申请不能为空");
		}
		if(apply.getClasses()==null){
			throw new RuntimeException("申请必须指定班级");
		}
		if(apply.getCustomer()==null){
			throw new RuntimeException("申请必须指定申请人");
		}
		applyDao.save(apply);
	}
	public int checkApplyCount(Customer customer) {
		List<Apply> applys = applyDao.findByCustomer(customer.getId());
		return applys.size();
	}
	public boolean checkIsClosed(Customer customer) {
		List<Apply> applys = applyDao.findByCustomer(customer.getId());
		boolean hasUnClosedApply = false;
		for(Apply a:applys){
			if(a.getClosed()==null||!a.getClosed()){
				hasUnClosedApply = true;
				break;
			}
		}
		return hasUnClosedApply;
	}
	public Page findAllNotClosedApplys(String num) {
		int pageNum = 1;
		if(num!=null){
			pageNum = Integer.parseInt(num);
		}
		int totalRecordsNumber = applyDao.findNotClosedApplyNumber();
		Page page = new Page(pageNum, totalRecordsNumber);
		List<Apply> records = applyDao.findNotClosedApply(page.getStartIndex(),page.getPageSize());
		page.setRecords(records);
		return page;
	}
	public Apply findApplyByNumber(String number) {
		return applyDao.findByNumber(number);
	}
	public void update(Apply apply) {
		applyDao.update(apply);
	}

}
