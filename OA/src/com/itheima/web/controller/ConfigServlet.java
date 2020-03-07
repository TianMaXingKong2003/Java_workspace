package com.itheima.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.commons.Page;
import com.itheima.domain.ClassType;
import com.itheima.domain.Classes;
import com.itheima.domain.CustomerStatus;
import com.itheima.domain.InfoSource;
import com.itheima.service.ConfigService;
import com.itheima.service.impl.ConfigServiceImpl;
import com.itheima.util.WebUtil;
//系统配置控制器
public class ConfigServlet extends HttpServlet {
	private ConfigService configService = new ConfigServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		if("listAllInfoSources".equals(op)){
			listAllInfoSources(request,response);
		}else if("addInfoSource".equals(op)){
			addInfoSource(request,response);
		}else if("editInfoSourceUI".equals(op)){
			editInfoSourceUI(request,response);
		}else if("editInfoSource".equals(op)){
			editInfoSource(request,response);
		}else if("delInfoSource".equals(op)){
			delInfoSource(request,response);
		}else if("delMultiInfoSource".equals(op)){
			delMultiInfoSource(request,response);
		}else if("listAllCustomerStatus".equals(op)){
			listAllCustomerStatus(request,response);
		}else if("listAllClassTypes".equals(op)){
			listAllClassTypes(request,response);
		}else if("addCustomerStatus".equals(op)){
			addCustomerStatus(request,response);
		}else if("addClassType".equals(op)){
			addClassType(request,response);
		}else if("listClasses".equals(op)){
			listClasses(request,response);
		}else if("addClassesUI".equals(op)){
			addClassesUI(request,response);
		}else if("addClasses".equals(op)){
			addClasses(request,response);
		}
	}
	//添加开班信息
	private void addClasses(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//封装信息
		Classes classes = WebUtil.fillBean(request, Classes.class);
		//获取课程类型对象
		String classTypeId = request.getParameter("classTypeId");
		ClassType classType = configService.findClassTypeById(classTypeId);
		
		String count = request.getParameter("count");
		classes.setName(classType.getName()+"_"+count+"期");
		
		classes.setStatus("火热报名中");
		
		//建立班级和课程类型的关联关系
		classes.setClassType(classType);
		
		configService.addClasses(classes);
//		保存成功进行提示
		request.setAttribute("message", "保存开班信息成功！");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
		
	}
	//显示添加开班信息页面
	private void addClassesUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//查询所有的课程类型
		List<ClassType> classTypes = configService.findAllClassTypes();
		request.setAttribute("classTypes", classTypes);
		request.getRequestDispatcher("/manage/addClasses.jsp").forward(request, response);
	}
	//查询所有班级的分页信息
	private void listClasses(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String classTypeId = request.getParameter("classTypeId");
		
		request.setAttribute("classTypeId", classTypeId);
		
		//查询所有的课程类型
		List<ClassType> classTypes = configService.findAllClassTypes();
		request.setAttribute("classTypes", classTypes);
		//获取用户要看的页码
		String num = request.getParameter("num");
		Page page = null;
		if(classTypeId==null||"".equals(classTypeId)){
			page = configService.findClasses(num);
			//设置uri
			page.setUri("/manage/ConfigServlet?op=listClasses");
		}else{
			//按照classType进行查询
			page = configService.findClasses(num,classTypeId);
			//设置uri
			page.setUri("/manage/ConfigServlet?op=listClasses&classTypeId="+classTypeId);
		}
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("/manage/listClasses.jsp").forward(request, response);
		
	}
	private void addClassType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ClassType classType = WebUtil.fillBean(request, ClassType.class);
		configService.addClassType(classType);
		request.setAttribute("message", "保存课程类型成功！");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}
	private void addCustomerStatus(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CustomerStatus customerStatus = WebUtil.fillBean(request, CustomerStatus.class);
		configService.addCustomerStatus(customerStatus);
		request.setAttribute("message", "保存客户状态成功！");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}
	//显示所有课程类型
	private void listAllClassTypes(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<ClassType> classTypes = configService.findAllClassTypes();
		request.setAttribute("classTypes", classTypes);
		request.getRequestDispatcher("/manage/listClassType.jsp").forward(request, response);
	}
	//显示所有客户状态
	private void listAllCustomerStatus(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<CustomerStatus> customerStatus = configService.findAllCustomerStatus();
		request.setAttribute("customerStatus", customerStatus);
		request.getRequestDispatcher("/manage/listCustomerStatus.jsp").forward(request, response);
	}
	//批量删除
	private void delMultiInfoSource(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String ids[] = request.getParameterValues("infoSourceIds");
		if(ids!=null&&ids.length>0){
			configService.delMultiInfoSource(ids);
		}
		//重定向到查询所有来源信息的地址
		response.sendRedirect(request.getContextPath()+"/manage/ConfigServlet?op=listAllInfoSources");
	}
	//删除信息来源
	private void delInfoSource(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		获取id，
		String id = request.getParameter("id");
		//调用Service删除
		configService.delInfoSource(id);
		//重定向到查询所有来源信息的地址
		response.sendRedirect(request.getContextPath()+"/manage/ConfigServlet?op=listAllInfoSources");
	}
	//保存修改的信息
	private void editInfoSource(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		InfoSource infoSource = WebUtil.fillBean(request, InfoSource.class);
//		调用业务代码进行保存；
		configService.editInfoSource(infoSource);
//		保存成功进行提示
		request.setAttribute("message", "修改信息来源成功！");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}
	//显示修改页面：获取id，根据id查询记录；封装信息到请求范围；转发到页面进行显示
	private void editInfoSourceUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		获取id，
		String id = request.getParameter("id");
//		根据id查询记录；
		InfoSource infoSource = configService.findInfoSourceById(id);
//		封装信息到请求范围；
		request.setAttribute("infoSource",infoSource);
//		转发到页面进行显示
		request.getRequestDispatcher("/manage/editInfoSource.jsp").forward(request, response);
	}
	//添加信息来源：封装数据到JavaBean中；调用业务代码进行保存；保存成功进行提示
	private void addInfoSource(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		//封装数据到JavaBean中
		//中文编码问题:用过滤器解决
		InfoSource infoSource = WebUtil.fillBean(request, InfoSource.class);
//		调用业务代码进行保存；
		configService.addInfoSource(infoSource);
//		保存成功进行提示
		request.setAttribute("message", "保存信息来源成功！");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}
	//查询所有的信息来源，封装到请求范围中，转向/manage/listInfoSource.jsp页面进行显示
	private void listAllInfoSources(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		List<InfoSource> infoSources = configService.findAllInfoSources();
		request.setAttribute("infoSources", infoSources);
		request.getRequestDispatcher("/manage/listInfoSource.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
