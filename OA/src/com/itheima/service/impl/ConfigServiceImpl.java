package com.itheima.service.impl;

import java.util.List;

import com.itheima.commons.Page;
import com.itheima.dao.ClassTypeDao;
import com.itheima.dao.ClassesDao;
import com.itheima.dao.CustomerStatusDao;
import com.itheima.dao.InfoSourceDao;
import com.itheima.dao.impl.ClassTypeDaoImpl;
import com.itheima.dao.impl.ClassesDaoImpl;
import com.itheima.dao.impl.CustomerStatusDaoImpl;
import com.itheima.dao.impl.InfoSourceDaoImpl;
import com.itheima.domain.ClassType;
import com.itheima.domain.Classes;
import com.itheima.domain.CustomerStatus;
import com.itheima.domain.InfoSource;
import com.itheima.service.ConfigService;

public class ConfigServiceImpl implements ConfigService {
	private InfoSourceDao infoSourceDao = new InfoSourceDaoImpl();
	private ClassTypeDao classTypeDao = new ClassTypeDaoImpl();
	private CustomerStatusDao customerStatusDao = new CustomerStatusDaoImpl();
	private ClassesDao classesDao = new ClassesDaoImpl();
	public List<InfoSource> findAllInfoSources() {
		return infoSourceDao.findAll();
	}
	public void addInfoSource(InfoSource infoSource) {
		infoSourceDao.save(infoSource);
	}
	public InfoSource findInfoSourceById(String infoSourceId) {
		return infoSourceDao.findOne(infoSourceId);
	}
	public void editInfoSource(InfoSource infoSource) {
		if(infoSource==null)
			throw new IllegalArgumentException("The param can not be null");
		if(infoSource.getId()==null)
			throw new IllegalArgumentException("The infoSource's id can not be null");
		infoSourceDao.update(infoSource);
	}
	public void delInfoSource(String infoSourceId) {
		infoSourceDao.delete(infoSourceId);
	}
	public void delMultiInfoSource(String[] infoSourceIds) {
		infoSourceDao.delete(infoSourceIds);
	}
	public List<ClassType> findAllClassTypes() {
		return classTypeDao.findAll();
	}
	public ClassType findClassTypeById(String classTypeId) {
		return classTypeDao.findOne(classTypeId);
	}
	public void addClassType(ClassType classType) {
		classTypeDao.save(classType);
	}
	public List<CustomerStatus> findAllCustomerStatus() {
		return customerStatusDao.findAll();
	}
	public CustomerStatus findCustomerStatusById(String customerStatusId) {
		return customerStatusDao.findOne(customerStatusId);
	}
	public void addCustomerStatus(CustomerStatus customerStatus) {
		customerStatusDao.save(customerStatus);
	}
	public Page findClasses(String num) {
		int pageNum = 1;
		if(num!=null&&!"".equals(num)){
			pageNum = Integer.parseInt(num);
		}
		int totalRecordsNumber = classesDao.getTotalRecordsNumber();
		Page page = new Page(pageNum, totalRecordsNumber);
		//查询记录
		List<Classes> records = classesDao.findPageRecords(page.getStartIndex(), page.getPageSize());
		page.setRecords(records);
		return page;
	}
	public Page findClasses(String num, String classTypeId) {
		int pageNum = 1;
		if(num!=null&&!"".equals(num)){
			pageNum = Integer.parseInt(num);
		}
		int totalRecordsNumber = classesDao.getTotalRecordsNumber(classTypeId);
		Page page = new Page(pageNum, totalRecordsNumber);
		//查询记录
		List<Classes> records = classesDao.findPageRecords(page.getStartIndex(), page.getPageSize(),classTypeId);
		page.setRecords(records);
		return page;
	}
	public void addClasses(Classes classes) {
		if(classes==null)
			throw new IllegalArgumentException("大哥你要保存啥");
		if(classes.getClassType()==null)
			throw new IllegalArgumentException("班级必须指定课程类型");
		classesDao.save(classes);
	}
	public List<Classes> findClassesByClassTypeName(String classTypeName) {
		return classesDao.findClassesByClassTypeName(classTypeName);
	}
	public Classes findClassesById(String classesId) {
		return classesDao.findById(classesId);
	}

}
